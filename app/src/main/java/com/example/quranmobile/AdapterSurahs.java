package com.example.quranmobile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSurahs extends RecyclerView.Adapter<AdapterSurahs.SurahViewHolder> {
    ArrayList<SurahModel> arrayListSurahs;


    public AdapterSurahs(ArrayList<SurahModel> arrayListSurahs){
        this.arrayListSurahs = arrayListSurahs;
    }

    @NonNull
    @Override
    public AdapterSurahs.SurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return  new SurahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SurahViewHolder holder, int position) {
        final SurahModel surah = arrayListSurahs.get(position);

        holder.txtNamaSurah.setText(surah.getNameSimple());
        holder.txtArtiNamaSurah.setText(surah.getTranslatedName().getName());
        holder.txtNamaSurahArab.setText(surah.getNameArabic());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailSurahActivity.class);
                intent.putExtra("Chapters",surah);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListSurahs.size();
    }

    public class SurahViewHolder extends RecyclerView.ViewHolder {

        TextView txtNamaSurah, txtArtiNamaSurah, txtNamaSurahArab;

        public SurahViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNamaSurah = itemView.findViewById(R.id.txtSurah);
            txtArtiNamaSurah = itemView.findViewById(R.id.txtArtiSurah);
            txtNamaSurahArab = itemView.findViewById(R.id.txtSurahArab);
        }
    }
}
