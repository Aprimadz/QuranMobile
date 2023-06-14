package com.example.quranmobile.retrofit;

import com.example.quranmobile.models.Chapters;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("chapters?language=id")
    Call<Chapters> getSurah();

}
