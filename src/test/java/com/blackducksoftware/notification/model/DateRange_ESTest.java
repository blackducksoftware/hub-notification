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
 * Sat Jun 10 07:52:20 GMT 2017
 */

package com.blackducksoftware.notification.model;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.Date;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true) 
public class DateRange_ESTest extends DateRange_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MockDate mockDate0 = new MockDate((-1531L));
      DateRange dateRange0 = new DateRange(mockDate0, mockDate0);
      Date date0 = dateRange0.getStart();
      assertSame(date0, mockDate0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      MockDate mockDate0 = new MockDate((-1531L));
      DateRange dateRange0 = new DateRange(mockDate0, mockDate0);
      Date date0 = dateRange0.getEnd();
      assertSame(mockDate0, date0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      DateRange dateRange0 = new DateRange((Date) null, (Date) null);
      Date date0 = dateRange0.getStart();
      assertNull(date0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      DateRange dateRange0 = new DateRange((Date) null, (Date) null);
      Date date0 = dateRange0.getEnd();
      assertNull(date0);
  }
}
