package com.example.quranmobile.AyatModels;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("filters")
	private Filters filters;

	public void setFilters(Filters filters){
		this.filters = filters;
	}

	public Filters getFilters(){
		return filters;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"filters = '" + filters + '\'' + 
			"}";
		}
}