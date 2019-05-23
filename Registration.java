package com.example.myapplicationlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {

    public static final String TAG = Registration.class.getCanonicalName();

private static EditText username;
private static EditText password;
private static EditText cpassword;
private static EditText mobile;
private static Button button_reg;
SQLDatabase sdb;
String user,pass,cpass,mob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        sdb=new SQLDatabase(this);
        setUIData();
        signUpStatus();
    }
    public void setUIData(){
        username=(EditText)findViewById(R.id.username_reg_ed);
        password=(EditText)findViewById(R.id.password_reg_ed);
        cpassword=(EditText)findViewById(R.id.confirm_password_reg_ed);
        mobile=(EditText)findViewById(R.id.mobile_reg_ed);
        button_reg=(Button)findViewById(R.id.button_reg);
    }
    public void encryptPassword(){
        String key=password.getText().toString();
        char []k=key.toCharArray();
        for(int i=0;i<k.length;i++)
        {
            if
        }
    }
    public void signUpStatus(){

        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                user=username.getText().toString();
                pass=password.getText().toString();
                cpass=cpassword.getText().toString();
                mob=mobile.getText().toString();

                Log.d(TAG, "onClick() user: " + user + ", pass: " + pass + ", cpass: " + cpass + " and mob: " + mob);
                if(user.isEmpty() || pass.isEmpty() || cpass.isEmpty() || mob.isEmpty() || !pass.equals(cpass))
                {
                    Toast.makeText(Registration.this,"Please Enter Your Details Correctly",Toast.LENGTH_LONG).show();
                }else {
                    boolean result = sdb.onClickInsertData(user, pass, cpass, mob);
                    if (result) {
                        Toast.makeText(Registration.this, "Registration is successfull", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(".MainActivity");
                        startActivity(intent);
                    } else {
                        Toast.makeText(Registration.this, "Registration is failed", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
