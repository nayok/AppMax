package cph.nayok.max.appbie;

import android.content.Context;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by PCYOU on 4/26/2017.
 */

public class PostData extends AsyncTask<String, Void, String> {

    private Context context;
//    private static final String urlPHP = "http://swiftcodingthai.com/cph/addusermax.php";
private static final String urlPHP = "http://swiftcodingthai.com/cph/addUserMaster.php";

    public PostData(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("User", params[0])
                    .add("Name", params[1])
                    .add("Password", params[2])
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("26AprilV1", "e doin ==>" + e.toString());
            return null;

        }


    }
}//main


