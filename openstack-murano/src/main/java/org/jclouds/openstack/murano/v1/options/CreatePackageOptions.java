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
import org.jclouds.rest.MapBinder;
import org.jclouds.rest.binders.BindToJsonPayload;

/**
 * @author hjl
 */
public class CreatePackageOptions implements MapBinder {

	@Inject
	private BindToJsonPayload jsonBinder;

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromCreatePackageOptions(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected Set<String> categories ;
		protected Set<String> tags;
		protected String name ;
		protected String description ;
		protected Boolean isPublic ;
		protected Boolean enabled ;
		
		public T categories(Set<String> categories) {
			this.categories = categories;
			return self();
		}
		
		public T tags(Set<String> tags) {
			this.tags = tags;
			return self();
		}
		
		public T name(String name) {
			this.name = name;
			return self();
		}
		
		public T description(String description) {
			this.description = description;
			return self();
		}
		
		public T isPublic(Boolean isPublic) {
			this.isPublic = isPublic;
			return self();
		}
		
		public T enabled(Boolean enabled) {
			this.enabled = enabled;
			return self();
		}

		public CreatePackageOptions build() {
			return new CreatePackageOptions(categories, tags, name, description, isPublic, enabled);
		}

		public T fromCreatePackageOptions(CreatePackageOptions in) {
			return this.categories(in.getCategories()).tags(in.getTags()).name(in.getName())
					.description(in.getDescription()).isPublic(in.getIsPublic()).enabled(in.getEnabled());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	protected static class CreatePackageRequest {
		
		protected Set<String> categories ;
		protected Set<String> tags;
		protected String name ;
		protected String description ;
		protected Boolean isPublic ;
		protected Boolean enabled ;

	}

	private final Set<String> categories ;
	private final Set<String> tags;
	private final String name ;
	private final String description ;
	private final Boolean isPublic ;
	private final Boolean enabled ;

	public CreatePackageOptions(Set<String> categories, Set<String> tags, String name, String description, Boolean isPublic, Boolean enabled) {
		this.categories = categories;
		this.tags = tags;
		this.name = name ;
		this.description = description;
		this.isPublic = isPublic;
		this.enabled = enabled ;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public Set<String> getTags() {
		return tags;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request,
			Map<String, Object> postParams) {
		CreatePackageRequest createPackageRequest = new CreatePackageRequest() ;

		if(this.categories != null)
			createPackageRequest.categories = this.categories ;
		if(this.tags != null)
			createPackageRequest.tags = this.tags ;
		if(this.name != null && this.name != "")
			createPackageRequest.name = this.name ;
		if(this.description != null && this.description != "")
			createPackageRequest.name = this.name ;
		if(this.isPublic != null)
			createPackageRequest.isPublic = this.isPublic ;
		if(this.enabled != null)
			createPackageRequest.enabled = this.enabled ;

		return bindToRequest(request, createPackageRequest);
	}

	@Override
	public <R extends HttpRequest> R bindToRequest(R request, Object input) {
		return jsonBinder.bindToRequest(request, input);
	}

}
