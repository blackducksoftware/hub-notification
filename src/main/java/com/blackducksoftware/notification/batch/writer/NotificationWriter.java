/*
 * 
 */
package com.blackducksoftware.notification.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.blackducksoftware.integration.hub.dataservice.notification.NotificationResults;

/**
 * The Class NotificationWriter.
 */
public class NotificationWriter implements ItemWriter<NotificationResults>  {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(NotificationWriter.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 */
	@Override
	public void write(List<? extends NotificationResults> items) throws Exception {
		log.info("NO OP");
		
	}

}
