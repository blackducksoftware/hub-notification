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
 * Sat Jun 10 07:55:11 GMT 2017
 */

package com.blackducksoftware.notification.batch.reader;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.blackducksoftware.notification.config.JMSConfig;
import com.blackducksoftware.notification.config.NotificationConfig;
import com.blackducksoftware.notification.model.DateRange;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class NotificationReader_ESTest extends NotificationReader_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      JMSConfig jMSConfig0 = new JMSConfig();
      NotificationReader notificationReader0 = new NotificationReader((NotificationConfig) null, jMSConfig0);
      try { 
        notificationReader0.read();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.blackducksoftware.notification.batch.reader.NotificationReader", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      LogManager.setFactory((LoggerContextFactory) null);
      NotificationConfig notificationConfig0 = new NotificationConfig();
      JMSConfig jMSConfig0 = new JMSConfig();
      NotificationReader notificationReader0 = null;
      try {
        notificationReader0 = new NotificationReader(notificationConfig0, jMSConfig0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.logging.log4j.LogManager", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      NotificationConfig notificationConfig0 = new NotificationConfig();
      NotificationReader notificationReader0 = new NotificationReader(notificationConfig0, (JMSConfig) null);
      DateRange dateRange0 = notificationReader0.createDateRange();
      assertNotNull(dateRange0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      NotificationConfig notificationConfig0 = new NotificationConfig();
      JMSConfig jMSConfig0 = new JMSConfig();
      NotificationReader notificationReader0 = new NotificationReader(notificationConfig0, jMSConfig0);
      try { 
        notificationReader0.read();
        fail("Expecting exception: IllegalStateException");
      
      } catch(IllegalStateException e) {
         //
         // Invalid Configuration: USERNAME = com.blackducksoftware.integration.validator.ValidationResult@0000000015
         // PASSWORD = com.blackducksoftware.integration.validator.ValidationResult@0000000016
         // HUBURL = com.blackducksoftware.integration.validator.ValidationResult@0000000018
         // HUBTIMEOUT = com.blackducksoftware.integration.validator.ValidationResult@0000000019
         //
         verifyException("com.blackducksoftware.integration.builder.AbstractBuilder", e);
      }
  }
}