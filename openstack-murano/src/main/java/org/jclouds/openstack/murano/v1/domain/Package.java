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
 * Package
 *
 * @author hjl
 */
public class Package {
	
	private final String id;
	private final String fullyQualifiedName ;
	private final Boolean isPublic;
	private final String name ;
	private final String type ;
	private final String description ;
	private final String author ;
	private final String created ;
	private final String updated ;
	private final Set<String> classDefinition ;
	private final Boolean enabled ;
	private final Set<String> tags ;
	private final Set<String> categories ;
	private final String ownerId ;

	@ConstructorProperties({ "id", "fully_qualified_name","is_public", "name", "type", "description"
		,"author", "created", "updated", "class_definition","enabled", "tags", "categories", "owner_id"})
	protected Package(String id, String fullyQualifiedName, Boolean isPublic, String name, String type
			, String description, String author, String created, String updated, Set<String> classDefinition, Boolean enabled, Set<String> tags, Set<String> categories, String ownerId) {
		this.id = id;
		this.fullyQualifiedName = fullyQualifiedName ;
		this.isPublic = isPublic;
		this.name = name ;
		this.type = type ;
		this.description = description ;
		this.author = author ;
		this.created = created ;
		this.updated = updated;
		this.classDefinition = classDefinition ;
		this.enabled = enabled ;
		this.tags = tags ;
		this.categories = categories ;
		this.ownerId = ownerId ;
	}

	public String getId() {
		return id;
	}

	public String getFullyQualifiedName() {
		return fullyQualifiedName;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getAuthor() {
		return author;
	}

	public String getCreated() {
		return created;
	}
	
	public String getUpdated() {
		return updated;
	}

	public Set<String> getClassDefinition() {
		return classDefinition;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public Set<String> getTags() {
		return tags;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public String getOwnerId() {
		return ownerId;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, fullyQualifiedName, isPublic, name,
				type, description, author, created, updated, classDefinition, enabled, tags, categories, ownerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Package that = Package.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.fullyQualifiedName, that.fullyQualifiedName)
				&& Objects.equal(this.isPublic, that.isPublic)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.type, that.type)
				&& Objects.equal(this.description, that.description)
				&& Objects.equal(this.author, that.author)
				&& Objects.equal(this.created, that.created)
				&& Objects.equal(this.updated, that.updated)
				&& Objects.equal(this.classDefinition, that.classDefinition)
				&& Objects.equal(this.created, that.created)
				&& Objects.equal(this.enabled, that.enabled)
				&& Objects.equal(this.tags, that.tags)
				&& Objects.equal(this.categories, that.categories)
				&& Objects.equal(this.ownerId, that.ownerId);
	}

	protected Objects.ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("fullyQualifiedName", fullyQualifiedName)
				.add("isPublic", isPublic).add("name", name)
				.add("type", type).add("description", description)
				.add("author", author).add("created", created)
				.add("updated", updated).add("classDefinition", classDefinition).add("enabled", enabled)
				.add("tags", tags).add("categories", categories).add("ownerId", ownerId);
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
		protected String fullyQualifiedName ;
		protected Boolean isPublic;
		protected String name ;
		protected String type ;
		protected String description ;
		protected String author ;
		protected String created ;
		protected String updated ;
		protected Set<String> classDefinition ;
		protected Boolean enabled ;
		protected Set<String> tags ;
		protected Set<String> categories ;
		protected String ownerId ;
		
		public Builder id(String id) {
			this.id = id;
			return self();
		}
		
		public Builder fullyQualifiedName(String fullyQualifiedName) {
			this.fullyQualifiedName = fullyQualifiedName;
			return self();
		}
		
		public Builder isPublic(Boolean isPublic) {
			this.isPublic = isPublic;
			return self();
		}
		
		public Builder name(String name) {
			this.name = name;
			return self();
		}
		
		public Builder type(String type) {
			this.type = type;
			return self();
		}
		
		public Builder description(String description) {
			this.description = description;
			return self();
		}
		
		public Builder author(String author) {
			this.author = author;
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
		
		public Builder classDefinition(Set<String> classDefinition) {
			this.classDefinition = classDefinition;
			return self();
		}
		
		public Builder enabled(Boolean enabled) {
			this.enabled = enabled;
			return self();
		}
		
		public Builder tags(Set<String> tags) {
			this.tags = tags;
			return self();
		}
		
		public Builder categories(Set<String> categories) {
			this.categories = categories;
			return self();
		}
		
		public Builder ownerId(String ownerId) {
			this.ownerId = ownerId;
			return self();
		}

		
		public Package build() {
			return new Package(id, fullyQualifiedName, isPublic, name, type, description
					, author, created, updated, classDefinition, enabled, tags, categories, ownerId);
		}

		public Builder fromHealthMonitors(Package in) {
			return this.id(in.getId()).fullyQualifiedName(in.getFullyQualifiedName())
					.isPublic(in.getIsPublic())
					.name(in.getName())
					.type(in.getType())
					.description(in.getDescription())
					.author(in.getAuthor())
					.created(in.getCreated())
					.updated(in.getUpdated())
					.classDefinition(in.getClassDefinition())
					.enabled(in.getEnabled())
					.tags(in.getTags())
					.categories(in.getCategories())
					.ownerId(in.getOwnerId());
		}
	}

	private static class ConcreteBuilder extends Builder {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

}
