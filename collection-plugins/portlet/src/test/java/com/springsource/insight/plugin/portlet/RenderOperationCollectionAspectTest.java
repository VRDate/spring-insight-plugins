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
package com.springsource.insight.plugin.portlet;

import org.junit.Test;

import com.springsource.insight.collection.OperationCollectionAspectSupport;
import com.springsource.insight.intercept.operation.Operation;

public class RenderOperationCollectionAspectTest extends GenericOperationCollectionTestSupport {
	public RenderOperationCollectionAspectTest () {
		super();
	}

	/*
	 * tests view render 
	 */
	@Test
	public void testView() throws Exception {
		// Step 1: Execute test
		tester.doView();
		validate("view");
	}
	
	/*
	 * tests edit render 
	 */
	@Test
	public void testEdit() throws Exception {
		// Step 1: Execute test
		tester.doEdit();
		validate("edit");
	}

	private Operation validate(String mode) {
		return validate(OperationCollectionTypes.RENDER_TYPE, mode);
	}
	
	@Override
	public OperationCollectionAspectSupport getAspect() {
		return RenderOperationCollectionAspect.aspectOf();
	}
}