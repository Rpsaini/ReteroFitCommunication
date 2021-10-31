package Communication;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.wallet.retrofitapi.R;
import com.wallet.retrofitapi.api.RxAPICallHelper;
import com.wallet.retrofitapi.api.RxAPICallback;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;
import retrofit2.Response;

public class RetrofitCommunication
{
    public RetrofitCommunication()
    {

    }
    public void sendToServer(Observable<Response<Object>> responseObservable, AppCompatActivity appCompatActivity, int loaderLayout, int noInternetlayout, boolean isShowLoader, CallBackHandler callBackHandler)
     {
       try
       {
           if(checkInternetState(appCompatActivity,noInternetlayout))
            {
               showProgressDialog(appCompatActivity, loaderLayout,isShowLoader);
               RxAPICallHelper.call(responseObservable, new RxAPICallback<Response<Object>>()
                 {
                   @Override
                   public void onSuccess(Response<Object> t)
                   {
                       System.out.println("inside suceess==="+new Gson().toJson(t.body()));
                       hideProgressDialog();
                       try {
                           callBackHandler.getResponseBack(new JSONObject(new Gson().toJson(t.body())),null);
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   }

                   @Override
                   public void onFailed(Throwable throwable)
                   {
                       System.out.println("Error==="+throwable+"==="+throwable.getMessage());
                       hideProgressDialog();
                       callBackHandler.getResponseBack(null,null);
                   }
               });
             }
       }
       catch (Exception e)
       {
           hideProgressDialog();
           e.printStackTrace();
       }

    }
    Dialog progressdlg;
    private void showProgressDialog(Context context,int loaderLayout,boolean isShowLoader)
    {
        if(isShowLoader)
        {
            hideProgressDialog();
            progressdlg = new Dialog(context);
            progressdlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
            progressdlg.setContentView(loaderLayout);
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            Window window = progressdlg.getWindow();
            lp.copyFrom(window.getAttributes());
            progressdlg.setCancelable(false);
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(lp);

            progressdlg.getWindow().setBackgroundDrawableResource(R.color.translucent_black);
            progressdlg.getWindow().setDimAmount(0);
            progressdlg.show();
        }

    }
    private void hideProgressDialog()
    {
        if (progressdlg != null && progressdlg.isShowing()) {
            progressdlg.hide();
        }
    }

    private boolean checkInternetState(Context ct,int noInternetLayout)
    {
        try {

            ConnectivityManager cm = (ConnectivityManager)ct.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm.getActiveNetworkInfo() != null) {
                return true;
            } else {

                noInternetDialog(ct,noInternetLayout);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    private Dialog internetDialog;
    private void noInternetDialog(Context context,int noInternetlayout)
    {
        if(internetDialog!=null&&internetDialog.isShowing())
        {
            internetDialog.hide();
        }
        internetDialog = new Dialog(context);
        internetDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        internetDialog.setContentView(noInternetlayout);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = internetDialog.getWindow();
        lp.copyFrom(window.getAttributes());
        internetDialog.setCancelable(false);
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        internetDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_black);
        internetDialog.getWindow().setDimAmount(0);
        internetDialog.show();

    }


}
