package com.example.myapplicationtestnew.apiCall;

import com.example.myapplicationtestnew.Constants;
import com.example.myapplicationtestnew.MainActivity;
import com.example.myapplicationtestnew.ModelForLogin.LoginRequest;
import com.example.myapplicationtestnew.ModelForLogin.LoginRespond;
import com.example.myapplicationtestnew.Url.LoginUrl;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LoginApiCall {
    String endpoint=Constants.header;
    @Headers({"Content-type: application/json", "Accept: */*"})
    @POST("endpoint")
    Call<LoginRespond> apiCall(@Url String url, @Body LoginRequest loginRequest );

}
