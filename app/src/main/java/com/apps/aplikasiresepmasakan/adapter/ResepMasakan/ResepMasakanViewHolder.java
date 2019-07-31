package com.apps.aplikasiresepmasakan.adapter.ResepMasakan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.aplikasiresepmasakan.R;
import com.apps.aplikasiresepmasakan.model.ResultResep;
import com.apps.aplikasiresepmasakan.view.SemuaMenu.IsiSemuaActivity;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResepMasakanViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.gambar_tampilan_semua) ImageView gambarSemua;
    @BindView(R.id.txtSemua_Nama_makanan) TextView namaSemua;
    @BindView(R.id.txtSemua_Jenis_Makanan) TextView jenisSemua;

    private List<ResultResep> resultResepList = new ArrayList<>();

    public ResepMasakanViewHolder(@NonNull View view) {


        super(view);
        ButterKnife.bind(this,view);
    }


    public  void setItem(List<ResultResep> item){
        resultResepList = item;
    }
    @OnClick()
    void click(@NonNull View itemView){
        int position = getAdapterPosition();
        String gambar = resultResepList.get(position).getGambar_masakan();
        String nama_masakan = resultResepList.get(position).getNama_masakan();
        String resep_masakan = resultResepList.get(position).getResep_masakan();
        String cara_masak = resultResepList.get(position).getCara_masak();

        Intent intent = new Intent(itemView.getContext(), IsiSemuaActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("gambar", gambar);
        intent.putExtra("nama_masakan", nama_masakan);
        intent.putExtra("resep_masakan", resep_masakan);
        intent.putExtra("cara_masak", cara_masak);
        itemView.getContext().startActivity(intent);

    }

}
