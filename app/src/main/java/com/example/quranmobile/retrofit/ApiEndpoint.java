package com.example.quranmobile.retrofit;

//import com.example.quranmobile.AyatModels.Ayat;
import com.example.quranmobile.AyatModels.Verses;
import com.example.quranmobile.SurahModels.Chapters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoint {

    @GET("chapters?language=id")
    Call<Chapters> getSurah();

//    @GET("by_chapter/{chapter_number}?language=id&words=true&page=1&per_page=10")
//    Call<Ayat> getVersesByChapter(
//            @Path("chapterId") int chapterId,
//            @Query("language") String language,
//            @Query("words") boolean words,
//            @Query("page") int page,
//            @Query("per_page") int perPage
//    );
    @GET("quran/verses/uthmani")
    Call<Verses>getAyat(@Query("chapter_number") int id);
}
