package com.apps.aplikasiresepmasakan.view.SemuaMenu;

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
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SemuaMenuFragment extends Fragment {
    @BindView(R.id.recyclerSemuaMenu) RecyclerView recyclerView;


    Call<ResepModels> call;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (RelativeLayout) inflater.inflate(R.layout.fragment_semua_menu, container, false);
        getActivity().setTitle("Semua Menu");
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this,view);
        tampildata(null);
        return view;
    }



    void tampildata(String cari){
        APIService service=APIEndPoint.getClient().create(APIService.class);

        if(cari == null){
            call=service.getsemuadata();
        } else{
            call=service.getdataByNama(cari);
        }

        Call<ResepModels> call=service.getsemuadata();
        call.enqueue(new Callback<ResepModels>() {
            @Override
            public void onResponse(Call<ResepModels> call, Response<ResepModels> response) {
                //Toast.makeText(getActivity().getApplicationContext(),"total ="+response.body().getTotal_result(),Toast.LENGTH_LONG).show();
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

