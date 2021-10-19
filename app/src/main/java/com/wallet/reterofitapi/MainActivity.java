package com.wallet.reterofitapi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wallet.retrofitapi.api.AddEventInterface;
import com.wallet.retrofitapi.api.ServerResponse;

import java.util.ArrayList;

import Communication.BuildRequestParms;
import Communication.RetrofitCommunication;
//import okhttp3.MultipartBody;

public class MainActivity extends AppCompatActivity
  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BuildRequestParms buildRequestParms=new BuildRequestParms();
        RetrofitCommunication retrofitCommunication=new RetrofitCommunication();

//        ArrayList<Object> data=buildRequestParms.getMultipart("payment_receipt",file);
//        MultipartBody.Part body=data.get(0);
//        RequestBody filename=(RequestBody) data.get(1);
//
//
//        String RtokenHeader = getDeviceToken();
//        AddEventInterface addEventInterface= ApiProduction.getInstance(this,getApiUrl()).provideService(AddEventInterface.class);
//        Observable<Response<ServerResponse>>  responseObservable = addEventInterface.uploadImage(buildRequestParms.getRequestBody(savePreferences.reterivePreference(DepositeInrActivity.this, DefaultConstants.token).toString())
//                , buildRequestParms.getRequestBody(getDeviceToken())
//                , buildRequestParms.getRequestBody(getAppVersion()), buildRequestParms.getRequestBody("Android")
//                , getXapiKey(), RtokenHeader, body, filename,buildRequestParms.getRequestBody("INR")
//                ,buildRequestParms.getRequestBody(ed_amount.getText().toString()),
//                 buildRequestParms.getRequestBody(txt_deposit_code.getText().toString())
//                ,buildRequestParms.getRequestBody(ed_remarks.getText().toString()));
//
//
//        retrofitCommunication.sendToServer(responseObservable, this, R.layout.progressbar, R.layout.progressbar, true,new CallBackHandler() {
//            @Override
//            public void getResponseBack(ServerResponse serverResponse, ArrayList<Object> arrayList) {
//                System.out.println("Response handler-----"+serverResponse.getMsg());
//
//            }
//        });
      }



}