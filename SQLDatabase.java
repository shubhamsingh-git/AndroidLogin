package com.example.myapplicationlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLDatabase  extends SQLiteOpenHelper {

    public static final String TAG = SQLDatabase.class.getCanonicalName();

    private static final String DATABASE_NAME="users.db";
    private static final String DATABASE_TABLE="user";
    private static final String col1="userid";
    private static final String col2="username";
    private static final String col3="password";
    private static final String col4="confirm_password";
    private static final String col5="mobile_number";

    public SQLDatabase(Context context) {
        super(context, DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DATABASE_TABLE+"(USERID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,PASSWORD TEXT,CONFIRM_PASSWORD TEXT,MOBILE_NUMBER INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Boolean onClickInsertData(String username,String password, String cpassowrd, String mobile ){
        Log.d(TAG, "username: " + username + ", password: " + password);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,username);
        cv.put(col3,password);
        cv.put(col4,cpassowrd);
        cv.put(col5,mobile);
        long result = db.insert(DATABASE_TABLE,null,cv);
        if(result==-1){
            return false;
        }else
        {
            return true;
        }
    }
    public Cursor getDetails(String username ,String password){
        Log.d(TAG, "in select query username: " + username + ", password: " + password);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from user where username='"+username+"'and password='"+password+"' ",null);
    return res;
    }
}
