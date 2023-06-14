package com.example.quranmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranmobile.models.ChaptersItem;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    private List<ChaptersItem> results = new ArrayList<>();
    private Context context;
//    private AdapterListener listener;

    public MainAdapter(List<ChaptersItem> results){
        this.results = results;
//        this.context = context;
    }

    @NonNull
    @Override
    public MainAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false)
        );

    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.viewHolder holder, int position) {
        ChaptersItem result = results.get(position);

       holder.txtNamaSurah.setText(result.getNameSimple());
       holder.txtNamaSurahArab.setText(result.getNameArabic());
       holder.txtArtisurah.setText(result.getTranslatedName().getName());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {


        TextView txtNamaSurah,txtArtisurah,txtNamaSurahArab;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            txtNamaSurah = itemView.findViewById(R.id.txtSurah);
            txtArtisurah = itemView.findViewById(R.id.txtArtiSurah);
            txtNamaSurahArab = itemView.findViewById(R.id.txtSurahArab);
        }
    }

    public void setData(List<ChaptersItem> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
}
