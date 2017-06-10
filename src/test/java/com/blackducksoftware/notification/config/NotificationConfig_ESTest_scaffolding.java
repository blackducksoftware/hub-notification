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
/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Sat Jun 10 07:53:53 GMT 2017
 */

package com.blackducksoftware.notification.config;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.evosuite.runtime.sandbox.Sandbox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

@EvoSuiteClassExclude
public class NotificationConfig_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.blackducksoftware.notification.config.NotificationConfig"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("user.country", "US"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.timezone", "America/New_York"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(NotificationConfig_ESTest_scaffolding.class.getClassLoader() ,
      "com.blackducksoftware.notification.config.NotificationConfig",
      "org.apache.commons.lang3.ObjectUtils$Null",
      "com.blackducksoftware.integration.hub.rest.TLSSocketFactory",
      "com.blackducksoftware.integration.log.IntLogger",
      "okhttp3.Authenticator",
      "com.blackducksoftware.integration.hub.builder.HubServerConfigBuilder",
      "com.blackducksoftware.integration.validator.FieldEnum",
      "org.apache.commons.lang3.StringUtils",
      "org.springframework.context.annotation.Scope",
      "org.springframework.cloud.context.config.annotation.RefreshScope",
      "okhttp3.RequestBody",
      "com.blackducksoftware.integration.hub.rest.exception.IntegrationRestException",
      "okhttp3.FormBody",
      "com.blackducksoftware.integration.hub.rest.RestConnection",
      "com.blackducksoftware.integration.hub.service.HubServicesFactory",
      "com.blackducksoftware.integration.hub.validator.HubProxyValidator",
      "org.apache.commons.lang3.ObjectUtils",
      "org.springframework.boot.context.properties.EnableConfigurationProperties",
      "com.blackducksoftware.integration.log.LogLevel",
      "com.blackducksoftware.integration.hub.global.HubCredentialsFieldEnum",
      "com.blackducksoftware.integration.hub.model.HubComponent",
      "okhttp3.CookieJar",
      "com.blackducksoftware.integration.hub.global.HubProxyInfo",
      "com.blackducksoftware.integration.builder.AbstractBuilder",
      "com.blackducksoftware.integration.validator.ValidationResults",
      "com.blackducksoftware.integration.hub.validator.HubServerConfigValidator",
      "org.springframework.context.annotation.ScopedProxyMode",
      "org.springframework.context.annotation.Import",
      "com.blackducksoftware.integration.validator.AbstractValidator",
      "com.blackducksoftware.integration.exception.IntegrationCertificateException",
      "org.springframework.context.annotation.Configuration",
      "org.springframework.stereotype.Component",
      "com.blackducksoftware.integration.hub.global.HubServerConfig",
      "com.blackducksoftware.integration.hub.global.HubServerConfigFieldEnum",
      "org.apache.commons.lang3.math.NumberUtils",
      "com.blackducksoftware.integration.validator.ValidationResult",
      "com.blackducksoftware.integration.exception.IntegrationException",
      "org.apache.commons.lang3.exception.CloneFailedException",
      "com.blackducksoftware.integration.log.PrintStreamIntLogger",
      "com.blackducksoftware.integration.hub.rest.CredentialsRestConnection",
      "com.blackducksoftware.integration.validator.ValidationResultEnum",
      "com.blackducksoftware.integration.hub.validator.HubCredentialsValidator"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(NotificationConfig_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.springframework.context.annotation.ScopedProxyMode",
      "org.springframework.beans.factory.annotation.Autowire",
      "com.blackducksoftware.integration.log.LogLevel",
      "com.blackducksoftware.integration.hub.rest.RestConnection",
      "com.blackducksoftware.integration.hub.rest.CredentialsRestConnection",
      "com.blackducksoftware.integration.hub.builder.HubServerConfigBuilder",
      "org.apache.commons.lang3.StringUtils",
      "com.blackducksoftware.integration.hub.validator.HubServerConfigValidator",
      "com.blackducksoftware.integration.hub.validator.HubProxyValidator",
      "com.blackducksoftware.integration.validator.ValidationResultEnum",
      "org.apache.commons.lang3.math.NumberUtils",
      "com.blackducksoftware.integration.hub.global.HubProxyInfo",
      "com.blackducksoftware.integration.hub.global.HubCredentialsFieldEnum",
      "com.blackducksoftware.integration.hub.global.HubServerConfigFieldEnum",
      "org.apache.commons.lang3.ObjectUtils$Null",
      "org.apache.commons.lang3.ObjectUtils"
    );
  }
}
