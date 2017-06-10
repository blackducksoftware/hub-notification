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
 * Fri Jun 09 11:21:17 GMT 2017
 */

package com.blackducksoftware.notification;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.evosuite.runtime.sandbox.Sandbox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

@EvoSuiteClassExclude
public class Application_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.blackducksoftware.notification.Application"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(Application_ESTest_scaffolding.class.getClassLoader() ,
      "org.springframework.util.ReflectionUtils$FieldFilter",
      "org.springframework.core.convert.support.ObjectToStringConverter",
      "org.springframework.aop.support.AopUtils",
      "org.springframework.core.env.PropertySource$ComparisonPropertySource",
      "org.springframework.boot.context.event.ApplicationReadyEvent",
      "org.springframework.context.ApplicationContextException",
      "org.springframework.context.event.SimpleApplicationEventMulticaster",
      "org.springframework.context.event.AbstractApplicationEventMulticaster$ListenerRetriever",
      "org.springframework.boot.context.event.ApplicationStartedEvent",
      "org.springframework.cloud.config.server.EnableConfigServer",
      "org.springframework.context.ApplicationEventPublisher",
      "org.springframework.core.convert.support.NumberToNumberConverterFactory",
      "org.springframework.util.ConcurrentReferenceHashMap$Segment$1",
      "org.springframework.boot.logging.logback.LogbackLoggingSystem",
      "org.springframework.core.NestedExceptionUtils",
      "org.springframework.core.io.Resource",
      "org.springframework.cloud.config.server.bootstrap.ConfigServerBootstrapApplicationListener",
      "org.springframework.util.ClassUtils",
      "org.springframework.core.SerializableTypeWrapper$DefaultTypeProvider",
      "org.springframework.core.convert.support.ArrayToObjectConverter",
      "org.springframework.core.convert.support.StringToBooleanConverter",
      "org.springframework.core.annotation.AnnotationUtils",
      "org.springframework.core.SerializableTypeWrapper$FieldTypeProvider",
      "org.springframework.util.StopWatch",
      "org.springframework.core.PriorityOrdered",
      "org.springframework.core.convert.support.DefaultConversionService$Jsr310ConverterRegistrar",
      "org.springframework.boot.SpringApplicationRunListeners",
      "org.springframework.beans.factory.support.BeanNameGenerator",
      "org.springframework.boot.ExitCodeGenerator",
      "org.springframework.core.annotation.AnnotationAwareOrderComparator",
      "org.springframework.context.ApplicationContextAware",
      "org.springframework.core.Ordered",
      "org.springframework.validation.Errors",
      "org.springframework.core.env.CommandLinePropertySource",
      "org.springframework.util.ConcurrentReferenceHashMap$Entry",
      "org.springframework.core.convert.support.StringToUUIDConverter",
      "org.springframework.util.ConcurrentReferenceHashMap$EntrySet",
      "org.springframework.boot.ApplicationArguments",
      "org.springframework.core.convert.TypeDescriptor$StreamDelegate",
      "org.springframework.boot.context.config.DelegatingApplicationContextInitializer",
      "org.springframework.core.env.ConfigurablePropertyResolver",
      "org.springframework.validation.BindingResult",
      "org.springframework.util.ConcurrentReferenceHashMap$TaskOption",
      "org.springframework.core.convert.support.CollectionToObjectConverter",
      "org.springframework.core.ResolvableTypeProvider",
      "org.springframework.util.ReflectionUtils$MethodCallback",
      "org.springframework.util.ConcurrentReferenceHashMap",
      "org.springframework.beans.factory.BeanFactoryAware",
      "org.springframework.boot.BeanDefinitionLoader",
      "org.springframework.core.io.support.EncodedResource",
      "org.springframework.core.env.EnvironmentCapable",
      "org.springframework.boot.autoconfigure.BackgroundPreinitializer",
      "org.springframework.core.convert.support.MapToMapConverter",
      "org.springframework.boot.context.ContextIdApplicationContextInitializer",
      "org.springframework.boot.CommandLineRunner",
      "org.springframework.core.convert.ConversionService",
      "org.springframework.context.MessageSource",
      "org.springframework.boot.autoconfigure.EnableAutoConfiguration",
      "org.springframework.util.ConcurrentReferenceHashMap$Entries",
      "org.springframework.core.DecoratingProxy",
      "org.springframework.beans.BeansException",
      "org.springframework.context.annotation.ComponentScan",
      "org.springframework.core.convert.support.GenericConversionService$ConvertersForPair",
      "org.springframework.boot.diagnostics.FailureAnalyzers",
      "org.springframework.context.Lifecycle",
      "org.springframework.context.ApplicationEvent",
      "org.springframework.core.ResolvableType$1",
      "org.springframework.beans.factory.BeanFactory",
      "org.springframework.core.annotation.AnnotationAttributes",
      "org.springframework.boot.context.event.ApplicationPreparedEvent",
      "org.springframework.core.convert.support.StringToCharacterConverter",
      "org.springframework.context.annotation.ComponentScan$Filter",
      "org.springframework.core.env.SimpleCommandLinePropertySource",
      "org.springframework.boot.SpringApplication",
      "org.springframework.core.io.support.PropertiesLoaderUtils",
      "org.springframework.core.convert.support.ByteBufferConverter",
      "org.springframework.core.env.PropertySource$StubPropertySource",
      "org.springframework.core.convert.TypeDescriptor$AnnotatedElementAdapter",
      "org.springframework.context.ConfigurableApplicationContext",
      "org.springframework.core.MethodParameter",
      "org.springframework.core.convert.converter.GenericConverter",
      "org.springframework.context.event.ApplicationEventMulticaster",
      "org.springframework.aop.AopInvocationException",
      "org.springframework.core.NestedRuntimeException",
      "org.springframework.core.io.ResourceLoader",
      "org.springframework.boot.ApplicationRunner",
      "org.springframework.core.convert.support.ArrayToArrayConverter",
      "org.springframework.core.convert.support.ObjectToCollectionConverter",
      "org.springframework.core.env.PropertySources",
      "org.springframework.core.convert.support.AbstractConditionalEnumConverter",
      "org.springframework.core.convert.support.PropertiesToStringConverter",
      "org.springframework.core.convert.support.CollectionToArrayConverter",
      "org.springframework.core.convert.Property",
      "org.springframework.core.convert.support.ObjectToObjectConverter",
      "org.springframework.boot.ClearCachesApplicationListener",
      "org.springframework.core.env.Environment",
      "org.springframework.core.ResolvableType$VariableResolver",
      "org.springframework.core.env.MutablePropertySources",
      "org.apache.commons.logging.impl.SLF4JLog",
      "org.springframework.beans.BeanUtils",
      "org.springframework.util.ConcurrentReferenceHashMap$SoftEntryReference",
      "org.springframework.beans.BeanInstantiationException",
      "org.springframework.core.convert.support.NumberToCharacterConverter",
      "org.springframework.core.io.UrlResource",
      "org.springframework.core.convert.support.GenericConversionService$ConverterAdapter",
      "org.springframework.core.convert.support.CharacterToNumberFactory",
      "org.springframework.boot.logging.AbstractLoggingSystem$LogLevels",
      "org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer",
      "org.springframework.beans.factory.Aware",
      "org.springframework.boot.logging.ClasspathLoggingApplicationListener",
      "org.springframework.boot.builder.ParentContextCloserApplicationListener",
      "org.springframework.core.SerializableTypeWrapper$2",
      "org.springframework.core.annotation.AnnotationUtils$AnnotationCacheKey",
      "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration",
      "org.springframework.aop.TargetClassAware",
      "org.springframework.context.event.AbstractApplicationEventMulticaster$ListenerCacheKey",
      "org.springframework.core.convert.support.ArrayToStringConverter",
      "org.springframework.boot.logging.Slf4JLoggingSystem",
      "org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener",
      "org.springframework.context.event.ApplicationContextEvent",
      "org.springframework.core.convert.converter.Converter",
      "org.springframework.boot.logging.LoggingInitializationContext",
      "org.springframework.context.event.GenericApplicationListener",
      "org.springframework.core.annotation.AliasFor",
      "org.springframework.boot.logging.logback.LogbackLoggingSystem$1",
      "org.springframework.beans.FatalBeanException",
      "org.springframework.boot.Banner",
      "org.springframework.core.ResolvableType$DefaultVariableResolver",
      "org.springframework.core.convert.support.ZonedDateTimeToCalendarConverter",
      "org.springframework.cloud.bootstrap.BootstrapApplicationListener",
      "org.springframework.context.annotation.ScopedProxyMode",
      "org.springframework.core.convert.converter.ConverterFactory",
      "org.springframework.boot.SpringApplicationRunListener",
      "org.springframework.core.convert.support.StringToCollectionConverter",
      "org.springframework.core.SerializableTypeWrapper",
      "org.springframework.core.SerializableTypeWrapper$TypeProxyInvocationHandler",
      "org.springframework.cloud.bootstrap.BootstrapApplicationListener$ExtendedDefaultPropertySource",
      "org.springframework.core.ResolvableType$TypeVariablesVariableResolver",
      "org.springframework.core.SerializableTypeWrapper$1",
      "org.springframework.context.event.ContextRefreshedEvent",
      "org.springframework.context.annotation.ScopeMetadataResolver",
      "org.springframework.util.ReflectionUtils",
      "org.springframework.core.OrderComparator$OrderSourceProvider",
      "org.springframework.boot.autoconfigure.logging.AutoConfigurationReportLoggingInitializer",
      "org.springframework.boot.context.embedded.ServerPortInfoApplicationContextInitializer",
      "org.springframework.core.io.support.ResourcePatternResolver",
      "org.springframework.core.type.AnnotatedTypeMetadata",
      "org.springframework.context.ApplicationContextInitializer",
      "org.springframework.boot.logging.LoggerConfiguration",
      "org.springframework.util.Assert",
      "org.springframework.core.convert.support.ConfigurableConversionService",
      "org.springframework.core.convert.support.StringToCharsetConverter",
      "org.springframework.util.ReflectionUtils$FieldCallback",
      "org.springframework.core.convert.support.StringToNumberConverterFactory",
      "org.springframework.core.convert.support.GenericConversionService$ConverterFactoryAdapter",
      "org.springframework.util.ErrorHandler",
      "org.springframework.core.env.PropertyResolver",
      "org.springframework.aop.framework.AopProxyUtils",
      "org.springframework.core.io.support.SpringFactoriesLoader",
      "org.springframework.util.ConcurrentReferenceHashMap$WeakEntryReference",
      "org.springframework.core.annotation.AnnotationConfigurationException",
      "org.springframework.core.convert.support.StringToEnumConverterFactory",
      "org.springframework.core.convert.converter.ConverterRegistry",
      "org.springframework.boot.context.event.ApplicationStartingEvent",
      "org.springframework.core.env.CompositePropertySource",
      "org.springframework.boot.SpringBootExceptionHandler",
      "org.springframework.core.convert.support.GenericConversionService$NoOpConverter",
      "org.springframework.core.convert.support.ObjectToArrayConverter",
      "org.springframework.boot.logging.LoggerConfigurationComparator",
      "org.springframework.util.CollectionUtils",
      "org.springframework.core.io.InputStreamSource",
      "org.springframework.core.convert.support.EnumToStringConverter",
      "org.springframework.util.ConcurrentReferenceHashMap$Task",
      "com.blackducksoftware.notification.Application",
      "org.springframework.core.convert.support.DefaultConversionService",
      "org.springframework.beans.factory.ListableBeanFactory",
      "org.springframework.boot.builder.ParentContextApplicationContextInitializer",
      "org.springframework.boot.autoconfigure.AutoConfigurationPackage",
      "org.springframework.core.env.PropertySource",
      "org.springframework.context.event.GenericApplicationListenerAdapter",
      "org.springframework.boot.autoconfigure.condition.ConditionalOnClass",
      "org.springframework.aop.framework.Advised",
      "org.springframework.core.convert.support.CollectionToCollectionConverter",
      "org.springframework.core.env.EnumerablePropertySource",
      "org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer",
      "org.springframework.util.ConcurrentReferenceHashMap$ReferenceManager",
      "org.springframework.core.convert.ConverterNotFoundException",
      "org.springframework.context.event.ContextClosedEvent",
      "org.springframework.util.ConcurrentReferenceHashMap$ReferenceType",
      "org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent",
      "org.springframework.core.env.ConfigurableEnvironment",
      "org.springframework.core.convert.support.StringToLocaleConverter",
      "org.springframework.core.convert.support.FallbackObjectToStringConverter",
      "org.springframework.boot.context.FileEncodingApplicationListener",
      "org.springframework.util.ConcurrentReferenceHashMap$1",
      "org.springframework.util.ConcurrentReferenceHashMap$2",
      "org.springframework.util.ConcurrentReferenceHashMap$3",
      "org.springframework.boot.autoconfigure.SpringBootApplication",
      "org.springframework.util.ConcurrentReferenceHashMap$4",
      "org.springframework.core.convert.converter.ConditionalGenericConverter",
      "org.springframework.core.convert.support.EnumToIntegerConverter",
      "org.springframework.aop.SpringProxy",
      "org.springframework.boot.ExitCodeEvent",
      "org.apache.commons.logging.impl.SLF4JLocationAwareLog",
      "org.springframework.context.event.SmartApplicationListener",
      "org.springframework.beans.factory.config.BeanFactoryPostProcessor",
      "org.springframework.util.ObjectUtils",
      "org.springframework.boot.logging.logback.SpringBootJoranConfigurator",
      "org.springframework.context.annotation.Import",
      "org.springframework.util.MultiValueMap",
      "org.springframework.core.convert.support.GenericConversionService",
      "org.springframework.boot.logging.LogLevel",
      "org.springframework.core.OrderComparator",
      "org.springframework.util.ResourceUtils",
      "org.springframework.util.ReflectionUtils$MethodFilter",
      "org.springframework.core.convert.support.IdToEntityConverter",
      "org.springframework.boot.SpringBootConfiguration",
      "org.springframework.util.ConcurrentReferenceHashMap$5",
      "org.springframework.core.convert.support.IntegerToEnumConverterFactory",
      "org.springframework.util.LinkedMultiValueMap",
      "org.springframework.boot.logging.LoggingApplicationListener",
      "org.springframework.beans.factory.HierarchicalBeanFactory",
      "org.springframework.core.convert.ConversionFailedException",
      "org.springframework.boot.logging.LoggingSystem$NoOpLoggingSystem",
      "org.springframework.util.ConcurrentReferenceHashMap$Reference",
      "org.springframework.boot.context.config.DelegatingApplicationListener",
      "org.springframework.core.convert.support.StringToPropertiesConverter",
      "org.springframework.util.ConcurrentReferenceHashMap$Segment",
      "org.springframework.jms.annotation.EnableJms",
      "org.springframework.boot.Banner$Mode",
      "org.springframework.beans.factory.support.BeanDefinitionRegistry",
      "org.springframework.boot.context.config.AnsiOutputApplicationListener",
      "org.springframework.core.ResolvableType$SyntheticParameterizedType",
      "org.springframework.util.ReflectionUtils$4",
      "org.springframework.boot.logging.DeferredLog",
      "org.springframework.util.ReflectionUtils$6",
      "org.springframework.boot.context.event.EventPublishingRunListener",
      "org.springframework.util.ReflectionUtils$5",
      "org.springframework.core.ResolvableType",
      "org.springframework.core.annotation.SynthesizedAnnotation",
      "org.springframework.boot.env.EnvironmentPostProcessor",
      "org.springframework.core.convert.support.GenericConversionService$Converters",
      "org.springframework.core.convert.support.StringToTimeZoneConverter",
      "org.springframework.core.convert.support.ZoneIdToTimeZoneConverter",
      "org.springframework.core.convert.support.ArrayToCollectionConverter",
      "org.springframework.web.context.WebApplicationContext",
      "org.springframework.context.ApplicationListener",
      "org.springframework.core.convert.ConversionException",
      "org.springframework.util.ConcurrentReferenceHashMap$EntryIterator",
      "org.springframework.boot.logging.LogFile",
      "org.springframework.boot.context.event.ApplicationFailedEvent",
      "org.springframework.core.convert.support.StringToArrayConverter",
      "org.springframework.context.annotation.Configuration",
      "org.springframework.core.AliasRegistry",
      "org.springframework.core.convert.support.ObjectToOptionalConverter",
      "org.springframework.util.PropertiesPersister",
      "org.springframework.cloud.bootstrap.LoggingSystemShutdownListener",
      "org.springframework.core.annotation.AnnotationAttributeExtractor",
      "org.springframework.core.SerializableTypeWrapper$TypeProvider",
      "org.springframework.core.env.MapPropertySource",
      "org.springframework.context.annotation.AnnotationScopeMetadataResolver",
      "org.springframework.util.ConcurrentReferenceHashMap$Restructure",
      "org.springframework.beans.factory.BeanClassLoaderAware",
      "org.springframework.context.annotation.Conditional",
      "org.springframework.core.annotation.OrderUtils",
      "org.springframework.core.SerializableTypeWrapper$MethodParameterTypeProvider",
      "org.springframework.core.convert.support.ObjectToOptionalConverter$GenericTypeDescriptor",
      "org.springframework.core.ResolvableType$WildcardBounds",
      "org.springframework.core.SerializableTypeWrapper$MethodInvokeTypeProvider",
      "org.springframework.boot.logging.LoggingSystem",
      "org.springframework.context.event.AbstractApplicationEventMulticaster",
      "org.springframework.core.convert.support.StringToCurrencyConverter",
      "org.springframework.core.convert.converter.GenericConverter$ConvertiblePair",
      "org.springframework.core.io.AbstractFileResolvingResource",
      "org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer$Check",
      "org.springframework.core.convert.TypeDescriptor",
      "org.springframework.context.annotation.ComponentScans",
      "org.springframework.core.annotation.AnnotationUtils$AliasDescriptor",
      "org.springframework.core.SerializableTypeWrapper$SerializableTypeProxy",
      "org.springframework.validation.BindException",
      "org.springframework.cloud.context.restart.RestartListener",
      "org.springframework.boot.context.config.ConfigFileApplicationListener",
      "org.springframework.core.annotation.Order",
      "org.springframework.boot.builder.ParentContextApplicationContextInitializer$ParentContextAvailableEvent",
      "org.springframework.core.NestedIOException",
      "org.apache.commons.logging.impl.SLF4JLogFactory",
      "org.springframework.core.env.SystemEnvironmentPropertySource",
      "org.springframework.context.ApplicationContext",
      "org.springframework.web.context.ConfigurableWebApplicationContext",
      "org.springframework.core.io.AbstractResource",
      "org.springframework.core.convert.support.StreamConverter",
      "org.springframework.boot.context.event.SpringApplicationEvent",
      "org.springframework.stereotype.Component",
      "org.springframework.beans.factory.NoSuchBeanDefinitionException",
      "org.springframework.core.convert.converter.ConditionalConverter",
      "org.springframework.boot.logging.AbstractLoggingSystem",
      "org.springframework.core.convert.support.CollectionToStringConverter",
      "org.springframework.util.StringUtils"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(Application_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.springframework.context.annotation.ScopedProxyMode",
      "org.apache.commons.logging.impl.SLF4JLogFactory",
      "org.apache.commons.logging.impl.SLF4JLocationAwareLog",
      "org.springframework.boot.SpringApplication",
      "org.springframework.boot.Banner$Mode",
      "org.springframework.util.ClassUtils",
      "org.springframework.core.io.support.SpringFactoriesLoader",
      "org.springframework.util.StringUtils",
      "org.springframework.core.io.support.PropertiesLoaderUtils",
      "org.springframework.util.ResourceUtils",
      "org.springframework.util.ConcurrentReferenceHashMap$ReferenceType",
      "org.springframework.util.ConcurrentReferenceHashMap",
      "org.springframework.util.ConcurrentReferenceHashMap$Segment",
      "org.springframework.beans.BeanUtils",
      "org.springframework.util.ReflectionUtils",
      "org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer",
      "org.springframework.boot.context.ContextIdApplicationContextInitializer",
      "org.springframework.boot.context.config.DelegatingApplicationContextInitializer",
      "org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer",
      "org.springframework.core.OrderComparator",
      "org.springframework.core.annotation.AnnotationAwareOrderComparator",
      "org.springframework.core.annotation.OrderUtils",
      "org.springframework.core.annotation.AnnotationUtils",
      "org.springframework.util.ConcurrentReferenceHashMap$Restructure",
      "org.springframework.boot.context.FileEncodingApplicationListener",
      "org.springframework.boot.context.config.ConfigFileApplicationListener",
      "org.springframework.core.convert.support.GenericConversionService",
      "org.springframework.core.convert.support.DefaultConversionService",
      "org.springframework.core.ResolvableType",
      "org.springframework.util.ObjectUtils",
      "org.springframework.core.SerializableTypeWrapper",
      "org.springframework.core.SerializableTypeWrapper$DefaultTypeProvider",
      "org.springframework.core.SerializableTypeWrapper$2",
      "org.springframework.core.SerializableTypeWrapper$TypeProxyInvocationHandler",
      "org.springframework.util.ConcurrentReferenceHashMap$TaskOption",
      "org.springframework.core.ResolvableType$DefaultVariableResolver",
      "org.springframework.core.SerializableTypeWrapper$MethodInvokeTypeProvider",
      "org.springframework.core.convert.support.StringToBooleanConverter",
      "org.springframework.core.convert.support.CollectionToStringConverter",
      "org.springframework.core.convert.TypeDescriptor$AnnotatedElementAdapter",
      "org.springframework.core.convert.TypeDescriptor",
      "org.springframework.core.convert.support.StreamConverter",
      "org.springframework.core.convert.support.ByteBufferConverter",
      "org.springframework.core.convert.support.ObjectToObjectConverter",
      "org.springframework.boot.context.config.DelegatingApplicationListener",
      "org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener",
      "org.springframework.boot.logging.ClasspathLoggingApplicationListener",
      "org.springframework.util.LinkedMultiValueMap",
      "org.springframework.boot.logging.LogLevel",
      "org.springframework.boot.logging.LoggingApplicationListener",
      "org.springframework.cloud.config.server.bootstrap.ConfigServerBootstrapApplicationListener",
      "org.springframework.cloud.bootstrap.BootstrapApplicationListener",
      "org.springframework.cloud.bootstrap.LoggingSystemShutdownListener",
      "org.springframework.context.ApplicationEvent",
      "org.springframework.boot.context.event.SpringApplicationEvent",
      "org.springframework.boot.context.event.ApplicationStartingEvent",
      "org.springframework.boot.context.event.ApplicationStartedEvent",
      "org.springframework.core.SerializableTypeWrapper$1",
      "org.springframework.boot.logging.LoggingSystem",
      "org.springframework.boot.logging.AbstractLoggingSystem",
      "org.springframework.boot.logging.Slf4JLoggingSystem",
      "org.springframework.boot.logging.logback.LogbackLoggingSystem"
    );
  }
}
