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
 * Stats
 *
 * @author hjl
 */
public class Stats {
	
	private final String requestsPerTenant;
	private final Integer errorsPerSecond ;
	private final Integer errorsCount;
	private final Float requestsPerSecond ;
	private final Integer requestsCount ;
	private final Double cpuPercent ;
	private final Integer cpuCount ;
	private final String host ;
	private final Float averageResponseTime ;
	

	@ConstructorProperties({ "requests_per_tenant", "errors_per_second","errors_count", "requests_per_second", "requests_count", "cpu_percent"
		,"cpu_count", "host", "average_response_time"})
	protected Stats(String requestsPerTenant, Integer errorsPerSecond, Integer errorsCount, Float requestsPerSecond, Integer requestsCount
			, Double cpuPercent, Integer cpuCount, String host, Float averageResponseTime) {
		this.requestsPerTenant = requestsPerTenant;
		this.errorsPerSecond = errorsPerSecond ;
		this.errorsCount = errorsCount;
		this.requestsPerSecond = requestsPerSecond ;
		this.requestsCount = requestsCount ;
		this.cpuPercent = cpuPercent ;
		this.cpuCount = cpuCount ;
		this.host = host ;
		this.averageResponseTime = averageResponseTime ;
	}

	public String getRequestsPerTenant() {
		return requestsPerTenant;
	}

	public Integer getErrorsPerSecond() {
		return errorsPerSecond;
	}

	public Integer getErrorsCount() {
		return errorsCount;
	}

	public Float getRequestsPerSecond() {
		return requestsPerSecond;
	}

	public Integer getRequestsCount() {
		return requestsCount;
	}

	public Double getCpuPercent() {
		return cpuPercent;
	}

	public Integer getCpuCount() {
		return cpuCount;
	}

	public String getHost() {
		return host;
	}

	public Float getAverageResponseTime() {
		return averageResponseTime;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(requestsPerTenant, errorsPerSecond, errorsCount, requestsPerSecond,
				requestsCount, cpuPercent, cpuCount, host, averageResponseTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Stats that = Stats.class.cast(obj);
		return Objects.equal(this.requestsPerTenant, that.requestsPerTenant)
				&& Objects.equal(this.errorsPerSecond, that.errorsPerSecond)
				&& Objects.equal(this.errorsCount, that.errorsCount)
				&& Objects.equal(this.requestsPerSecond, that.requestsPerSecond)
				&& Objects.equal(this.requestsCount, that.requestsCount)
				&& Objects.equal(this.cpuPercent, that.cpuPercent)
				&& Objects.equal(this.cpuCount, that.cpuCount)
				&& Objects.equal(this.host, that.host)
				&& Objects.equal(this.averageResponseTime, that.averageResponseTime);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("requestsPerTenant", requestsPerTenant).add("errorsPerSecond", errorsPerSecond)
				.add("errorsCount", errorsCount).add("requestsPerSecond", requestsPerSecond)
				.add("requestsCount", requestsCount).add("cpuPercent", cpuPercent)
				.add("cpuCount", cpuCount).add("host", host).add("averageResponseTime", averageResponseTime);
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
		
		protected String requestsPerTenant;
		protected Integer errorsPerSecond ;
		protected Integer errorsCount;
		protected Float requestsPerSecond ;
		protected Integer requestsCount ;
		protected Double cpuPercent ;
		protected Integer cpuCount ;
		protected String host ;
		protected Float averageResponseTime ;
		
		public Builder requestsPerTenant(String requestsPerTenant) {
			this.requestsPerTenant = requestsPerTenant;
			return self();
		}
		
		public Builder errorsPerSecond(Integer errorsPerSecond) {
			this.errorsPerSecond = errorsPerSecond;
			return self();
		}
		
		public Builder errorsCount(Integer errorsCount) {
			this.errorsCount = errorsCount;
			return self();
		}
		
		public Builder requestsPerSecond(Float requestsPerSecond) {
			this.requestsPerSecond = requestsPerSecond;
			return self();
		}
		
		public Builder requestsCount(Integer requestsCount) {
			this.requestsCount = requestsCount;
			return self();
		}
		
		public Builder cpuPercent(Double cpuPercent) {
			this.cpuPercent = cpuPercent;
			return self();
		}
		
		public Builder cpuCount(Integer cpuCount) {
			this.cpuCount = cpuCount;
			return self();
		}
		
		public Builder host(String host) {
			this.host = host;
			return self();
		}
		
		public Builder averageResponseTime(Float averageResponseTime) {
			this.averageResponseTime = averageResponseTime;
			return self();
		}

		
		public Stats build() {
			return new Stats(requestsPerTenant, errorsPerSecond, errorsCount, requestsPerSecond, requestsCount, cpuPercent
					, cpuCount, host, averageResponseTime);
		}

		public Builder fromHealthMonitors(Stats in) {
			return this.requestsPerTenant(in.getRequestsPerTenant()).errorsPerSecond(in.getErrorsPerSecond())
					.errorsCount(in.getErrorsCount())
					.requestsPerSecond(in.getRequestsPerSecond())
					.requestsCount(in.getRequestsCount())
					.cpuPercent(in.getCpuPercent())
					.cpuCount(in.getCpuCount())
					.host(in.getHost())
					.averageResponseTime(in.getAverageResponseTime());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
