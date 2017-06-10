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
 * Sat Jun 10 07:53:04 GMT 2017
 */

package com.blackducksoftware.notification.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.dozer.DozerBeanMapper;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;

import com.google.gson.Gson;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class JMSConfig_ESTest extends JMSConfig_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      JMSConfig jMSConfig0 = new JMSConfig();
      ActiveMQConnectionFactory activeMQConnectionFactory0 = jMSConfig0.getJMSConnectionFactory();
      assertEquals("vm://localhost", activeMQConnectionFactory0.getBrokerURL());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      JMSConfig jMSConfig0 = new JMSConfig();
      JmsTemplate jmsTemplate0 = jMSConfig0.getBomComponenentsTemplate();
      assertEquals(120000L, jmsTemplate0.getTimeToLive());
      assertTrue(jmsTemplate0.isExplicitQosEnabled());
      assertEquals("com.blackducksoftware.notified.projects.bom.components", jmsTemplate0.getDefaultDestinationName());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      JMSConfig jMSConfig0 = new JMSConfig();
      DozerBeanMapper dozerBeanMapper0 = jMSConfig0.getDozerBeanMapper();
      assertNotNull(dozerBeanMapper0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      JMSConfig jMSConfig0 = new JMSConfig();
      Gson gson0 = jMSConfig0.getGson();
      assertTrue(gson0.htmlSafe());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      JMSConfig jMSConfig0 = new JMSConfig();
      String string0 = jMSConfig0.getNotificationResultsQueue();
      assertEquals("com.blackducksoftware.notification.results", string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      JMSConfig jMSConfig0 = new JMSConfig();
      JmsTemplate jmsTemplate0 = jMSConfig0.getNotificationResultsTemplate();
      assertEquals(120000L, jmsTemplate0.getTimeToLive());
      assertEquals("com.blackducksoftware.notification.results", jmsTemplate0.getDefaultDestinationName());
      assertTrue(jmsTemplate0.isExplicitQosEnabled());
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      JMSConfig jMSConfig0 = new JMSConfig();
      String string0 = jMSConfig0.getNotifiedProjectsBomComponentsQueue();
      assertEquals("com.blackducksoftware.notified.projects.bom.components", string0);
  }
}