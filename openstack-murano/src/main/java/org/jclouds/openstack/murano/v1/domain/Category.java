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

package org.jclouds.openstack.murano.v1.domain;

import java.beans.ConstructorProperties;
import java.util.Set;

import com.google.common.base.Objects;

/**
 * Category
 *
 * @author hjl
 */
public class Category {
	
	private final Set<String> categories;
	
	@ConstructorProperties({ "categories"})
	protected Category(Set<String> categories) {
		this.categories = categories;
	}

	public Set<String> getCategories() {
		return categories;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Category that = Category.class.cast(obj);
		return Objects.equal(this.categories, that.categories);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("categories", categories);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	public static Builder builder() {
		return new ConcreteBuilder();
	}

	public Builder toBuilder() {
		return new ConcreteBuilder().fromCategory(this);
	}

	public abstract static class Builder {
		protected abstract Builder self();
		
		protected Set<String> categories;
		
		public Builder categories(Set<String> categories) {
			this.categories = categories;
			return self();
		}
		
		public Category build() {
			return new Category(categories);
		}

		public Builder fromCategory(Category in) {
			return this.categories(in.getCategories());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
