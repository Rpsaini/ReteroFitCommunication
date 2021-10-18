package com.wallet.reterofitapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.wallet.retrofitapi.api.ServerResponse;

import java.io.File;

import Communication.RetrofitCommunication;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitCommunication retrofitCommunication=new RetrofitCommunication();
      }

}