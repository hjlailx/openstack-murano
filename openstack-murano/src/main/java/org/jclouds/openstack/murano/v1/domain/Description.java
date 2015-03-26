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
public class Description {
	
	private final String name ;
	private final Set<Service> services;
	private final DefaultNetwork defaultNetworks;
	private final Mark mark ;
	
	@ConstructorProperties({ "name" , "services", "defaultNetworks", "mark"})
	protected Description(String name, Set<Service> services, DefaultNetwork defaultNetworks, Mark mark) {
		this.name = name ;
		this.services = services ;
		this.defaultNetworks = defaultNetworks;
		this.mark = mark ;
	}

	public String getName() {
		return name;
	}

	public Set<Service> getServices() {
		return services;
	}

	public DefaultNetwork getDefaultNetworks() {
		return defaultNetworks;
	}

	public Mark getMark() {
		return mark;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Description that = Description.class.cast(obj);
		return Objects.equal(this.name, that.name)
				&&Objects.equal(this.services, that.services)
				&&Objects.equal(this.defaultNetworks, that.defaultNetworks)
				&&Objects.equal(this.mark, that.mark);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("name", name).add("services", services)
				.add("defaultNetworks", defaultNetworks).add("mark", mark);
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
		
		protected String name ;
		protected Set<Service> services;
		protected DefaultNetwork defaultNetworks;
		protected Mark mark ;
		
		public Builder name(String name) {
			this.name = name;
			return self();
		}
		
		public Builder services(Set<Service> services) {
			this.services = services;
			return self();
		}
		
		public Builder defaultNetworks(DefaultNetwork defaultNetworks) {
			this.defaultNetworks = defaultNetworks;
			return self();
		}
		
		public Builder mark(Mark mark) {
			this.mark = mark;
			return self();
		}
		
		public Description build() {
			return new Description(name, services, defaultNetworks, mark);
		}

		public Builder fromCategory(Description in) {
			return this.name(in.getName()).services(in.getServices())
					.defaultNetworks(in.getDefaultNetworks()).mark(in.getMark());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
