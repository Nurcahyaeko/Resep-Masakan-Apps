package com.apps.aplikasiresepmasakan.adapter.ResepMasakan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.aplikasiresepmasakan.R;
import com.apps.aplikasiresepmasakan.model.ResultResep;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ResepMasakanAdapter extends RecyclerView.Adapter<ResepMasakanViewHolder> {

    private Context context;
    private List<ResultResep> resultResepList;

    ///constructor
    public ResepMasakanAdapter(Context context, List<ResultResep> resultResepList){
        this.context = context;
        this.resultResepList = resultResepList;
    }

    @NonNull
    @Override
    public ResepMasakanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_semua,viewGroup,false);

        return new ResepMasakanViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ResepMasakanViewHolder resepMasakanViewHolder, int i) {
        ResultResep resultResep=resultResepList.get(i);
        resepMasakanViewHolder.namaSemua.setText(resultResep.getNama_masakan());
        resepMasakanViewHolder.jenisSemua.setText(resultResep.getJenis_makanan());
        Glide.with(context)
                .load("https://kostlab.id/project/eko/xfile/gambar_makanan/"+resultResep.getGambar_masakan())
                .apply(new RequestOptions().override(100,100).centerCrop())
                .into(resepMasakanViewHolder.gambarSemua);
        resepMasakanViewHolder.setItem(resultResepList);
    }

    @Override
    public int getItemCount() {

        return resultResepList.size();
    }
}
