package com.example.wayofmath;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="Login.db";

    public DBHelper( Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT Primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }
    public Boolean insertdata(String username, String password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", String.valueOf(username));
        contentValues.put("password", String.valueOf(password));
        long result = MyDB.insert("users",null,contentValues);
        return result != -1;
    }
    public Boolean checkusername(String username){
        SQLiteDatabase MyDB =this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("select * from users where username = ?",new String[] {String.valueOf(username)});
        return cursor.getCount() > 0;
    }
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor =MyDB.rawQuery("select * from users where username=? and password =?",new String[] {String.valueOf(username), String.valueOf(password)});
        return cursor.getCount() > 0;
    }
}
