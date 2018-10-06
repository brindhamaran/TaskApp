package com.example.user.taskapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "CUSTOMERS";

    // Table columns
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String PHONENUMBER = "phonenumber";
    public static final String MAIL_ID = "mail_id";


    // Database Information
    static final String DB_NAME = "TASKAPP.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + USERNAME
            + " INTEGER , " + PASSWORD + " TEXT NOT NULL, " + PHONENUMBER + " INTEGER , " + MAIL_ID + " TEXT NOT NULL);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
