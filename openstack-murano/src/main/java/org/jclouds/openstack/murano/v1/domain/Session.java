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
 * Session
 *
 * @author hjl
 */
public class Session {
	
	private final String id;
	private final String environmentId ;
	private final String userId;
	private final String created ;
	private final String updated ;
	private final String version ;
	private final String status;
	

	@ConstructorProperties({ "id", "environment_id","user_id", "created", "updated","version","status"})
	protected Session(String id, String environmentId, String userId, String created, String updated, String version, String status) {
		this.id = id;
		this.environmentId = environmentId ;
		this.userId = userId;
		this.created = created ;
		this.updated = updated ;
		this.version = version ;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public String getEnvironmentId() {
		return environmentId;
	}

	public String getUserId() {
		return userId;
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

	@Override
	public int hashCode() {
		return Objects.hashCode(id, environmentId, userId, created,
				updated, version, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Session that = Session.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.environmentId, that.environmentId)
				&& Objects.equal(this.userId, that.userId)
				&& Objects.equal(this.created, that.created)
				&& Objects.equal(this.updated, that.updated)
				&& Objects.equal(this.version, that.version)
				&& Objects.equal(this.status, that.status);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("environmentId", environmentId)
				.add("userId", userId).add("created", created)
				.add("updated", updated).add("version", version)
				.add("status", status);
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
		
		protected String id;
		protected String environmentId;
		protected String userId;
		protected String created;
		protected String updated;
		protected String version ;
		protected String status;
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder environmentId(String environmentId) {
			this.environmentId = environmentId;
			return self();
		}

		public Builder userId(String userId) {
			this.userId = userId;
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
		
		public Session build() {
			return new Session(id, environmentId, userId, created, updated, version,
					status);
		}

		public Builder fromHealthMonitors(Session in) {
			return this.id(in.getId()).environmentId(in.getEnvironmentId())
					.userId(in.getUserId())
					.created(in.getCreated())
					.updated(in.getUpdated())
					.version(in.getVersion())
					.status(in.getStatus());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
