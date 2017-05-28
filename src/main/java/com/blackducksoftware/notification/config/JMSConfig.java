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
package com.blackducksoftware.notification.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.dozer.DozerBeanMapper;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.core.JmsTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * The Class JMSConfig.
 */
@Configuration
@RefreshScope
public class JMSConfig {
	
	/** The Constant DEFAULT_BROKER_URL. */
	private static final String DEFAULT_BROKER_URL = "vm://localhost";
    
    /** The Constant NOTIFICATION_RESULTS_QUEUE. */
    private static final String NOTIFICATION_RESULTS_QUEUE = "com.blackducksoftware.notification.results";
    
    /** The Constant NOTIFIED_PROJECTS_BOM_COMPONENTS_QUEUE. */
    private static final String NOTIFIED_PROJECTS_BOM_COMPONENTS_QUEUE = "com.blackducksoftware.notified.projects.bom.components";
 
    /**
     * Gets the JMS connection factory.
     *
     * @return the JMS connection factory
     */
    @Bean
    @Primary
    public ActiveMQConnectionFactory  getJMSConnectionFactory(){
        return new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);
    }
     
    /**
     * Gets the notification results template.
     *
     * @return the notification results template
     */
    @Bean
    public JmsTemplate getNotificationResultsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(getJMSConnectionFactory());
        template.setDefaultDestinationName(NOTIFICATION_RESULTS_QUEUE);
        template.setExplicitQosEnabled(true);
        //Give the messages two minutes before setting them expired
        template.setTimeToLive(1000l * 60 *  2);
        return template;
    }
    
    /**
     * Gets the bom componenents template.
     *
     * @return the bom componenents template
     */
    @Bean
    public JmsTemplate getBomComponenentsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(getJMSConnectionFactory());
        template.setDefaultDestinationName(NOTIFIED_PROJECTS_BOM_COMPONENTS_QUEUE);
        template.setExplicitQosEnabled(true);
        //Give the messages two minutes before setting them expired
        template.setTimeToLive(1000l * 60 *  2);
        return template;
    }
    
    /**
     * Gets the notification results queue.
     *
     * @return the notification results queue
     */
    @Bean
    public String getNotificationResultsQueue() {
    	return NOTIFICATION_RESULTS_QUEUE;
    }
    
    /**
     * Gets the notified projects bom components queue.
     *
     * @return the notified projects bom components queue
     */
    @Bean
    public String getNotifiedProjectsBomComponentsQueue() {
    	return NOTIFIED_PROJECTS_BOM_COMPONENTS_QUEUE;
    }
    
    /**
     * Gets the gson.
     *
     * @return the gson
     */
    @Bean
    public Gson getGson() {
    	return new GsonBuilder().create();
    }

    @Bean
    public DozerBeanMapper getDozerBeanMapper() {
    	return new DozerBeanMapper();
    }
    
    
}
