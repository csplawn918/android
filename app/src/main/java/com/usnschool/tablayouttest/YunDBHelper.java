package com.usnschool.tablayouttest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by it on 2017-03-08.
 */

public class YunDBHelper extends SQLiteOpenHelper {

    public YunDBHelper(Context context){
        super(context,"register1.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE register1("
                +"_index integer primary key autoincrement"
                +",emil text"
                +",pw text"
                +")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS register1");
        onCreate(db);
    }
}
