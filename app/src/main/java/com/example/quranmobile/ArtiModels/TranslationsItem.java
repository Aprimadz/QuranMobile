package com.example.quranmobile.ArtiModels;

import com.google.gson.annotations.SerializedName;

public class TranslationsItem{

	@SerializedName("resource_id")
	private int resourceId;

	@SerializedName("text")
	private String text;

	public void setResourceId(int resourceId){
		this.resourceId = resourceId;
	}

	public int getResourceId(){
		return resourceId;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"TranslationsItem{" + 
			"resource_id = '" + resourceId + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}