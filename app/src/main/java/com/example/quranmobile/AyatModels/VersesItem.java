package com.example.quranmobile.AyatModels;

import com.google.gson.annotations.SerializedName;

public class VersesItem{

	@SerializedName("verse_key")
	private String verseKey;

	@SerializedName("text_uthmani")
	private String textUthmani;

	@SerializedName("id")
	private int id;

	public void setVerseKey(String verseKey){
		this.verseKey = verseKey;
	}

	public String getVerseKey(){
		return verseKey;
	}

	public void setTextUthmani(String textUthmani){
		this.textUthmani = textUthmani;
	}

	public String getTextUthmani(){
		return textUthmani;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"VersesItem{" + 
			"verse_key = '" + verseKey + '\'' + 
			",text_uthmani = '" + textUthmani + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}