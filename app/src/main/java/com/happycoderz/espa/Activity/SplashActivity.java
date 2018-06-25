package com.happycoderz.espa.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.happycoderz.espa.Interface.EspaInterface;
import com.happycoderz.espa.R;
import com.happycoderz.espa.model.Category;
import com.happycoderz.espa.model.Contact;
import com.happycoderz.espa.model.Corporate;
import com.happycoderz.espa.model.EspaResponse;
import com.happycoderz.espa.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getEspaInformation();
    }


    private void getEspaInformation(){

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(EspaInterface.baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        EspaInterface apiInterface = retrofit.create(EspaInterface.class);

        Call<EspaResponse> call = apiInterface.getEspaResponse();

        call.enqueue(new Callback<EspaResponse>() {
            @Override
            public void onResponse(Call<EspaResponse> call, Response<EspaResponse> response) {

                EspaResponse espaResponse = response.body();

                Log.v("first corporate id : ", String.valueOf(espaResponse.corporate.get(0).getId()));
                Log.v("first prosndnsjkfds : ",String.valueOf(espaResponse.categories.get(0).products.get(0).getTitle()));

            }

            @Override
            public void onFailure(Call<EspaResponse> call, Throwable t) {

            }
        });
    }
}
