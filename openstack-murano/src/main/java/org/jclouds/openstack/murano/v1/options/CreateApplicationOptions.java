/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jclouds.openstack.murano.v1.options;

import java.util.Map;

import javax.inject.Inject;

import org.jclouds.http.HttpRequest;
import org.jclouds.openstack.murano.v1.domain.Instance;
import org.jclouds.openstack.murano.v1.domain.Mark;
import org.jclouds.rest.MapBinder;
import org.jclouds.rest.binders.BindToJsonPayload;

/**
 * @author hjl
 */
public class CreateApplicationOptions implements MapBinder {

	@Inject
	private BindToJsonPayload jsonBinder;

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromCreateApplicationOptions(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected Instance instance ;
		protected String name;
		protected Mark mark ;
		
		public T instance(Instance instance) {
			this.instance = instance;
			return self();
		}
		
		public T name(String name) {
			this.name = name;
			return self();
		}
		
		public T mark(Mark mark) {
			this.mark = mark;
			return self();
		}

		public CreateApplicationOptions build() {
			return new CreateApplicationOptions(instance, name, mark);
		}

		public T fromCreateApplicationOptions(CreateApplicationOptions in) {
			return this.instance(in.getInstance()).name(in.getName()).mark(in.getMark());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	protected static class CreateApplicationRequest {
		
		protected Instance instance ;
		protected String name;
		protected Mark mark ;

	}

	private final Instance instance ;
	private final String name;
	private final Mark mark ;

	public CreateApplicationOptions(Instance instance, String name, Mark mark) {
		this.instance = instance;
		this.name = name;
		this.mark = mark ;
	}

	public Instance getInstance() {
		return instance;
	}

	public String getName() {
		return name;
	}

	public Mark getMark() {
		return mark;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		CreateApplicationRequest createApplicationRequest = new CreateApplicationRequest() ;

		if(this.instance != null)
			createApplicationRequest.instance = this.instance ;
		if(this.name != null)
			createApplicationRequest.name = this.name ;
		if(this.mark != null)
			createApplicationRequest.mark = this.mark ;

		return bindToRequest(request, createApplicationRequest);
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
