package com.example.quranmobile;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranmobile.ArtiModels.Arti;
import com.example.quranmobile.ArtiModels.TranslationsItem;
import com.example.quranmobile.AyatModels.Verses;
import com.example.quranmobile.AyatModels.VersesItem;
import com.example.quranmobile.retrofit.ApiService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSurahActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    private AdapterAyats adapterAyats;
    private List<VersesItem> versesItems = new ArrayList<>();

    private List<TranslationsItem> artiItem = new ArrayList<>();

    TextView txtNameSurahDetail,txtJumlahAyat,txtNamaArabDetail,txtTempatTurunDetail;

    private MediaPlayer mediaPlay;

    Button btnAudio;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_surah_activity);

        int id = getIntent().getIntExtra("id",1);

        String namaSurahDetail = getIntent().getStringExtra("name");
        txtNameSurahDetail = findViewById(R.id.txtJudul);
        txtNameSurahDetail.setText(namaSurahDetail);

       int jumlahAyat = getIntent().getIntExtra("jumlah_ayat",1);
       txtJumlahAyat = findViewById(R.id.txtJmlhAyat);
       txtJumlahAyat.setText("Jumlah Ayat : " + jumlahAyat );

       String namaArabDetail = getIntent().getStringExtra("nama_arabDetail");
       txtNamaArabDetail = findViewById(R.id.txtNamaArab);
       txtNamaArabDetail.setText("Nama Arab : " + namaArabDetail);

       String tempatTurunDetail = getIntent().getStringExtra("tempatTurunSurat");
       txtTempatTurunDetail = findViewById(R.id.txtTempatDiturunkan);
       txtTempatTurunDetail.setText("Tempat Diturunkan : " + tempatTurunDetail );


       mediaPlay = new MediaPlayer();
       String audioUrl = getIntent().getStringExtra("audio_url");
       btnAudio =findViewById(R.id.btnAudio);
       btnAudio.setOnClickListener(view -> {
           if(mediaPlay.isPlaying()){
               pauseAudio();
           }else{
               playAudio(audioUrl);
           }
       });



        setUpView();
        setUpRecyclerView();
        System.out.println(id);
        getDataFromApi(id);

    }


    private void pauseAudio(){
        if(mediaPlay.isPlaying()){
            mediaPlay.pause();
        }
    }

    private void playAudio(String audio)  {
        try {
            mediaPlay.reset();
            mediaPlay.setDataSource(audio);
            mediaPlay.prepare();
            mediaPlay.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    private void setUpView()     {
        recyclerView = findViewById(R.id.recyclerViewAyat);
    }

    private void setUpRecyclerView() {
        adapterAyats = new AdapterAyats(versesItems,artiItem);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterAyats);
    }

    private void getDataFromApi(int id) {
        ApiService.endpoint().getArti(id).enqueue(new Callback<Arti>() {
            @Override
            public void onResponse(Call<Arti> call, Response<Arti> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    DetailSurahActivity.this.artiItem = response.body().getTranslations();
                    getAyatData(getIntent().getIntExtra("id",1));
                }
            }

            @Override
            public void onFailure(Call<Arti> call, Throwable t) {
                Log.d("error", t.toString());
            }


        });
    }

    private void getAyatData(int id) {
        ApiService.endpoint().getAyat(id).enqueue(new Callback<Verses>() {
            @Override
            public void onResponse(Call<Verses> call, Response<Verses> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    DetailSurahActivity.this.versesItems = response.body().getVerses();
                    adapterAyats.setData(versesItems,artiItem);

                }

            }
            @Override
            public void onFailure(Call<Verses> call, Throwable t) {
                Log.d("error", t.toString());
            }
        });
    }


}
