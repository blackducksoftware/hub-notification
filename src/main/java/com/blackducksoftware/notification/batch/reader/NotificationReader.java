/*
 * 
 */
package com.blackducksoftware.notification.batch.reader;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.blackducksoftware.integration.hub.dataservice.notification.NotificationDataService;
import com.blackducksoftware.integration.hub.dataservice.notification.NotificationResults;
import com.blackducksoftware.integration.hub.rest.RestConnection;
import com.blackducksoftware.notification.config.JMSConfig;
import com.blackducksoftware.notification.config.NotificationConfig;
import com.blackducksoftware.notification.model.DateRange;

/**
 * The Class NotificationReader.
 */
@Component
public class NotificationReader implements ItemReader<NotificationResults> {
	
	/** The notification config. */
	private NotificationConfig notificationConfig;
	
	/** The jms config. */
	private JMSConfig jmsConfig;
	
	/** The last run path. */
	private String lastRunPath;
	
	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(NotificationReader.class);
	
	/**
	 * Instantiates a new notification reader.
	 *
	 * @param notificationConfig the notification config
	 * @param jmsConfig the jms config
	 */
	public NotificationReader(NotificationConfig  notificationConfig, JMSConfig jmsConfig) {
		this.notificationConfig = notificationConfig;
		this.jmsConfig = jmsConfig;
		lastRunPath = findLastRunFilePath();
	}	


	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemReader#read()
	 */
	@Override
	public NotificationResults read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		DateRange dateRange = createDateRange();
		Date startDate = dateRange.getStart();
        Date endDate = dateRange.getEnd();
        startDate.setTime(startDate.getTime() - (60000));
        
		NotificationDataService notificationDataService = notificationConfig.getHubServicesFactory().
				createNotificationDataService(
						notificationConfig.getRestConnection().logger);
			
		NotificationResults  notificationResults = notificationDataService.getAllNotifications(
				startDate, endDate);
		
		if(notificationResults.getNotificationContentItems().isEmpty()) {
			return null;
		}
		logger.info("Item Count is ====> " + notificationResults.getNotificationContentItems().size());
		
		jmsConfig.getNotificationResultsTemplate().convertAndSend(jmsConfig.getGson().toJson(notificationResults));
		return notificationResults;
	}


	/**
	 * Find last run file path.
	 *
	 * @return the string
	 */
	private String findLastRunFilePath() {
        String path = "";
        try {
            final String configLocation = System.getProperty("/");
            final File file = new File(configLocation, "activation-lastrun.txt");
            path = file.getCanonicalPath();
        } catch (final IOException ex) {
            logger.error("Cannot find last run file path", ex);
        }
        return path;
    }

    /**
     * Creates the date range.
     *
     * @return the date range
     */
    public DateRange createDateRange() {
        final Date endDate = new Date();
        Date startDate = endDate;
        try {
            final File lastRunFile = new File(lastRunPath);
            if (lastRunFile.exists()) {
                final String lastRunValue = FileUtils.readFileToString(lastRunFile, "UTF-8");
                startDate = RestConnection.parseDateString(lastRunValue);
                startDate = new Date(startDate.getTime());
            } else {
                startDate = endDate;
            }
            FileUtils.write(lastRunFile, RestConnection.formatDate(endDate), "UTF-8");
        } catch (final Exception e) {
            logger.error("Error creating date range", e);
        }
        return new DateRange(startDate, endDate);
    }
	
}
