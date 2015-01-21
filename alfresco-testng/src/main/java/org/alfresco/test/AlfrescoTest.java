/*
 * Copyright (C) 2005-2014 Alfresco Software Limited.
 * This file is part of Alfresco
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 */
package org.alfresco.test;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * Annotation for Alfresco functional and regression tests,
 * holds additional information such as testlink id, jira and test id.
 * The identifiers are used to map test class to a test case in 
 * the test management system.
 * 
 * @author Michael Suzuki
 *
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE, CONSTRUCTOR})
public @interface  AlfrescoTest
{
    //Test identifier
    public String id() default "";
    //Test link identifier
    public String testlink() default "";
    //JIRA issue identifier
    public String jira() default "";
}
