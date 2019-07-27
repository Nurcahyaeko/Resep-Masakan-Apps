package com.apps.aplikasiresepmasakan.api;


import com.apps.aplikasiresepmasakan.model.ResepModels;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {



    @GET("Tabelmasakan/getdata")
    Call<ResepModels> getsemuadata();

    @GET("Tabelmasakan/getdata/?jenis_makanan=Makanan%20Berat")
    Call<ResepModels> getdataberat();

    @GET("Tabelmasakan/getdata/?jenis_makanan=Makanan%20Ringan")
    Call<ResepModels> getdataringan();

    @GET("Tabelmasakan/getdata")
    Call<ResepModels> getdataByNama(@Query("cari") String cari);

}
