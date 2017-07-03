package com.usnschool.tablayouttest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by it on 2017-03-10.
 */

public class YunDBSearch {
    private String email;
    private String pw;
    private YunDBHelper dbHelper;

    public YunDBSearch(YunDBHelper dbHelper){
        this.dbHelper=dbHelper;
    }
    public String searchIdPw(String str){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT emil,pw FROM register1 WHERE emil='"+str+"'",null);
        while(cursor.moveToNext()){
            email =cursor.getString(0);
            pw=cursor.getString(1);
        }
        return email+" "+pw;
    }

}
