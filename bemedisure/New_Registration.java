package com.example.bublly.bemedisure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by BUBLLY on 20-11-2016.
 */
public class New_Registration extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "New_Sign_up";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_QUERY =
            "CREATE TABLE "+UserContract1.sign_up_info.TABLE_NAME+"("+UserContract1.sign_up_info.EMAIL+" TEXT,"
                    +UserContract1.sign_up_info.PASSWORD+" TEXT);";

    New_Registration new_registration;
    SQLiteDatabase sqLiteDatabase;

    public New_Registration(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Sign UP DATABASE CREATED / OPENED !!!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Sign UP DATABASE CREATED !!!");
    }

    public void addInformation(String email,String password,SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract1.sign_up_info.EMAIL,email);
        contentValues.put(UserContract1.sign_up_info.PASSWORD, password);
        db.insert(UserContract1.sign_up_info.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "NEW REGISTRATION SUCCESSFULLY DONE !!!");
    }

    public String verifyInformation(String email)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "select email, password from "+UserContract1.sign_up_info.TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        String a,b;
        b = "User Name Not Found !!";

        Log.e("DATABASE OPERATIONS", "Processing !!!");

        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                if(a.equals(email))
                {
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return  b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
