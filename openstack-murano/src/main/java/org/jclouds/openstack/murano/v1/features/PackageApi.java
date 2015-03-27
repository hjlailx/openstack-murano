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

import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;

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

import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.io.Payload;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.openstack.murano.v1.domain.Category;
import org.jclouds.openstack.murano.v1.domain.Package;
import org.jclouds.openstack.murano.v1.domain.Packages;
import org.jclouds.openstack.murano.v1.options.CreatePackageOptions;
import org.jclouds.openstack.murano.v1.options.PaginationOptions;
import org.jclouds.openstack.murano.v1.options.UpdatePackageOptions;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.PATCH;
import org.jclouds.rest.annotations.RequestFilters;

/**
 * Provides synchronous access to MuranoService operations on the
 * OpenStack Murano API.
 * <p/>
 *
 * @author hjl
 */
@Path("/v1/catalog/packages")
@RequestFilters(AuthenticateRequest.class)
@Consumes(MediaType.APPLICATION_JSON)
public interface PackageApi {
	
	@Named("Package:List")
	@GET
//	@Path("{marker}{limit}{order_by}{type}{category}{fqn}{owned}{class_name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
//	Packages listPackage(@Nullable@QueryParam("marker") String marker, @Nullable@QueryParam("limit") Integer limit,
//			@QueryParam("order_by") String orderBy, @QueryParam("type") String type,
//			@QueryParam("category") String category, @QueryParam("fqn") String fqn,
//			@QueryParam("owned") Boolean owned, @QueryParam("class_name") String className);
	Packages listPackage(PaginationOptions options);
	
	@Named("Package:create")
	@POST
	@Produces(APPLICATION_OCTET_STREAM)
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	@MapBinder(CreatePackageOptions.class)
	Package createPackage(@HeaderParam("name") String name, Payload payload, CreatePackageOptions... options);

	/**
	 * @see PackageApi#get
	 * 
	 * @param id
	 * @return
	 */
	@Named("Package:get")
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Package getPackageDetail(@PathParam("id") String id);
	
	/**
	 * download app
	 * @param id
	 * @return
	 */
	@Named("Package:get")
	@GET
	@Path("/{id}/download")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Byte[] getApplicationPackage(@PathParam("id") String id);
	
	/**
	 * get ui
	 * @param id
	 * @return
	 */
	@Named("Package:get")
	@GET
	@Path("/{id}/ui")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Byte[] getPackageUi(@PathParam("id") String id);
	
	/**
	 * get logo
	 * @param id
	 * @return
	 */
	@Named("Package:get")
	@GET
	@Path("/{id}/logo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Byte[] getPackageLogo(@PathParam("id") String id);
	
	/**
	 * @see PackageApi#put
	 * 
	 * @param id
	 * @return
	 */
	@Named("Package:put")
	@PATCH
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	@MapBinder(UpdatePackageOptions.class)
	Package updatePackage(@PathParam("id") String id, UpdatePackageOptions options);

	/**
	 * @see PackageApi#get
	 */
	@Named("Package:del")
	@DELETE
	@Path("/{id}")
	@Fallback(NullOnNotFoundOr404.class)
	Boolean delPackage(@PathParam("id") String id);
	
	/**
	 * categories
	 * @return
	 */
	@Named("categories:list")
	@GET
//	@SelectJson("categories")
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(NullOnNotFoundOr404.class)
	Category getCategories();

}
