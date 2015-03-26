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

import com.google.common.base.Objects;

/**
 * DefaultNetwork
 *
 * @author hjl
 */
public class DefaultNetwork {
	
	private final String flat ;
	private final Environment environment;
	
	@ConstructorProperties({ "flat", "environment"})
	protected DefaultNetwork(String flat, Environment environment) {
		this.flat = flat;
		this.environment = environment ;
	}

	public String getFlat() {
		return flat;
	}

	public Environment getEnvironment() {
		return environment;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		DefaultNetwork that = DefaultNetwork.class.cast(obj);
		return Objects.equal(this.flat, that.flat)
				&&Objects.equal(this.environment, that.environment);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("flat", flat).add("environment", environment);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	public static Builder builder() {
		return new ConcreteBuilder();
	}

	public Builder toBuilder() {
		return new ConcreteBuilder().fromDefaultNetwork(this);
	}

	public abstract static class Builder {
		protected abstract Builder self();
		
		protected String flat ;
		protected Environment environment;
		
		public Builder flat(String flat) {
			this.flat = flat;
			return self();
		}
		
		public Builder environment(Environment environment) {
			this.environment = environment;
			return self();
		}
		
		public DefaultNetwork build() {
			return new DefaultNetwork(flat, environment);
		}

		public Builder fromDefaultNetwork(DefaultNetwork in) {
			return this.flat(in.getFlat()).environment(in.getEnvironment());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
