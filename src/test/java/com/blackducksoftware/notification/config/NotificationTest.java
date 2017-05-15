package com.blackducksoftware.notification.config;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blackducksoftware.notification.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest(classes = { Application.class })
public class NotificationTest {

	@Autowired
	private BatchConfig notificationConfig;
	
	@Test
	public void testJob() throws Exception {
		JobExecution jobExecution = notificationConfig.perform();
		Assert.assertNotNull(jobExecution);

		BatchStatus batchStatus = jobExecution.getStatus();
		Assert.assertEquals(BatchStatus.COMPLETED, batchStatus);
		Assert.assertFalse(batchStatus.isUnsuccessful());

		ExitStatus exitStatus = jobExecution.getExitStatus();
		Assert.assertEquals("COMPLETED", exitStatus.getExitCode());
		Assert.assertEquals("", exitStatus.getExitDescription());

		List<Throwable> failureExceptions = jobExecution.getFailureExceptions();
		Assert.assertNotNull(failureExceptions);
		Assert.assertTrue(failureExceptions.isEmpty());
	}

}