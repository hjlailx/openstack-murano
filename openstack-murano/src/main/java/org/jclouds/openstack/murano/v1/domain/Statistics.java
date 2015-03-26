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
 * Statistics
 *
 * @author hjl
 */
public class Statistics {
	
	private final Integer type;
	private final String typeName ;
	private final String instanceId;
	private final Boolean active ;
	private final String typeTitle ;
	private final Integer duration ;
	

	@ConstructorProperties({ "type", "type_name","instance_id", "active", "type_title", "duration"})
	protected Statistics(Integer type, String typeName, String instanceId, Boolean active, String typeTitle, Integer duration) {
		this.type = type;
		this.typeName = typeName ;
		this.instanceId = instanceId;
		this.active = active ;
		this.typeTitle = typeTitle ;
		this.duration = duration ;
	}

	public Integer getType() {
		return type;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public Boolean getActive() {
		return active;
	}

	public String getTypeTitle() {
		return typeTitle;
	}

	public Integer getDuration() {
		return duration;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(type, typeName, instanceId, active,
				typeTitle, duration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Statistics that = Statistics.class.cast(obj);
		return Objects.equal(this.type, that.type)
				&& Objects.equal(this.typeName, that.typeName)
				&& Objects.equal(this.instanceId, that.instanceId)
				&& Objects.equal(this.active, that.active)
				&& Objects.equal(this.typeTitle, that.typeTitle)
				&& Objects.equal(this.duration, that.duration);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("type", type).add("typeName", typeName)
				.add("instanceId", instanceId).add("active", active)
				.add("typeTitle", typeTitle).add("duration", duration);
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
		
		protected Integer type;
		protected String typeName ;
		protected String instanceId;
		protected Boolean active ;
		protected String typeTitle ;
		protected Integer duration ;
		
		public Builder type(Integer type) {
			this.type = type;
			return self();
		}
		
		public Builder typeName(String typeName) {
			this.typeName = typeName;
			return self();
		}

		public Builder instanceId(String instanceId) {
			this.instanceId = instanceId;
			return self();
		}
		
		public Builder active(Boolean active) {
			this.active = active;
			return self();
		}
		
		public Builder typeTitle(String typeTitle) {
			this.typeTitle = typeTitle;
			return self();
		}
		
		public Builder duration(Integer duration) {
			this.duration = duration;
			return self();
		}
		
		public Statistics build() {
			return new Statistics(type, typeName, instanceId, active, typeTitle, duration);
		}

		public Builder fromHealthMonitors(Statistics in) {
			return this.type(in.getType()).typeName(in.getTypeName())
					.instanceId(in.getInstanceId())
					.active(in.getActive())
					.typeTitle(in.getTypeTitle())
					.duration(in.getDuration());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
