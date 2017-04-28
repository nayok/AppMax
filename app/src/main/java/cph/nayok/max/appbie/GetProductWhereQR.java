package cph.nayok.max.appbie;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by PCYOU on 4/28/2017.
 */

public class GetProductWhereQR extends AsyncTask<String, Void, String>{

    private Context context ; // context ใช้ในการสื่อสาร
    //private static final String urlPHP = "http://swiftcodingthai.com/cph/getProductWhereQRSupermax.php";





    public GetProductWhereQR(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(String... params) {


        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add(params[0], params[1])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[2]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();



        } catch (Exception e) {
            Log.d("28AprilV1", "e doin ==>" + e.toString());

        }

        return null;
    }
}//Main Class
