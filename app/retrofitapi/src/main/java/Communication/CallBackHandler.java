package Communication;

import org.json.JSONObject;

import java.util.ArrayList;

public interface CallBackHandler
{
    public void getResponseBack(JSONObject response, ArrayList<Object> extraData);
}
