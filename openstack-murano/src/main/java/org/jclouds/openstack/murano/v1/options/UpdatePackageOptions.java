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
import java.util.Set;

import javax.inject.Inject;

import org.jclouds.http.HttpRequest;
import org.jclouds.openstack.murano.v1.domain.Operation;
import org.jclouds.rest.MapBinder;
import org.jclouds.rest.binders.BindToJsonPayload;

/**
 * @author hjl
 */
public class UpdatePackageOptions implements MapBinder {

	@Inject
	private BindToJsonPayload jsonBinder;

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromUpdateHealthmonitorOptions(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();
		
		protected Set<Operation> operations ;
		
		public T operations(Set<Operation> operations) {
			this.operations = operations;
			return self();
		}
		
		public UpdatePackageOptions build() {
			return new UpdatePackageOptions(operations);
		}

		public T fromUpdateHealthmonitorOptions(UpdatePackageOptions options) {
			return this.operations(options.getOperations());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private static class UpdatePackageRequest {
		protected Set<Operation> operations ;
	}

	private final Set<Operation> operations ;

	protected UpdatePackageOptions() {
		this.operations = null ;
	}

	public UpdatePackageOptions(Set<Operation> operations) {
		this.operations = operations ;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		UpdatePackageRequest updatePackageRequest = new UpdatePackageRequest();

		if (this.operations != null)
			updatePackageRequest.operations = this.operations ;

		return bindToRequest(request,updatePackageRequest);
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
