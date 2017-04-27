package cph.nayok.max.appbie;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by PCYOU on 4/27/2017.
 */

public class GetData extends AsyncTask<String, Void, String>{    //Alt + Enter

    private Context context;

    public GetData(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient(); //สืบทอด class OkHttp
            Request.Builder builder = new Request.Builder(); //ctrl+spacebar
            Request request = builder.url (params[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();




        } catch (Exception e) {
            Log.d("27AprilV1", "e doin ==>" + e.toString());
            return null;
        }


    }
}//Main Class หลักจร้าาา
