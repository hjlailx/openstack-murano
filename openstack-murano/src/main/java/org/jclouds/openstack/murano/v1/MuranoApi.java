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
package org.jclouds.openstack.murano.v1;

import java.io.Closeable;
import java.util.Set;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.location.Zone;
import org.jclouds.location.functions.ZoneToEndpoint;
import org.jclouds.openstack.murano.v1.features.ConfigurationSessionApi;
import org.jclouds.openstack.murano.v1.features.DeploymentApi;
import org.jclouds.openstack.murano.v1.features.EnvironmentApi;
import org.jclouds.openstack.murano.v1.features.PackageApi;
import org.jclouds.openstack.murano.v1.features.StatisticsApi;
import org.jclouds.rest.annotations.Delegate;
import org.jclouds.rest.annotations.EndpointParam;

import com.google.inject.Provides;

/**
 * Murano is a robust, web-scale message queuing service to support the
 * distributed nature of large web applications.
 *
 * @author hjl
 */
public interface MuranoApi extends Closeable {

	/**
	 * @return The Zone codes configured
	 */
	@Provides
	@Zone
	Set<String> getConfiguredZones();

	@Delegate
	EnvironmentApi getEnvironmentApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	ConfigurationSessionApi getConfigurationSessionApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	DeploymentApi getDeploymentApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	PackageApi getPackageApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
	
	@Delegate
	StatisticsApi getStatisticsApiForZone(
			@EndpointParam(parser = ZoneToEndpoint.class) @Nullable String zone);
}
