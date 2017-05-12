/*
 * 
 */
package com.blackducksoftware.notification.config;

import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The Class BatchSchedulerConfig.
 */
@Configuration
@EnableScheduling
public class BatchSchedulerConfig {

    /**
     * Transaction manager.
     *
     * @return the resourceless transaction manager
     */
    @Bean
    public ResourcelessTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    /**
     * Map job repository factory.
     *
     * @param txManager the tx manager
     * @return the map job repository factory bean
     * @throws Exception the exception
     */
    @Bean
    public MapJobRepositoryFactoryBean mapJobRepositoryFactory(
            ResourcelessTransactionManager txManager) throws Exception {
        MapJobRepositoryFactoryBean factory = new 
                MapJobRepositoryFactoryBean(txManager);
        factory.afterPropertiesSet();
        return factory;
    }

    /**
     * Job repository.
     *
     * @param factory the factory
     * @return the job repository
     * @throws Exception the exception
     */
    @Bean
    public JobRepository jobRepository(
            MapJobRepositoryFactoryBean factory) throws Exception {
        return factory.getObject();
    }

    /**
     * Job launcher.
     *
     * @param jobRepository the job repository
     * @return the simple job launcher
     */
    @Bean
    public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository(jobRepository);
        return launcher;
    }

}