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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.FalseOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.openstack.murano.v1.domain.Session;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.RequestFilters;

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
public interface ConfigurationSessionApi {

	/**
	 * @see ConfigurationSessionApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("sessions:get")
	@GET
	@Path("/environments/{id}/sessions/{sessionId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Session getSession(@PathParam("id") String id, @PathParam("sessionId") String sessionId);

	/**
	 * @see ConfigurationSessionApi#deploy
	 */
	@Named("sessions:deploy ")
	@POST
	@Path("/environments/{id}/sessions/{sessionId}/deploy")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	void deploySession(@PathParam("id") String id, @PathParam("sessionId") String sessionId);

	/**
	 * @see ConfigurationSessionApi#configure
	 */
	@Named("sessions:configure")
	@POST
	@Path("/environments/{id}/configure")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Session configureSession(@PathParam("id") String id);

	/**
	 * @see ConfigurationSessionApi#delete
	 */
	@Named("session:delete")
	@DELETE
	@Consumes
	@Fallback(FalseOnNotFoundOr404.class)
	@Path("/environments/{id}/sessions/{sessionId}")
	Boolean deleteSession(@PathParam("id") String id, @PathParam("sessionId") String sessionId);

}
