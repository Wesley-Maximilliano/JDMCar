package com.if4a.jdmcar.API;

import com.if4a.jdmcar.Model.ModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ModelResponse> ardRetrieve();
}
