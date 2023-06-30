package com.example.quranmobile.ArtiModels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Arti{

	@SerializedName("translations")
	private List<TranslationsItem> translations;

	@SerializedName("meta")
	private Meta meta;

	public void setTranslations(List<TranslationsItem> translations){
		this.translations = translations;
	}

	public List<TranslationsItem> getTranslations(){
		return translations;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	@Override
 	public String toString(){
		return 
			"Arti{" + 
			"translations = '" + translations + '\'' + 
			",meta = '" + meta + '\'' + 
			"}";
		}
}