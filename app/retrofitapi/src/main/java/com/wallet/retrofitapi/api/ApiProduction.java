package com.wallet.retrofitapi.api;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProduction
{
    private static String BASE_URL = "";
    private final Context context;
    private ApiProduction(Context context) {
        this.context = context;
    }
    public static ApiProduction getInstance(AppCompatActivity context,String baseUrl)
    {
        BASE_URL=baseUrl;
        return new ApiProduction(context);
    }
    private Retrofit provideRestAdapter()
     {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpProduction.getOkHttpClient(context, true))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

     }
    public <S> S provideService(Class<S> serviceClass)
     {
        return provideRestAdapter().create(serviceClass);
     }
}
