package com.example.quranmobile;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranmobile.AudioModels.Audio;
import com.example.quranmobile.AudioModels.AudioFilesItem;
import com.example.quranmobile.SurahModels.Chapters;
import com.example.quranmobile.SurahModels.ChaptersItem;
import com.example.quranmobile.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG ="MainActivity";
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    public List<ChaptersItem> surah = new ArrayList<>();
    public List<AudioFilesItem> audio= new ArrayList<>();

    List<AudioFilesItem> audioList;
    List<ChaptersItem> surahList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUpView();
        setUpRecyclerView();
        getDataFromApi();

    }

    private void setUpRecyclerView() {
        mainAdapter = new MainAdapter(surah,audio);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainAdapter);

    }

    private void setUpView() {
        recyclerView = findViewById(R.id.recyclerView);

    }

    private void getDataFromApi() {
        ApiService.endpoint().getSurah().enqueue(new Callback<Chapters>() {
            @Override
            public void onResponse(Call<Chapters> call, Response<Chapters> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    MainActivity.this.surahList = response.body().getChapters();
                    getDataFromAudio();
                }
            }

            @Override
            public void onFailure(Call<Chapters> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }

    private void getDataFromAudio() {
        ApiService.endpoint().getAudio().enqueue(new Callback<Audio>() {
            @Override
            public void onResponse(Call<Audio> call, Response<Audio> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    MainActivity.this.audioList = response.body().getAudioFiles();
                    mainAdapter.setData(surahList,audioList);

                }
            }

            @Override
            public void onFailure(Call<Audio> call, Throwable t) {
                Log.d(TAG, t.toString());

            }
        });
    }
}