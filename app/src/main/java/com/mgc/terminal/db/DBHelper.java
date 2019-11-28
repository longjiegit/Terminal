package com.mgc.terminal.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DBHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="term.db";
    public static int DATABASE_VERSION=1;
    private static DBHelper helper;

    public DBHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    public  static DBHelper getInstance(Context context){
        if(helper==null){
            helper=new DBHelper(context,DATABASE_NAME,DATABASE_VERSION);
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists servurl (id integer primary key autoincrement,url varchar(60),port int,password varchar(60))");
        ContentValues contentValues=new ContentValues();
        contentValues.put("url","192.168.1.116");
        contentValues.put("port",9080);
        contentValues.put("password","123456");
        db.insert("servurl",null,contentValues);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
