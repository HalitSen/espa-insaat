package com.happycoderz.espa.Interface;


import com.happycoderz.espa.model.EspaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EspaInterface {

    public static final String baseUrl = "http://espainsaat.com/";

    @GET("api.php")
    Call<EspaResponse> getEspaResponse();
}
