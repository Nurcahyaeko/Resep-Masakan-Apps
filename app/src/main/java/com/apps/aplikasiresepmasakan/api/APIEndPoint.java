package com.apps.aplikasiresepmasakan.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIEndPoint {

    private static final String BASE_URL = "https://kostlab.id/project/eko/api/";

    private static Retrofit retrofit;

    public static Retrofit getClient()
    {
        if(retrofit == null)
        {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;


    }
}
