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
 * Aggregate
 *
 * @author hjl
 */
public class Aggregate {
	
	private final Integer type;
	private final Integer duration;
	private final Integer count;
	
	@ConstructorProperties({ "type", "duration", "count"})
	protected Aggregate(Integer type, Integer duration, Integer count) {
		this.type = type;
		this.duration = duration;
		this.count = count;
	}

	public Integer getType() {
		return type;
	}

	public Integer getDuration() {
		return duration;
	}

	public Integer getCount() {
		return count;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Aggregate that = Aggregate.class.cast(obj);
		return Objects.equal(this.type, that.type)
				&& Objects.equal(this.duration, that.duration)
				&& Objects.equal(this.count, that.count);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("type", type).add("duration", duration)
				.add("count", count);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	public static Builder builder() {
		return new ConcreteBuilder();
	}

	public Builder toBuilder() {
		return new ConcreteBuilder().fromAggregate(this);
	}

	public abstract static class Builder {
		protected abstract Builder self();
		
		protected Integer type;
		protected Integer duration;
		protected Integer count;
		
		public Builder type(Integer type) {
			this.type = type;
			return self();
		}
		
		public Builder duration(Integer duration) {
			this.duration = duration;
			return self();
		}
		
		public Builder count(Integer count) {
			this.count = count;
			return self();
		}
		
		public Aggregate build() {
			return new Aggregate(type, duration, count);
		}

		public Builder fromAggregate(Aggregate in) {
			return this.type(in.getType()).duration(in.getDuration()).count(in.getCount());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
