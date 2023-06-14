package com.example.quranmobile.AyatModels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Verses{

	@SerializedName("meta")
	private Meta meta;

	@SerializedName("verses")
	private List<VersesItem> verses;

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setVerses(List<VersesItem> verses){
		this.verses = verses;
	}

	public List<VersesItem> getVerses(){
		return verses;
	}

	@Override
 	public String toString(){
		return 
			"Verses{" + 
			"meta = '" + meta + '\'' + 
			",verses = '" + verses + '\'' + 
			"}";
		}
}