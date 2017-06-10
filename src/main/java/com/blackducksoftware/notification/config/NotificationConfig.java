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
package com.blackducksoftware.notification.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blackducksoftware.integration.hub.builder.HubServerConfigBuilder;
import com.blackducksoftware.integration.hub.global.HubServerConfig;
import com.blackducksoftware.integration.hub.rest.CredentialsRestConnection;
import com.blackducksoftware.integration.hub.rest.RestConnection;
import com.blackducksoftware.integration.hub.service.HubServicesFactory;
import com.blackducksoftware.integration.log.LogLevel;
import com.blackducksoftware.integration.log.PrintStreamIntLogger;

/**
 * The Class NotificationConfig.
 */
@Configuration
@EnableConfigurationProperties
@RefreshScope
public class NotificationConfig {

	/** The username. */
	@Value("${hub.username}")
	public String username;

	/** The password. */
	@Value("${hub.password}")
	public String password;

	/** The timeout. */
	@Value("${hub.timeout}")
	public String timeout;

	/** The serverurl. */
	@Value("${hub.serverurl}")
	public String serverurl;

	/** The cron expression. */
	@Value("${hub.cronExpression}")
	public String cronExpression;

	/**
	 * Gets the hub server config.
	 *
	 * @return the hub server config
	 */
	@Bean
	public HubServerConfig getHubServerConfig() {
		HubServerConfigBuilder builder = new HubServerConfigBuilder();
		builder.setHubUrl(this.serverurl);
		builder.setUsername(this.username);
		builder.setPassword(this.password);
		builder.setTimeout(this.timeout);
		return builder.build();
	}
	
	/**
	 * Gets the cron expression.
	 *
	 * @return the cron expression
	 */
	@Bean
	public String getCronExpression() {
		return cronExpression;
	}
	
	
	/**
	 * Gets the rest connection.
	 *
	 * @return the rest connection
	 * @throws Exception the exception
	 */
	@Bean
	public RestConnection getRestConnection() throws Exception{		
		return new CredentialsRestConnection(new PrintStreamIntLogger(System.out, LogLevel.TRACE),
				this.getHubServerConfig().getHubUrl(), 
				this.getHubServerConfig().getGlobalCredentials().getUsername(), 
				this.getHubServerConfig().getGlobalCredentials().getDecryptedPassword(),
                this.getHubServerConfig().getTimeout());
	}
	
	 /**
 	 * Gets the hub services factory.
 	 *
 	 * @return the hub services factory
 	 * @throws Exception the exception
 	 */
	@Bean
 	public  HubServicesFactory getHubServicesFactory() throws Exception {
	    return new HubServicesFactory(getRestConnection());
	}
	
}
