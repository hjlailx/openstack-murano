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
 * Environment
 *
 * @author hjl
 */
public class Environment {
	
	private final String id;
	private final String name ;
	private final String tenantId;
	private final String created ;
	private final String updated ;
	private final String version ;
//	private final State status;
	private final String status ;
	private final NetWorking networking ;
	private final Set<Service> services ;
	private final Mark mark ;
	

	@ConstructorProperties({ "id", "name","tenant_id", "created", "updated","version","status", "networking", "services", "?"})
	protected Environment(String id, String name, String tenantId, String created, String updated, String version, 
			String status, NetWorking networking, Set<Service> services, Mark mark) {
		this.id = id;
		this.name = name ;
		this.tenantId = tenantId;
		this.created = created ;
		this.updated = updated ;
		this.version = version ;
		this.status = status;
		this.networking = networking;
		this.services = services ;
		this.mark = mark ;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTenantId() {
		return tenantId;
	}

	public String getCreated() {
		return created;
	}

	public String getUpdated() {
		return updated;
	}

	public String getVersion() {
		return version;
	}

	public String getStatus() {
		return status;
	}

	public NetWorking getNetworking() {
		return networking;
	}

	public Set<Service> getServices() {
		return services;
	}
	
	public Mark getMark() {
		return mark;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, name, tenantId, created,
				updated, version, status, networking, services, mark);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Environment that = Environment.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.tenantId, that.tenantId)
				&& Objects.equal(this.created, that.created)
				&& Objects.equal(this.updated, that.updated)
				&& Objects.equal(this.version, that.version)
				&& Objects.equal(this.status, that.status)
				&& Objects.equal(this.networking, that.networking)
				&& Objects.equal(this.services, that.services)
				&& Objects.equal(this.mark, that.mark);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("name", name)
				.add("tenantId", tenantId).add("created", created)
				.add("updated", updated).add("version", version)
				.add("status", status).add("networking", networking)
				.add("services", services).add("mark", mark);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	public static Builder builder() {
		return new ConcreteBuilder();
	}

	public Builder toBuilder() {
		return new ConcreteBuilder().fromEnvironment(this);
	}

	public abstract static class Builder {
		protected abstract Builder self();
		
		protected String id ;
		protected String name ;
		protected String tenantId ;
		protected String created ;
		protected String updated ;
		protected String version ;
		protected String status ;
		protected NetWorking networking ;
		protected Set<Service> services ;
		protected Mark mark ;
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder name(String name) {
			this.name = name;
			return self();
		}

		public Builder tenantId(String tenantId) {
			this.tenantId = tenantId;
			return self();
		}
		
		public Builder created(String created) {
			this.created = created;
			return self();
		}
		
		public Builder updated(String updated) {
			this.updated = updated;
			return self();
		}
		
		public Builder version(String version) {
			this.version = version;
			return self();
		}
		
		public Builder status(String status) {
			this.status = status;
			return self();
		}
		
		public Builder networking(NetWorking networking) {
			this.networking = networking;
			return self();
		}
		
		public Builder services(Set<Service> services) {
			this.services = services;
			return self();
		}
		
		public Builder mark(Mark mark) {
			this.mark = mark ;
			return self() ;
		}
		
		public Environment build() {
			return new Environment(id, name, tenantId, created, updated, version,
					status, networking, services, mark);
		}

		public Builder fromEnvironment(Environment in) {
			return this.id(in.getId()).name(in.getName()).tenantId(in.getTenantId())
					.created(in.getCreated())
					.updated(in.getUpdated())
					.version(in.getVersion())
					.status(in.getStatus())
					.networking(in.getNetworking())
					.services(in.getServices())
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
