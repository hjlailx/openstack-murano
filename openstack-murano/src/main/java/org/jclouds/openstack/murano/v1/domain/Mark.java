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
 * Mark
 *
 * @author hjl
 */
public class Mark {
	
	private final String id;
	private final String type;
	private final String status;
	
	@ConstructorProperties({ "id", "type", "status"})
	protected Mark(String id, String type, String status) {
		this.id = id ;
		this.type = type ;
		this.status = status ;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Mark that = Mark.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.type, that.type)
				&& Objects.equal(this.status, that.status);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("type", type).add("status", status);
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
		
		protected String id;
		protected String type;
		protected String status;
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder type(String type) {
			this.type = type;
			return self();
		}
		
		public Builder status(String status) {
			this.status = status;
			return self();
		}
		
		public Mark build() {
			return new Mark(id, type, status);
		}

		public Builder fromCategory(Mark in) {
			return this.id(in.getId()).type(in.getType()).status(in.getStatus());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
