package com.wallet.reterofitapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;


import com.wallet.reterofitapi.databinding.ActivityMainBinding;
import com.wallet.retrofitapi.api.AddEventInterface;
import com.wallet.retrofitapi.api.ApiProduction;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import Communication.BuildRequestParms;
import Communication.CallBackHandler;
import Communication.RetrofitCommunication;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Header;
import retrofit2.http.Part;
public class MainActivity extends AppCompatActivity
  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new AppViewModel());
        activityMainBinding.executePendingBindings();


        BuildRequestParms buildRequestParms=new BuildRequestParms();
        RetrofitCommunication retrofitCommunication=new RetrofitCommunication();
        AddEventInterface apiParamsInterface = ApiProduction.getInstance(this,"http://3.7.175.33/dev/api/").provideService(AddEventInterface.class);

        Observable<Response<Object>> observable =apiParamsInterface.loginApi(
                buildRequestParms.getRequestBody("vishal.khanjan@gmail.com"),
                buildRequestParms.getRequestBody("Welcome@123"),
                buildRequestParms.getRequestBody("123456"),
                buildRequestParms.getRequestBody("android"),
                "9WzxHOqJ0NcyWvmjIv9"
                );

        retrofitCommunication.sendToServer(observable, this, R.layout.activity_main, R.layout.activity_main, true, new CallBackHandler() {
            @Override
            public void getResponseBack(JSONObject response, ArrayList<Object> extraData) {
              try
              {
                  System.out.println("Response back=data==="+response);
              }
              catch (Exception e)
              {
                  e.printStackTrace();
              }

            }
        });
     }


      @BindingAdapter({"toastMessage"})
      public static void runMe(View view, String message)
      {
          if (message != null)
              Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
      }
  }