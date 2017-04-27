package cph.nayok.max.appbie;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.speech.tts.Voice;

/**
 * Created by PCYOU on 4/26/2017.
 */

public class MyAlert {
    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }

    public void myDialog(String strTitle, String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_user);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("จร๊", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}   //Main Class
