package com.usnschool.tablayouttest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class YunDBInfoActivity extends AppCompatActivity {
    private ListView listView;
    private YunCustomData data;
    private YunCustomAdapter adapter;
    private ArrayList<YunCustomData > arr = new ArrayList();
    private YunDBHelper dbHelper = new YunDBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yun_dbinfo_activity);

        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM register1",null);

        while(cursor.moveToNext()){
            int idx=cursor.getInt(0);
            String email=cursor.getString(1);
            String pw =cursor.getString(2);
            data=new YunCustomData(idx,email,pw);
            arr.add(data);
        }

        adapter=new YunCustomAdapter(YunDBInfoActivity.this,R.layout.yun_customdata_activity,arr);
        listView=(ListView)findViewById(R.id.yun_dbInfo_listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("INFO",arr.get(position).getEmail()+" "+arr.get(position).getPw());
                setResult(RESULT_OK,intent);
                YunDBInfoActivity.this.finish();
            }
        });
    }
}
