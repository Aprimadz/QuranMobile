package com.example.quranmobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranmobile.ArtiModels.TranslationsItem;
import com.example.quranmobile.AyatModels.VersesItem;

import java.util.List;

public class AdapterAyats extends RecyclerView.Adapter<AdapterAyats.ViewHolder> {


     List<VersesItem> results;

     List<TranslationsItem> results1;


    public AdapterAyats(List<VersesItem> results, List<TranslationsItem> results1){

        this.results = results;
        this.results1 = results1;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.ayat,parent,false)
        );

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAyats.ViewHolder holder, int position) {
        VersesItem result = results.get(position);
        TranslationsItem result1 = results1.get(position);
        holder.txtAyat.setText(result.getTextUthmani());
        holder.txtTerjemahAyat.setText(result1.getText());
        holder.txtNomorAyat.setText(String.valueOf(position+1));

    }

    @Override
    public int getItemCount() {
        return results1.size();
    }






    public void setData(List<VersesItem> data, List<TranslationsItem> data1){
//      Ayat
        results.clear();
        results.addAll(data);
//        Arti Ayat
        results1.clear();
        results1.addAll(data1);
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtAyat,txtNomorAyat,txtTerjemahAyat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomorAyat = itemView.findViewById(R.id.txtNoAyat);
            txtAyat = itemView.findViewById(R.id.txtAyat);
            txtTerjemahAyat = itemView.findViewById(R.id.txtTerjemahanAyat);
        }



    }
}
