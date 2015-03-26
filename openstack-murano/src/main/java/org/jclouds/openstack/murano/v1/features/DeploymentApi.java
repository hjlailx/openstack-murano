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
package org.jclouds.openstack.murano.v1.features;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.EmptyFluentIterableOnNotFoundOr404;
import org.jclouds.Fallbacks.FalseOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.openstack.murano.v1.domain.Application;
import org.jclouds.openstack.murano.v1.domain.Deployment;
import org.jclouds.openstack.murano.v1.options.CreateApplicationOptions;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

import com.google.common.collect.FluentIterable;

/**
 * Provides synchronous access to MuranoService operations on the
 * OpenStack Murano API.
 * <p/>
 *
 * @author hjl
 */
@Path("/v1")
@RequestFilters(AuthenticateRequest.class)
@Consumes(MediaType.APPLICATION_JSON)
public interface DeploymentApi {
	
	/**
	 * @see DeploymentApi#list
	 * 
	 * @return
	 */
	@Named("deployments:list")
	@GET
	@Path("/environments/{id}/deployments")
	@SelectJson("deployments")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(EmptyFluentIterableOnNotFoundOr404.class)
	FluentIterable<? extends Deployment> listDeployments(@PathParam("id") String environmentsId);

	/**
	 * @see DeploymentApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("Application:get")
	@GET
	@Path("/environments/{id}/services/{appId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Application getApplication(@HeaderParam("X-Configuration-Session") String session, @PathParam("id") String environmentsId, @PathParam("appId") String appId);

	/**
	 * @see DeploymentApi#deploy
	 */
	@Named("application:create ")
	@POST
	@Path("/environments/{id}/services")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@MapBinder(CreateApplicationOptions.class)
	@Fallback(NullOnNotFoundOr404.class)
	Application CreateApplication(@HeaderParam("X-Configuration-Session") String session, @PathParam("id") String environmentsId, CreateApplicationOptions options);

	/**
	 * @see DeploymentApi#delete
	 */
	@Named("application:delete")
	@DELETE
	@Consumes
	@Fallback(FalseOnNotFoundOr404.class)
	@Path("/environments/{id}/services/{appId}")
	Boolean deleteDeployment(@PathParam("id") String environmentsId, @PathParam("appId") String appId);

}
