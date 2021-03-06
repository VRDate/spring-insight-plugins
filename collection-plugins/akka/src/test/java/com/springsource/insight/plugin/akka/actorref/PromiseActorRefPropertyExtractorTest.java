/**
 * Copyright (c) 2009-2011 VMware, Inc. All Rights Reserved.
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
package com.springsource.insight.plugin.akka.actorref;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.RETURNS_DEFAULTS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;

import java.util.Collections;
import java.util.Map;

import org.junit.Test;

import akka.actor.ActorRefProvider;
import akka.dispatch.Promise;
import akka.pattern.PromiseActorRef;

public class PromiseActorRefPropertyExtractorTest {
	public PromiseActorRefPropertyExtractorTest() {
		super();
	}

    @Test
    public void testExtractProperties() {
	PromiseActorRef ref = createActorRef();
	Map<String, Object> result = PromiseActorRefPropertyExtractor.INSTANCE.extractProperties(ref);
	assertEquals("not the expected result", Collections.singletonMap("local", Boolean.TRUE), result);
    }

    private PromiseActorRef createActorRef() {
	ActorRefProvider refProvider = mock(ActorRefProvider.class, RETURNS_DEFAULTS);
	@SuppressWarnings("unchecked")
	Promise<Object> promise = mock(Promise.class, RETURNS_SMART_NULLS);

	PromiseActorRef ref = new PromiseActorRef(refProvider, promise);
	return ref;
    }

}
