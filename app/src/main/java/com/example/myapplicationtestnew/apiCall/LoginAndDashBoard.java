package com.example.myapplicationtestnew.apiCall;
import com.example.myapplicationtestnew.modelForV1AndV2.ModelV1Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginAndDashBoard {
    String BaseUrl="https://itpl.iserveu.tech/generate/";
    @GET("v1")
    Call<ModelV1Response> getV1();
    @GET("v2")
    Call<ModelV1Response> getV2();
}
