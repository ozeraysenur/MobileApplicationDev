package com.example.mytest2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperLogin extends SQLiteOpenHelper {
    public DBHelperLogin(Context context) {
        super(context, "Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase lgnDB) {
        lgnDB.execSQL("create table users(username Text primary key, password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase lgnDB, int i, int i1) {
        lgnDB.execSQL("drop table if exists users");

    }
    //method for inserting data to database
    public boolean insertData(String username,String password){
        SQLiteDatabase lgnDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = lgnDB.insert("users",null,contentValues);

        if(result == -1){
            return false;

        }
        else{
            return true;
        }
    }

    public boolean checkuserName(String username){
        SQLiteDatabase lgnDB = this.getWritableDatabase();
        Cursor cursor = lgnDB.rawQuery("select * from users where username = ? ",new String[] {username});

        if(cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }

    }

    //method for checking username and password
    public boolean checkuserNamePassword(String username, String password){
        SQLiteDatabase lgnDB = this.getWritableDatabase();
        Cursor cursor = lgnDB.rawQuery("select * from users where username = ? and password = ?",new String[] {username , password});

        if(cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }

    }
}
