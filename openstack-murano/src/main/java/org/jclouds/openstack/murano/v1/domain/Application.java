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
 * Application
 *
 * @author hjl
 */
public class Application {
	
	private final Instance instance;
	private final String name ;
	private final Mark mark;

	@ConstructorProperties({ "instance", "name","mark"})
	protected Application(Instance instance, String name, Mark mark) {
		this.instance = instance;
		this.name = name ;
		this.mark = mark;
	}

	public Instance getInstance() {
		return instance;
	}

	public String getName() {
		return name;
	}

	public Mark getMark() {
		return mark;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(instance, name, mark);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Application that = Application.class.cast(obj);
		return Objects.equal(this.instance, that.instance)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.mark, that.mark);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("instance", instance).add("name", name)
				.add("mark", mark);
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
		
		protected Instance instance;
		protected String name ;
		protected Mark mark;
		
		public Builder instance(Instance instance) {
			this.instance = instance;
			return self();
		}
		
		public Builder name(String name) {
			this.name = name;
			return self();
		}

		public Builder mark(Mark mark) {
			this.mark = mark;
			return self();
		}
		
		public Application build() {
			return new Application(instance, name, mark);
		}

		public Builder fromHealthMonitors(Application in) {
			return this.instance(in.getInstance()).name(in.getName())
					.mark(in.getMark());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
