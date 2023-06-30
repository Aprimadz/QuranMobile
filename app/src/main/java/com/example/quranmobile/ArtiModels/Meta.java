package com.example.quranmobile.ArtiModels;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("author_name")
	private String authorName;

	@SerializedName("filters")
	private Filters filters;

	@SerializedName("translation_name")
	private String translationName;

	public void setAuthorName(String authorName){
		this.authorName = authorName;
	}

	public String getAuthorName(){
		return authorName;
	}

	public void setFilters(Filters filters){
		this.filters = filters;
	}

	public Filters getFilters(){
		return filters;
	}

	public void setTranslationName(String translationName){
		this.translationName = translationName;
	}

	public String getTranslationName(){
		return translationName;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"author_name = '" + authorName + '\'' + 
			",filters = '" + filters + '\'' + 
			",translation_name = '" + translationName + '\'' + 
			"}";
		}
}