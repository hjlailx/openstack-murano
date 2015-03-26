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
 * Instance
 *
 * @author hjl
 */
public class Instance {
	
	private final String flavor;
	private final String image;
	private final String name;
	private final Set<String> ipAddresses ;
	private final Mark mark ;
	
	@ConstructorProperties({ "flavor", "image", "name", "ipAddresses", "mark"})
	protected Instance(String flavor, String image, String name, Set<String> ipAddresses, Mark mark) {
		this.flavor = flavor;
		this.image = image;
		this.name = name;
		this.ipAddresses = ipAddresses;
		this.mark = mark;
	}

	public String getFlavor() {
		return flavor;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public Set<String> getIpAddresses() {
		return ipAddresses;
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
		Instance that = Instance.class.cast(obj);
		return Objects.equal(this.flavor, that.flavor)
				&& Objects.equal(this.image, that.image)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.ipAddresses, that.ipAddresses)
				&& Objects.equal(this.mark, that.mark);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("flavor", flavor)
				.add("image", image).add("name", name)
				.add("ipAddresses", ipAddresses).add("mark", mark);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	public static Builder builder() {
		return new ConcreteBuilder();
	}

	public Builder toBuilder() {
		return new ConcreteBuilder().fromInstance(this);
	}

	public abstract static class Builder {
		protected abstract Builder self();
		
		protected String flavor;
		protected String image;
		protected String name;
		protected Set<String> ipAddresses ;
		protected Mark mark ;
		
		public Builder flavor(String flavor) {
			this.flavor = flavor;
			return self();
		}
		
		public Builder image(String image) {
			this.image = image;
			return self();
		}
		
		public Builder name(String name) {
			this.name = name;
			return self();
		}
		
		public Builder ipAddresses(Set<String> ipAddresses) {
			this.ipAddresses = ipAddresses;
			return self();
		}
		
		public Builder mark(Mark mark) {
			this.mark = mark;
			return self();
		}
		
		public Instance build() {
			return new Instance(flavor, image, name, ipAddresses, mark);
		}

		public Builder fromInstance(Instance in) {
			return this.flavor(in.getFlavor()).image(in.getImage())
					.name(in.getName()).ipAddresses(in.getIpAddresses()).mark(in.getMark());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
