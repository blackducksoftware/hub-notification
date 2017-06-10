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
 * This file was automatically generated by EvoSuite
 * Sat Jun 10 07:54:06 GMT 2017
 */

package com.blackducksoftware.notification.config;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Proxy;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class BatchSchedulerConfig_ESTest extends BatchSchedulerConfig_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      BatchSchedulerConfig batchSchedulerConfig0 = new BatchSchedulerConfig();
      try { 
        batchSchedulerConfig0.mapJobRepositoryFactory((ResourcelessTransactionManager) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // TransactionManager must not be null.
         //
         verifyException("org.springframework.util.Assert", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      BatchSchedulerConfig batchSchedulerConfig0 = new BatchSchedulerConfig();
      try { 
        batchSchedulerConfig0.getJobRepository((MapJobRepositoryFactoryBean) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.blackducksoftware.notification.config.BatchSchedulerConfig", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      BatchSchedulerConfig batchSchedulerConfig0 = new BatchSchedulerConfig();
      MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean0 = new MapJobRepositoryFactoryBean((PlatformTransactionManager) null);
      try { 
        batchSchedulerConfig0.getJobRepository(mapJobRepositoryFactoryBean0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // TransactionManager must not be null.
         //
         verifyException("org.springframework.util.Assert", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      BatchSchedulerConfig batchSchedulerConfig0 = new BatchSchedulerConfig();
      ResourcelessTransactionManager resourcelessTransactionManager0 = batchSchedulerConfig0.transactionManager();
      assertFalse(resourcelessTransactionManager0.isNestedTransactionAllowed());
  }
 
  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      BatchSchedulerConfig batchSchedulerConfig0 = new BatchSchedulerConfig();
      SimpleJobLauncher simpleJobLauncher0 = batchSchedulerConfig0.getJobLauncher((JobRepository) null);
      assertNotNull(simpleJobLauncher0);
  }
}