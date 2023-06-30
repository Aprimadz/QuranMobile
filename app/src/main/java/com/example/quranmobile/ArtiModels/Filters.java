package com.example.quranmobile.ArtiModels;

import com.google.gson.annotations.SerializedName;

public class Filters{

	@SerializedName("resource_id")
	private int resourceId;

	public void setResourceId(int resourceId){
		this.resourceId = resourceId;
	}

	public int getResourceId(){
		return resourceId;
	}

	@Override
 	public String toString(){
		return 
			"Filters{" + 
			"resource_id = '" + resourceId + '\'' + 
			"}";
		}
}