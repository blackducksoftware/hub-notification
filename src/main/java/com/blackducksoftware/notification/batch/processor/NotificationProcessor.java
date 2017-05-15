/*
 * 
 */
package com.blackducksoftware.notification.batch.processor;

import java.util.SortedSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.blackducksoftware.integration.hub.dataservice.notification.NotificationResults;
import com.blackducksoftware.integration.hub.dataservice.notification.model.NotificationContentItem;
import com.blackducksoftware.integration.hub.rest.CredentialsRestConnection;
import com.blackducksoftware.integration.hub.rest.RestConnection;
import com.blackducksoftware.integration.hub.service.HubServicesFactory;
import com.blackducksoftware.integration.log.LogLevel;
import com.blackducksoftware.integration.log.PrintStreamIntLogger;
import com.blackducksoftware.notification.config.NotificationConfig;

/**
 * The Class NotificationProcessor.
 */
public class NotificationProcessor implements ItemProcessor<NotificationResults, NotificationResults> {
	
	/** The notification config. */
	private NotificationConfig notificationConfig;
	
	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(NotificationProcessor.class);
	
	/**
	 * Instantiates a new notification processor.
	 *
	 * @param notificationConfig the notification config
	 */
	public NotificationProcessor(NotificationConfig  notificationConfig) {
		this.notificationConfig = notificationConfig;
	}
	
	/**
	 * Gets the rest connection.
	 *
	 * @return the rest connection
	 * @throws Exception the exception
	 */
	public RestConnection getRestConnection() throws Exception{		
		return new CredentialsRestConnection(new PrintStreamIntLogger(System.out, LogLevel.INFO),
				notificationConfig.getHubServerConfig().getHubUrl(), 
				notificationConfig.getHubServerConfig().getGlobalCredentials().getUsername(), 
				notificationConfig.getHubServerConfig().getGlobalCredentials().getDecryptedPassword(),
                notificationConfig.getHubServerConfig().getTimeout());
	}
	
	 /**
 	 * Gets the hub services factory.
 	 *
 	 * @return the hub services factory
 	 * @throws Exception the exception
 	 */
 	public  HubServicesFactory getHubServicesFactory() throws Exception {
	        return new HubServicesFactory(getRestConnection());
	 }
	
	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
	 */
	@Override
	public NotificationResults process(NotificationResults item) throws Exception {
		SortedSet<NotificationContentItem>  contentItems = item.getNotificationContentItems();
		contentItems.forEach(contentItem -> {
			StringBuilder builder = new StringBuilder(1000);
			builder.append("\n\n Project Version : ");
			builder.append(contentItem.getProjectVersion() + "\n");
			builder.append("Created At : ");
			builder.append(contentItem.getCreatedAt() + "\n");
			builder.append("Component Issue Link : ");
			builder.append(contentItem.getComponentIssueLink() +"\n");
			builder.append("Component Name : ");
			builder.append(contentItem.getComponentName() + "\n");
			builder.append("Component Version : ");
			builder.append(contentItem.getComponentVersion() + "\n");
			builder.append("Component Version URL : ");
			builder.append(contentItem.getComponentVersionUrl() + "\n");
			builder.append("Created AT : ");
			builder.append(contentItem.getCreatedAt());
			builder.append("================================================= \n");
			logger.info(builder.toString());
		});
		return item;
	}

}
