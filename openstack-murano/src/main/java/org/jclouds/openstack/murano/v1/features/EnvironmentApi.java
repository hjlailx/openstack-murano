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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.EmptyFluentIterableOnNotFoundOr404;
import org.jclouds.Fallbacks.FalseOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.openstack.murano.v1.domain.Environment;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
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
public interface EnvironmentApi {

	// environments
	/**
	 * @see EnvironmentApi#list
	 * 
	 * @return
	 */
	@Named("environments:list")
	@GET
	@Path("/environments")
	@SelectJson("environments")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(EmptyFluentIterableOnNotFoundOr404.class)
	FluentIterable<? extends Environment> listEnvironments();

	/**
	 * @see EnvironmentApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("environments:get")
	@GET
	@Path("/environments/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Environment getEnvironment(@HeaderParam("X-Configuration-Session") String session, @PathParam("id") String id);

	/**
	 * @see EnvironmentApi#create
	 */
	@Named("environments:create")
	@POST
	@Path("/environments")
	//@SelectJson("environment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	@Payload("%7B\"name\":\"{env_name}\"%7D")
	Environment Environment(@PayloadParam("env_name") String name);

	/**
	 * @see EnvironmentApi#update
	 */
	@Named("environments:update")
	@PUT
	@Path("/environments/{id}")
//	@SelectJson("environment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	@Payload("%7B\"name\":\"{env_name}\"%7D")
	Environment updateEnvironment(@PathParam("id") String id, @PayloadParam("env_name") String name);

	/**
	 * @see EnvironmentApi#delete
	 */
	@Named("environments:delete")
	@DELETE
	@Consumes
	@Fallback(FalseOnNotFoundOr404.class)
	@Path("/environments/{id}")
	Boolean deleteEnvironments(@PathParam("id") String id);

}
