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

import org.jclouds.openstack.murano.v1.enumerate.Operations;
import org.jclouds.openstack.murano.v1.enumerate.Paths;

import com.google.common.base.Objects;

/**
 * Operation
 *
 * @author hjl
 */
public class Operation {
	
	private final Operations op;
	private final Paths path;
	private final Set<String> value1;
	private final Boolean value2;
	private final String value3;
	
	@ConstructorProperties({ "op", "path", "value"})
	protected Operation(Operations op, Paths path, Set<String> value1) {
		this.op = op;
		this.path = path;
		this.value1 = value1;
		this.value2 = null ;
		this.value3 = null ;
	}
	
	@ConstructorProperties({ "op", "path", ""})
	protected Operation(Paths path, Set<String> value1) {
		this.op = Operations.remove;
		this.path = path;
		this.value1 = value1;
		this.value2 = null ;
		this.value3 = null ;
	}
	
	@ConstructorProperties({ "op", "path", "value"})
	protected Operation(Operations op, Paths path, Boolean value2) {
		this.op = op;
		this.path = path;
		this.value2 = value2;
		this.value1 = null ;
		this.value3 = null ;
	}
	
	@ConstructorProperties({ "op", "path", "value"})
	protected Operation(Operations op, Paths path, String value3) {
		this.op = op;
		this.path = path;
		this.value3 = value3;
		this.value1 = null ;
		this.value2 = null;
	}

	public Operations getOp() {
		return op;
	}

	public Paths getPath() {
		return path;
	}

	public Set<String> getValue1() {
		return value1;
	}

	public Boolean getValue2() {
		return value2;
	}

	public String getValue3() {
		return value3;
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("op", op).add("path", path)
				.add("value1", value1).add("value2", value2).add("value3", value3);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	public static Builder builder() {
		return new ConcreteBuilder();
	}

	public Builder toBuilder() {
		return new ConcreteBuilder().fromOperation(this);
	}

	public abstract static class Builder {
		protected abstract Builder self();
		
		protected Operations op;
		protected Paths path;
		protected Set<String> value1;
		protected Boolean value2;
		protected String value3;
		
		public Builder op(Operations op) {
			this.op = op;
			return self();
		}
		
		public Builder path(Paths path) {
			this.path = path;
			return self();
		}
		
		public Builder value1(Set<String> value1) {
			this.value1 = value1;
			return self();
		}
		
		public Builder value2(Boolean value2) {
			this.value2 = value2;
			return self();
		}
		
		public Builder value3(String value3) {
			this.value3 = value3;
			return self();
		}
		
		public Operation build() {
			if(value1 != null) {
				if(op.name().equals(Operations.remove)) {
					return new Operation(path, value1);
				}else{
					return new Operation(op, path, value1);
				}
				
			}else if(value2 != null) {
				return new Operation(op, path, value2);
			}else if(value3 != null) {
				return new Operation(op, path, value3);
			}else{
				return null ;
			}
			
		}

		public Builder fromOperation(Operation in) {
			return this.op(in.getOp()).path(in.getPath()).value1(in.getValue1()).value2(in.getValue2()).value3(in.getValue3());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
