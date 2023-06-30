package com.example.quranmobile.retrofit;


import com.example.quranmobile.ArtiModels.Arti;
import com.example.quranmobile.AudioModels.Audio;
import com.example.quranmobile.AyatModels.Verses;
import com.example.quranmobile.SurahModels.Chapters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoint {

    @GET("chapters?language=id")
    Call<Chapters> getSurah();

    @GET("chapter_recitations/2")
    Call<Audio> getAudio();

    @GET("quran/translations/33")
    Call<Arti> getArti(@Query("chapter_number") int id);

    @GET("quran/verses/uthmani")
    Call<Verses>getAyat(@Query("chapter_number") int id);
}
