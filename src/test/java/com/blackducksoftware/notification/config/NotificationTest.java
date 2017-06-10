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

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blackducksoftware.notification.Application;

/**
 * The Class NotificationTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest(classes = { Application.class })
@Ignore 
public class NotificationTest {

	/** The notification config. */
	@Autowired
	private BatchConfig notificationConfig;
	
	/**
	 * Test job.
	 *
	 * @throws Exception the exception
	 */
	//@Test
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