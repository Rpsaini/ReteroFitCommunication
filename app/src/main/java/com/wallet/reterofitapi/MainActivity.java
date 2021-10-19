package com.wallet.reterofitapi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.wallet.retrofitapi.api.AddEventInterface;
import com.wallet.retrofitapi.api.ApiProduction;

import java.util.ArrayList;

import Communication.BuildRequestParms;
import Communication.CallBackHandler;
import Communication.RetrofitCommunication;
import io.reactivex.Observable;
//import okhttp3.MultipartBody;

public class MainActivity extends AppCompatActivity
  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BuildRequestParms buildRequestParms=new BuildRequestParms();
        RetrofitCommunication retrofitCommunication=new RetrofitCommunication();
        AddEventInterface apiParamsInterface = ApiProduction.getInstance(this,"http://3.7.175.33/dev/api/").provideService(AddEventInterface.class);

        Observable<Object> observable =apiParamsInterface.loginApi(
                buildRequestParms.getRequestBody("vishal.khanjan@gmail.com"),
                buildRequestParms.getRequestBody("Welcome@123"),
                buildRequestParms.getRequestBody("123456"),
                buildRequestParms.getRequestBody("android"),
                "9WzxHOqJ0NcyWvmjIv9"
        );



        retrofitCommunication.sendToServer(observable, this, R.layout.activity_main, R.layout.activity_main, true,new CallBackHandler() {
            @Override
            public void getResponseBack(Object serverResponse, ArrayList<Object> arrayList)
            {
                System.out.println("Response handler-----"+serverResponse.toString());

            }
        });



      }



}