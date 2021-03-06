/**
 * hub-notification
 *
 * Copyright (C) 2017 Black Duck Software, Inc.
 * http://www.blackducksoftware.com/
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
/*
 * 
 */
package com.blackducksoftware.notification.batch.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import com.blackducksoftware.integration.hub.dataservice.model.ProjectVersionModel;
import com.blackducksoftware.integration.hub.dataservice.notification.NotificationResults;
import com.blackducksoftware.integration.hub.dataservice.notification.model.NotificationContentItem;
import com.blackducksoftware.integration.hub.model.view.VulnerableComponentView;
import com.blackducksoftware.integration.hub.request.HubPagedRequest;
import com.blackducksoftware.integration.hub.service.HubResponseService;
import com.blackducksoftware.notification.config.JMSConfig;
import com.blackducksoftware.notification.config.NotificationConfig;

/**
 * The Class NotificationProcessor.
 */
public class NotificationProcessor implements ItemProcessor<NotificationResults, NotificationResults> {
	
	/** The notification config. */
	private NotificationConfig notificationConfig;
	
	/** The jms config. */
	private JMSConfig jmsConfig;
		
	private final Logger  logger = LogManager.getLogger(NotificationProcessor.class);
	
	/**
	 * Instantiates a new notification processor.
	 *
	 * @param notificationConfig the notification config
	 * @param jmsConfig the jms config
	 */
	public NotificationProcessor(NotificationConfig  notificationConfig, JMSConfig jmsConfig) {
		this.notificationConfig = notificationConfig;
		this.jmsConfig = jmsConfig;
	}
	
	
	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
	 */
	@Override
	public NotificationResults process(NotificationResults item) throws Exception {
		logger.info("Processing Notification Results ...............");
		SortedSet<NotificationContentItem>  contentItems = item.getNotificationContentItems();
		//Get a distinct list of Projects
		List<ProjectVersionModel> projectVersionItems = contentItems.stream().map(NotificationContentItem::getProjectVersion).
				filter(distinctByKey(p -> p.getProjectName() + " - " + p.getProjectVersionName())).collect(Collectors.toList());
		Map<String, String> vulnerableMap = new HashMap<>();
		projectVersionItems.forEach(projectVersionItem -> {
			String vulnerabilityLink = projectVersionItem.getVulnerableComponentsLink();
			logger.info(projectVersionItem.getProjectName() + " " + projectVersionItem.getProjectVersionName());
			logger.debug("Vulnerability Link " + vulnerabilityLink);
			try {
				HubResponseService hubResponseService = notificationConfig.getHubServicesFactory().createHubResponseService();
				long requestStartTime = System.currentTimeMillis();
				HubPagedRequest hubPagedRequest = hubResponseService.getHubRequestFactory().createPagedRequest(vulnerabilityLink);
				logger.debug("hubPagedRequest " + hubPagedRequest);
				List<VulnerableComponentView> compList = hubResponseService.getAllItems(hubPagedRequest, VulnerableComponentView.class);
				long requestEndTime = System.currentTimeMillis();
				logger.info("Time to complete BOM Component request " + (requestEndTime - requestStartTime) + " milliseconds");
				logger.debug(" Bom List " + compList);
				vulnerableMap.put(jmsConfig.getGson().toJson(projectVersionItem), jmsConfig.getGson().toJson(compList));
			} catch (Exception e) {
				logger.error("Exception Retrieving Bom Components for " + projectVersionItem.getRiskProfileLink(), e );
			}
		});
		jmsConfig.getBomComponenentsTemplate().convertAndSend(vulnerableMap);
		return item;
	}
	
	/**
	 * Distinct by key.
	 *
	 * @param <T> the generic type
	 * @param keyExtractor the key extractor
	 * @return the predicate
	 */
	public <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
