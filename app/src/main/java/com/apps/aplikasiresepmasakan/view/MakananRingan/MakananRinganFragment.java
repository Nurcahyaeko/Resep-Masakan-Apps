package com.apps.aplikasiresepmasakan.view.MakananRingan;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apps.aplikasiresepmasakan.R;
import com.apps.aplikasiresepmasakan.adapter.ResepMasakan.ResepMasakanAdapter;
import com.apps.aplikasiresepmasakan.api.APIEndPoint;
import com.apps.aplikasiresepmasakan.api.APIService;
import com.apps.aplikasiresepmasakan.model.ResepModels;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakananRinganFragment extends Fragment {
    @BindView(R.id.recyclerRinganMenu) RecyclerView recyclerView;

    public MakananRinganFragment(){}
    RelativeLayout view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = (RelativeLayout) inflater.inflate(R.layout.fragment_makanan_ringan, container, false);
        getActivity().setTitle("Makanan Ringan");
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this,view);
        tampildata();
        return view;
    }
    void tampildata(){
        APIService service= APIEndPoint.getClient().create(APIService.class);
        Call<ResepModels> call=service.getdataringan();
        call.enqueue(new Callback<ResepModels>() {
            @Override
            public void onResponse(Call<ResepModels> call, Response<ResepModels> response) {
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setHasFixedSize(true);
                ResepMasakanAdapter resepMasakanAdapter=new ResepMasakanAdapter(getActivity().getApplicationContext(),response.body().getResults());
                recyclerView.setAdapter(resepMasakanAdapter);
            }

            @Override
            public void onFailure(Call<ResepModels> call, Throwable t) {

            }
        });
    }
}


