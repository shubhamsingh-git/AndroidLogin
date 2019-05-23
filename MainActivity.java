package com.example.myapplicationlogin;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final String TAG = SQLDatabase.class.getCanonicalName();
private static EditText username;
private static EditText password;
private static Button button;
private static Button breg;
private static String user,pass;
SQLDatabase sdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sdb=new SQLDatabase(this);
        onLogin();
        onClickRegistration();
    }

    public void onLogin(){
        username=(EditText)findViewById(R.id.edittext_username);
        password=(EditText)findViewById(R.id.edittext_pasword);
        button=(Button)findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               user=username.getText().toString();
               pass=password.getText().toString();


               if(user.isEmpty()||pass.isEmpty()){
                   Toast.makeText(MainActivity.this,"please fill the details correctly",Toast.LENGTH_LONG).show();
               }
                Cursor res=sdb.getDetails(user,pass);
               if(res.getCount()==0){
                   Toast.makeText(MainActivity.this,"Login UnSuccessfull",Toast.LENGTH_LONG).show();

               }else{
                   Toast.makeText(MainActivity.this,"Login Successfull",Toast.LENGTH_LONG).show();
                   Intent intent=new Intent(".User");
                   startActivity(intent);
               }
            }
        });

    }
    public void onClickRegistration(){
        breg=(Button)findViewById(R.id.url);
        breg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(".Registration");
                startActivity(intent);
            }
        });
    }
}
