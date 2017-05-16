/*
 * 
 */
package com.blackducksoftware.notification.config;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.blackducksoftware.integration.hub.dataservice.notification.NotificationResults;
import com.blackducksoftware.notification.batch.processor.JobCompletionNotificationListener;
import com.blackducksoftware.notification.batch.processor.NotificationProcessor;
import com.blackducksoftware.notification.batch.reader.NotificationReader;
import com.blackducksoftware.notification.batch.writer.NotificationWriter;
/**
 * The Class BatchConfig.
 */
@Configuration
@EnableBatchProcessing
@RefreshScope
public class BatchConfig {
	
    /** The job launcher. */
    @Autowired
    private SimpleJobLauncher jobLauncher;

    /** The job builder factory. */
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    /** The step builder factory. */
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
 
    /** The listener. */
    @Autowired
    public JobCompletionNotificationListener listener;
    
    /** The notification config. */
    @Autowired
    public NotificationConfig notificationConfig;
    
    /** The jms config. */
    @Autowired
    public JMSConfig jmsConfig;
    
    
    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(BatchConfig.class);
    
    /**
     * Perform.
     *
     * @return the job execution
     * @throws Exception the exception
     */
    @Scheduled(cron = "#{@getCronExpression}")
    public JobExecution perform() throws Exception {
        log.info("Job Started at :  " + new Date());
        JobParameters param = new JobParametersBuilder().addString("JobID",
                String.valueOf(System.currentTimeMillis())).toJobParameters();
        JobExecution execution = jobLauncher.run(pollForNotificationJob(), param);
        log.info("Job finished with status :" + execution.getStatus());
        return execution;
    }

    /**
     * Gets the notification reader.
     *
     * @return the notification reader
     */
    @Bean
    public NotificationReader getNotificationReader() {
        return new NotificationReader(notificationConfig, jmsConfig);
    }
    
    /**
     * Gets the notification processor.
     *
     * @return the notification processor
     */
    @Bean
    public NotificationProcessor getNotificationProcessor() {
        return new NotificationProcessor(notificationConfig, jmsConfig);
    }
    
    /**
     * Gets the notification writer.
     *
     * @return the notification writer
     */
    @Bean
    public NotificationWriter getNotificationWriter() {
        return new NotificationWriter();
    }
    
    /**
     * Gets the task executor.
     *
     * @return the task executor
     */
    @Bean
    public TaskExecutor getTaskExecutor() {
    	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        return executor;
    }
    
    /**
     * Poll for notification job.
     *
     * @return the job
     */
    @Bean
    public Job pollForNotificationJob() {
        return jobBuilderFactory.get("pollForNotificationJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(pollingStep())
                .end().build();
    }

    /**
     * Polling step.
     *
     * @return the step
     */
    @Bean
    public Step pollingStep() {
        return stepBuilderFactory.get("pollingStep")
                .<NotificationResults, NotificationResults> chunk(1)
                .reader(getNotificationReader())
                .processor(getNotificationProcessor())
                .writer(getNotificationWriter())
                .taskExecutor(getTaskExecutor())
                .build();
    }
    
   
}
