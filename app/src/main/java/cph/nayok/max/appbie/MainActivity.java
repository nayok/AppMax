package cph.nayok.max.appbie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //ประกาศตัวแปล
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private String userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //การผูกตัวแปล Initial View
        initiaViwe();

        //controller
        controller();

    }// Main Methon

    private void controller() {

        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }

    private void initiaViwe() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtNewRegis);
        button = (Button) findViewById(R.id.btnLogin);
        // textView = (TextView) findViewById()

    }

    @Override
    public void onClick(View v) {
        //For TextViwe
        if (v==textView) {
            //Intent to SignUp ให้ไปสู่หน้าสมัคร
            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }
            //for Button
        if (v==button) {

            //Get Value From EditText
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //Check Space
            if (userString.equals("")||passwordString.equals("")) {
                //Have Space
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("Have Space", "Please Fill All Every Blank");

            } else {

                //No Space
                checkUserAnPass();

            }

        }

    }

    private void checkUserAnPass() {
        try {

//            String urlJSON = "http://swiftcodingthai.com/cph/getDatamax.php";
            String urlJSON = "http://swiftcodingthai.com/cph/getDataMaster.php";
            boolean b = true;
            String[] columnStrings = new String[]{"id", "Name", "User", "Password"};
            String[] loginStrings = new String[columnStrings.length];



            GetData getData = new GetData(MainActivity.this);
            getData.execute(urlJSON);
            String strJSON = getData.get();
            Log.d("27AprilV1", "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);

            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString(columnStrings[2]))) {
                    b = false;
                    for (int i1=0;i1<columnStrings.length;i1++) {
                        loginStrings[i1] = jsonObject.getString(columnStrings[i1]);
                        Log.d("27ApirlV1", "loginString(" + i1 + ") ==> " + loginStrings[i1]);
                    }

                }
            }

            if (b) {
                //User False
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("User False","No This User in my Database");

            } else if (passwordString.equals(loginStrings[3])) {
                Toast.makeText(MainActivity.this,"Welcome" + loginStrings[1],
                 Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                intent.putExtra("Login", loginStrings);
                startActivity(intent);
                finish();

            } else {
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("Password False","Please Try Again Password False");
            }

        } catch (Exception e) {
            Log.d("27AprilV1", "e checkUser ==> " + e.toString());
        }
    }
}       //main Class นี่คือ คลาสหลัก
