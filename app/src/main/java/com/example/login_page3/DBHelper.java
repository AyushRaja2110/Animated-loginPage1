package com.example.login_page3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String dbname = "signup.db";

    public DBHelper(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String qry = "create table users ( email text primary key , password text ) ";
        sqLiteDatabase.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table if exists users");
    }

    public Boolean insertData(String email , String password){

        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = mydb.insert("users",null,contentValues);

        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkemail(String email){

        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from users where email = ?",new String[] {email});

        if (cursor.getCount()>0){
            return true;
        }
        return false;
    }

    public Boolean checkemailpassword(String email,String password){

        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from users where email = ? and password = ?",new String[] {email,password});

        if (cursor.getCount()>0){
            return true;
        }
        return false;
    }

}
