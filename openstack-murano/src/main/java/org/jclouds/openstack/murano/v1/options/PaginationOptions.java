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
package org.jclouds.openstack.murano.v1.options;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import org.jclouds.http.options.BaseHttpRequestOptions;

import com.google.common.collect.Multimap;

/**
 * Options used to control paginated results (aka list commands).
 * 
 * @see <a href=
 *      "http://docs.openstack.org/api/openstack-compute/2/content/Paginated_Collections-d1e664.html"
 *      />
 * @author hjl
 */
public class PaginationOptions extends BaseHttpRequestOptions {
   /**
    * Many OpenStack interfaces take different params for pagination. Using queryParams allows you to make
    * use of them all if necessary.
    */
   public PaginationOptions queryParameters(Multimap<String, String> queryParams) {
      checkNotNull(queryParams, "queryParams");
      queryParameters.putAll(queryParams);
      return this;
   }

   /**
    * The marker parameter is the ID of the last item in the previous list. Items are sorted by
    * create time in descending order. When a create time is not available they are sorted by ID.
    */
   public PaginationOptions marker(String marker) {
      queryParameters.put("marker", checkNotNull(marker, "marker"));
      return this;
   }

   /**
    * To reduce load on the service, list operations will return a maximum of 1,000 items at a time.
    * To navigate the collection, the parameters limit and offset can be set in the URI
    * (e.g.?limit=0&offset=0). If an offset is given beyond the end of a list an empty list will be
    * returned.
    * <p/>
    * Note that list operations never return itemNotFound (404) faults.
    */
   public PaginationOptions limit(int limit) {
      checkState(limit >= 0, "limit must be >= 0");
      checkState(limit <= 10000, "limit must be <= 10000");
      queryParameters.put("limit", Integer.toString(limit));
      return this;
   }
   
   public PaginationOptions orderBy(String order_by) {
	  this.queryParameters.put("order_by", checkNotNull(order_by, "order_by"));
	  return this;
   }
   
   public PaginationOptions type(String type) {
	  this.queryParameters.put("type", checkNotNull(type, "type"));
	  return this;
   }
   
   public PaginationOptions category(String category) {
	  this.queryParameters.put("category", checkNotNull(category, "category"));
	  return this;
   }
   
   public PaginationOptions fqn(String fqn) {
	  this.queryParameters.put("fqn", checkNotNull(fqn, "fqn"));
	  return this;
   }
   
   public PaginationOptions owned(Boolean owned) {
	  this.queryParameters.put("owned", checkNotNull(owned, "owned").toString());
	  return this;
   }
   
   public PaginationOptions className(String class_name) {
	  this.queryParameters.put("class_name", checkNotNull(class_name, "class_name").toString());
	  return this;
   }


   public static class Builder {
      /**
       * @see PaginationOptions#queryParameters(Multimap)
       */
      public static PaginationOptions queryParameters(Multimap<String, String> queryParams) {
         PaginationOptions options = new PaginationOptions();
         return options.queryParameters(queryParams);
      }

      /**
       * @see PaginationOptions#marker(String)
       */
      public static PaginationOptions marker(String marker) {
         PaginationOptions options = new PaginationOptions();
         return options.marker(marker);
      }

      /**
       * @see PaginationOptions#limit
       */
      public static PaginationOptions limit(int limit) {
         PaginationOptions options = new PaginationOptions();
         return options.limit(limit);
      }

      public static PaginationOptions orderBy(String orderBy) {
         PaginationOptions options = new PaginationOptions();
         return options.orderBy(orderBy) ;
      }
      
      public static PaginationOptions type(String type) {
          PaginationOptions options = new PaginationOptions();
          return options.type(type) ;
       }
      
      public static PaginationOptions category(String category) {
          PaginationOptions options = new PaginationOptions();
          return options.category(category) ;
       }
      
      public static PaginationOptions fqn(String fqn) {
          PaginationOptions options = new PaginationOptions();
          return options.fqn(fqn) ;
       }
      
      public static PaginationOptions owned(Boolean owned) {
          PaginationOptions options = new PaginationOptions();
          return options.owned(owned) ;
       }
      
      public static PaginationOptions className(String className) {
          PaginationOptions options = new PaginationOptions();
          return options.className(className) ;
       }

   }
}
