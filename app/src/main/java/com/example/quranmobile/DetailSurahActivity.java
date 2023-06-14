package com.example.quranmobile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranmobile.AyatModels.Verses;
import com.example.quranmobile.AyatModels.VersesItem;
import com.example.quranmobile.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSurahActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    private AdapterAyats adapterAyats;
    private List<VersesItem> results = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_surah_activity);

        int id = getIntent().getIntExtra("id",1);

        setUpView();
        setUpRecyclerView();
        System.out.println(id);
        getDataFromApi(id);
    }



    private void setUpView() {
        recyclerView = findViewById(R.id.recyclerViewAyat);
    }

    private void setUpRecyclerView() {
        adapterAyats = new AdapterAyats(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterAyats);
    }

    private void getDataFromApi(int id) {
        ApiService.endpoint().getAyat(id).enqueue(new Callback<Verses>() {
            @Override
            public void onResponse(Call<Verses> call, Response<Verses> response) {
                if(response.isSuccessful()){
                    List<VersesItem> result = response.body().getVerses();
                    Log.d("Ayat",result.toString());
                    adapterAyats.setData(result);
                }
            }

            @Override
            public void onFailure(Call<Verses> call, Throwable t) {
                Log.d("Ayat", t.toString());
            }
        });
    }

}
