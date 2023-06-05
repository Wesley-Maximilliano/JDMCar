package com.if4a.jdmcar.API;

import com.if4a.jdmcar.Model.ModelResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("pab/retrieve.php")
    Call<ModelResponse> ardRetrieve();

    @FormUrlEncoded
    @POST("pab/create.php")
    Call<ModelResponse> ardCreate(
            @Field("nama_mobil") String nama_mobil,
            @Field("produsen") String produsen,
            @Field("masa_produksi") String masa_produksi,
            @Field("sejarah") String sejarah,
            @Field("gambar_mobil") String gambar_mobil
    );
}
