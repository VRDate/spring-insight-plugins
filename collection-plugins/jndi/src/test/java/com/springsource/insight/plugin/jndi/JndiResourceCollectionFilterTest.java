/**
 * Copyright 2009-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.springsource.insight.plugin.jndi;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */
public class JndiResourceCollectionFilterTest extends Assert {
	public JndiResourceCollectionFilterTest() {
		super();
	}

	@Test
	public void testDefaultExclusion () {
		JndiResourceCollectionFilter	filter=new JndiResourceCollectionFilter(null);
		for (String suffix : JndiResourceCollectionFilter.DEFAULT_EXCLUSION_PATTERNS) {
			boolean	result=filter.accept("testDefaultExclusion." + suffix);
			assertFalse("Default excluded suffix passed: " + suffix, result);
		}

		for (String resourcePath : new String[] { getClass().getName(), "testDefaultExclusion", "foo.txt", "bar.doc" }) {
			boolean	result=filter.accept(resourcePath);
			assertTrue("Resource not accepted: " + resourcePath, result);
		}
	}
}