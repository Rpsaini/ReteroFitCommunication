package Communication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.wallet.retrofitapi.R;
import com.wallet.retrofitapi.api.AddEventInterface;
import com.wallet.retrofitapi.api.ApiProduction;
import com.wallet.retrofitapi.api.RxAPICallHelper;
import com.wallet.retrofitapi.api.RxAPICallback;
import com.wallet.retrofitapi.api.ServerResponse;
import io.reactivex.Observable;
import retrofit2.Response;

public class RetrofitCommunication
{
    public void sendToServer(Observable<Response<ServerResponse>> responseObservable, AppCompatActivity appCompatActivity,int loaderLayout,int noInternetlayout,CallBackHandler callBackHandler)
     {
       try
       {
           if(checkInternetState(appCompatActivity,noInternetlayout))
            {
               showProgressDialog(appCompatActivity, loaderLayout);
               RxAPICallHelper.call(responseObservable, new RxAPICallback<Response<ServerResponse>>()
                 {
                   @Override
                   public void onSuccess(Response<ServerResponse> t)
                   {
                       callBackHandler.getResponseBack(t.body(),null);
                   }

                   @Override
                   public void onFailed(Throwable throwable) {
                       ServerResponse serverResponse=new ServerResponse();
                       serverResponse.setStatus(false);
                       serverResponse.setMsg(appCompatActivity.getResources().getString(R.string.requestnotcompleted));
                       callBackHandler.getResponseBack(serverResponse,null);
                   }
               });
             }
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

    }
    Dialog progressdlg;
    private void showProgressDialog(Context context,int loaderLayout)
    {
        if(progressdlg!=null&&progressdlg.isShowing())
        {
            progressdlg.hide();
        }
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
    public boolean checkInternetState(Context ct,int noInternetLayout)
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
    public void noInternetDialog(Context context,int noInternetlayout)
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
