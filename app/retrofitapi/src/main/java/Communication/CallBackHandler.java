package Communication;

import com.wallet.retrofitapi.api.ServerResponse;

import java.util.ArrayList;

public interface CallBackHandler
{
    public void getResponseBack(String response, ArrayList<Object> extraData);
}
