package com.example.quranmobile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranmobile.SurahModels.ChaptersItem;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    private List<ChaptersItem> results;


    public MainAdapter(List<ChaptersItem> results){
        this.results = results;
//
    }

    @NonNull
    @Override
    public MainAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.viewHolder holder, int position) {
        ChaptersItem result = results.get(position);
        holder.txtNamaSurah.setText(result.getNameSimple());
        holder.txtArtiNamaSurah.setText(result.getTranslatedName().getName());
        holder.txtNamaSurahArab.setText(result.getNameArabic());

        holder.myCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.myCardView.getContext(),DetailSurahActivity.class);

                intent.putExtra("id",result.getId());
                holder.myCardView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        CardView myCardView;
        TextView txtNamaSurah,txtArtiNamaSurah,txtNamaSurahArab;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            myCardView = itemView.findViewById(R.id.myCardView);
            txtNamaSurah = itemView.findViewById(R.id.txtSurah);
            txtArtiNamaSurah = itemView.findViewById(R.id.txtArtiSurah);
            txtNamaSurahArab = itemView.findViewById(R.id.txtSurahArab);
        }
    }

    public void setData(List<ChaptersItem> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
}
