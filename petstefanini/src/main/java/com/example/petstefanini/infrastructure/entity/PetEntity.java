package com.example.petstefanini.infrastructure.entity;

import java.util.List;

public class PetEntity {

	private String id;
	private String name;
	private List<TagsEntity> tags;
	private CategoryEntity category;
	private String[] photoUrls;

	
	public List<TagsEntity> getTags() {
		return tags;
	}

	public void setTags(List<TagsEntity> tags) {
		this.tags = tags;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String[] getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;

	public String getId() {
		return id;
	}

	public void setId(String idPet) {
		this.id = idPet;
	}
	
}
