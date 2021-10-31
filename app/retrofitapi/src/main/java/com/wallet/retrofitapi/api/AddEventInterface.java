package com.wallet.retrofitapi.api;


import org.json.JSONObject;

import java.util.LinkedHashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AddEventInterface  {

    @Multipart
    @POST("applogin")
    Observable<Response<Object>> loginApi(
            @Part("username") RequestBody token,
            @Part("password") RequestBody DeviceToken,
            @Part("device") RequestBody device,
            @Part("device_type") RequestBody device_type,
            @Header("x-api-key") String apikey
    );


//    @Part("token") RequestBody token,
//    @Part("DeviceToken") RequestBody DeviceToken,
//    @Part("Version") RequestBody Version,
//    @Part("PlatForm") RequestBody PlatForm,
//    @Header("X-API-KEY") String apikey,
//    @Header("Rtoken") String rtoken,
//    @Part MultipartBody.Part image,
//    @Part("payment_receipt") RequestBody name,
//    @Part("currency") RequestBody currency,
//    @Part("amount") RequestBody amount,
//    @Part("reference") RequestBody reference,
//    @Part("remarks") RequestBody remarks










}
