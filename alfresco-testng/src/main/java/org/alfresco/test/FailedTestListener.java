/*
 * Copyright (C) 2005-2015 Alfresco Software Limited.
 *
 * This file is part of Alfresco
 *
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 */
package org.alfresco.test;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

/**
 * Test Listener Adapter to listen for events that resulted in a test failing.
 * On a failure due to exception or assertion error the following will happen:
 * <ul>
 *  <li> Screen grab of the page the test failed on. </li>
 *  <li> Scrape of HTML source on the failed page </li>
 * </ul>
 * don't forget to call super equivalent method.
 * Add {@link Listeners} annotation in the expected class.
 *
 * @author Shan Nagarajan
 * @author Michael Suzuki
 * @since  1.6.1
 */

public class FailedTestListener extends TestListenerAdapter
{
    private static Log logger = LogFactory.getLog(FailedTestListener.class);
    /**
     * On Assert Failure this method will be called to take screen shot
     * and call the super method on {@link TestListenerAdapter}.
     */
    @Override
    public void onTestFailure(ITestResult tr) 
    {
        captureFailure(tr);
        super.onTestFailure(tr);
    }
    
    @Override
    public void onConfigurationFailure(ITestResult itr)
    {
        captureFailure(itr);
        super.onConfigurationFailure(itr);
    }
    /**
     * Capture Html source along with screen shot of failing test.
     * @param tr test result
     */
    private void captureFailure(ITestResult tr)
    {
        if(tr == null)
        {
            throw new IllegalArgumentException("Test result test can not be null");
        }
        Object instace = tr.getInstance();
        if (instace instanceof AlfrescoTests)
        {
            AlfrescoTests abstractTest = (AlfrescoTests) instace;
            String fileName = tr.getInstanceName() + "." + tr.getName();
            if(logger.isTraceEnabled())
            {
                logger.trace("File Name to be save Screen Shot & Source : " + fileName);
            }
            try
            {
                abstractTest.saveScreenShot(fileName);
            }
            catch (IOException e)
            {
                logger.error("Not able to take screen shot for the method : " + fileName, e);
            }
            try
            {
                abstractTest.savePageSource(fileName);
            }
            catch (IOException e)
            {
                logger.error("Not able to save page source for the method : " + fileName, e);
            }
        }
    }
}