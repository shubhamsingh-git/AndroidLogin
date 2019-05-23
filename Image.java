package com.example.myapplicationlogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Image extends Activity {
private static EditText num;
private static EditText num1;
private static TextView text;
private static EditText string;
private static Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        onClickCalculateString();
    }
    public void onClickAdd(View v){

        num=(EditText)findViewById(R.id.cal1);
        num1=(EditText)findViewById(R.id.cal2);
        text=(TextView)findViewById(R.id.textview_operation);
        int a,b;
        a=Integer.parseInt(num.getText().toString());
        b=Integer.parseInt(num1.getText().toString());
        int c;
        c=a+b;
        text.setText(Integer.toString(c));
    }
    public void onClickSub(View v){

        num=(EditText)findViewById(R.id.cal1);
        num1=(EditText)findViewById(R.id.cal2);
        int a,b;
        a=Integer.parseInt(num.getText().toString());
        b=Integer.parseInt(num1.getText().toString());
        int c;
        c=a-b;
        text.setText(Integer.toString(c));
    }
    public void onClickMul(View v){

        num=(EditText)findViewById(R.id.cal1);
        num1=(EditText)findViewById(R.id.cal2);
        int a,b;
        a=Integer.parseInt(num.getText().toString());
        b=Integer.parseInt(num1.getText().toString());
        int c;
        c=a*b;
        text.setText(Integer.toString(c));
    }
    public void onClickDiv(View v){

        num=(EditText)findViewById(R.id.cal1);
        num1=(EditText)findViewById(R.id.cal2);
        int a,b;
        a=Integer.parseInt(num.getText().toString());
        b=Integer.parseInt(num1.getText().toString());
        int c;
        c=a/b;
        text.setText(Integer.toString(c));
    }
    public void onClickCalculateString(){
        string=(EditText)findViewById(R.id.words);
        button=(Button)findViewById(R.id.calbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = string.getText().toString();
                String[] num=number.split(" ");
                char a[]=number.toCharArray();
                Toast.makeText(Image.this,"number of Words/letters :"+num.length+"/"+a.length,Toast.LENGTH_LONG).show();
            }
        });
    }
}
