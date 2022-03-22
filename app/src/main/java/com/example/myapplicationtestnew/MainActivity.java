package com.example.myapplicationtestnew;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.myapplicationtestnew.Url.LoginUrl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplicationtestnew.ModelForLogin.LoginRequest;
import com.example.myapplicationtestnew.ModelForLogin.LoginRespond;
import com.example.myapplicationtestnew.apiCall.ApiResponceInstances;
import com.example.myapplicationtestnew.apiCall.LoginAndDashBoard;
import com.example.myapplicationtestnew.apiCall.LoginApiCall;
import com.example.myapplicationtestnew.databinding.ActivityMainBinding;
import com.example.myapplicationtestnew.modelForV1AndV2.ModelV1Response;

import org.json.JSONObject;

import javax.xml.transform.ErrorListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public String V1,base64,userId,Password,V1token1,token,hello,base64Token,tempString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        V1="";
        V1=V1fun();
        tempString="";


        userId="itpl";
        Password="Test@123";
        int count =0;
//        Log.d("length",V1.length()+"");
//        for(int i =0; i<V1.length()-5;i++){
//            if(V1.charAt(i)=='/'){
//                count++;
//
//            }
//            if(count==3){
//                tempString=tempString+V1token1.charAt(i);
//            }
//            Log.i("string ! :::: ",tempString);
//
//        }

    }

    public String V1fun() {


        LoginAndDashBoard Login = ApiResponceInstances.retrofit(true).create(LoginAndDashBoard.class);
        Call<ModelV1Response> loginRespondCall = Login.getV1();
        loginRespondCall.enqueue(new Callback<ModelV1Response>() {
            @Override
            public void onResponse(Call<ModelV1Response> call, Response<ModelV1Response> response) {

                try{
                    if(response.body() != null){
                        hello= response.body().getHello();
//                        JSONObject jsonObject = new JSONObject(response.body().getHello());
//                        String url = jsonObject.getString("hello");
                        byte[] data = Base64.decode(hello, Base64.DEFAULT);
                        base64 = new String(data, "UTF-8");
                        Constants.URL=base64;
                        Log.d("base64 1  ! :::: ",base64.length()+"");
                        int count=0;
                        binding.textView.setText(base64);
                        for(int i=26;i<base64.length();i++){
                            tempString=tempString+base64.charAt(i);

                        }
                        Constants.header=tempString;
                        binding.textView.setText(Constants.header);
                        tempString="";
                        login(base64);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ModelV1Response> call, Throwable t) {

            }


        });
        return base64;

    }

    private void login(String base64) {
        JsonObjectRequest
                jsonObjectRequest
                = new JsonObjectRequest(
                Request.Method.POST, base64
                , null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }
    }


