/*
 * 
 */
package com.blackducksoftware.notification.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blackducksoftware.integration.hub.builder.HubServerConfigBuilder;
import com.blackducksoftware.integration.hub.global.HubServerConfig;

/**
 * The Class NotificationConfig.
 */
@Configuration
@EnableConfigurationProperties
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
}
