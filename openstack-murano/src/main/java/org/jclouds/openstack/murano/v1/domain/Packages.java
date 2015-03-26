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
 * Packages
 *
 * @author hjl
 */
public class Packages {
	
	private final Set<Package> packages;

	@ConstructorProperties({ "packages"})
	protected Packages(Set<Package> packages) {
		this.packages = packages;
	}

	public Set<Package> getPackages() {
		return packages;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(packages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Packages that = Packages.class.cast(obj);
		return Objects.equal(this.packages, that.packages);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("packages", packages);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	public static Builder builder() {
		return new ConcreteBuilder();
	}

	public Builder toBuilder() {
		return new ConcreteBuilder().fromHealthMonitors(this);
	}

	public abstract static class Builder {
		protected abstract Builder self();
		
		protected Set<Package> packages;
		
		public Builder packages(Set<Package> packages) {
			this.packages = packages;
			return self();
		}
		public Packages build() {
			return new Packages(packages);
		}

		public Builder fromHealthMonitors(Packages in) {
			return this.packages(in.getPackages());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
