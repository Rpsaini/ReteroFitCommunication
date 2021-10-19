package Communication;

import java.util.ArrayList;

public interface CallBackHandler
{
    public void getResponseBack(Object response, ArrayList<Object> extraData);
}
