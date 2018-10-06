package com.example.user.taskapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DBHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String uname, String pword, String phonenum, String email) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DBHelper.USERNAME, uname);
        contentValue.put(DBHelper.PASSWORD, pword);
        contentValue.put(DBHelper.PHONENUMBER, phonenum);
        contentValue.put(DBHelper.MAIL_ID, email);
        database.insert(DBHelper.TABLE_NAME, null, contentValue);
    }



}
