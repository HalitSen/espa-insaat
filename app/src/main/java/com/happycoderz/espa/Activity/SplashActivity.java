package com.happycoderz.espa.Activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.happycoderz.espa.BuildConfig;
import com.happycoderz.espa.Interface.EspaInterface;
import com.happycoderz.espa.R;
import com.happycoderz.espa.helper.CacheHelper;
import com.happycoderz.espa.model.Category;
import com.happycoderz.espa.model.Contact;
import com.happycoderz.espa.model.Corporate;
import com.happycoderz.espa.model.EspaResponse;
import com.happycoderz.espa.model.News;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity {

    private static Gson GSON = new Gson();

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private static final String PREFERENCES_NAME = BuildConfig.APPLICATION_ID;
    private static final int PREFERENCES_MODE = Activity.MODE_PRIVATE;
    CacheHelper cacheHelper;

    Handler handler;
    @BindView(R.id.progres_bar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        handler = new Handler();

        cacheHelper = new CacheHelper(this);

        getEspaInformation();
    }

    private void getEspaInformation() {

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
                Log.v("first product : ", String.valueOf(espaResponse.categories.get(0).products.get(0).getTitle()));

                cacheHelper.putObject("espaInfo",espaResponse);
                openMain();
            }

            @Override
            public void onFailure(Call<EspaResponse> call, Throwable t) {

            }
        });
    }

    private void openMain(){

        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, getString(R.string.progress_text), 0, 500); // see this max value coming back here, we animate towards that value
        animation.setDuration(5000); //in milliseconds
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        }, 2000);
    }
}
