package Communication;

import androidx.appcompat.app.AppCompatActivity;

import com.wallet.retrofitapi.api.AddEventInterface;
import com.wallet.retrofitapi.api.ApiProduction;
import com.wallet.retrofitapi.api.ServerResponse;

import java.io.File;
import java.util.ArrayList;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


public class BuildRequestParms
{
    public BuildRequestParms()
    {

    }
    public RequestBody getRequestBody(String data)
    {
        return RequestBody.create(MediaType.parse("text/plain"), data);
    }

    public ArrayList<Object> getMultipart(String nameOfImageParamsAtServer, File file)
    {
        ArrayList<Object> imageObj=new ArrayList<>();
           //nameOfImageParamsAtServer like payment_receipt
            RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData(nameOfImageParamsAtServer, file.getName(), requestBody);
            imageObj.add(body);
            RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());
            imageObj.add(filename);
            return  imageObj;
    }

    public   AddEventInterface getFinalRequest(AppCompatActivity appCompatActivity)
    {
        return ApiProduction.getInstance(appCompatActivity,"").provideService(AddEventInterface.class);

    }


}
