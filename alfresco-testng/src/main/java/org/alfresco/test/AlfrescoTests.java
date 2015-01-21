/*
 * Copyright (C) 2005-2012 Alfresco Software Limited.
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

/**
 * Interface that represents the basic methods commonly used in
 * all AbstractTest classes in Alfresco. 
 *
 * @author Michael Suzuki
 */
public interface AlfrescoTests
{
    /**
     * Save image of screen called by the {@link FailedTestListener}.
     * This is applicable when used with selenium drivers that support a full browser.
     * @param methodName String name of method calling.
     * @throws IOException if error.
     */
    public abstract void saveScreenShot(final String methodName) throws IOException;
    /**
     * Save page source called by the {@link FailedTestListener}.
     * This is applicable when used with selenium drivers that support a full browser. 
     * @param methodName String name of method calling.
     * @throws IOException if error.
     */
    public abstract void savePageSource(final String methodName) throws IOException;
}
