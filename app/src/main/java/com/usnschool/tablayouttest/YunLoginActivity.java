package com.usnschool.tablayouttest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by it on 2017-03-17.
 */

public class YunLoginActivity extends AppCompatActivity {
    private EditText editTextEmail,editTextPw;

    private YunDBHelper dbHelper;
    private YunDBSearch dbSearch;
    private Intent intent;

    private final int REQUEST_CODE=12;


    private Spinner spinner;
    private YunCustomSpinnerData data;
    private YunCustomSpinnerAdapter adapter;
    private ArrayList<YunCustomSpinnerData > arr = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yun_login_activity);

        editTextEmail = (EditText) findViewById(R.id.yun_login_EditEmail);
        editTextPw = (EditText) findViewById(R.id.yun_login_EditPw);

        dbHelper = new YunDBHelper(this);
        dbSearch = new YunDBSearch(dbHelper);


        spinner=(Spinner)findViewById(R.id.spinner);

        YunCustomSpinnerData yunCustomData =new YunCustomSpinnerData("공지사항");
        arr.add(yunCustomData);
        YunCustomSpinnerData yunCustomData1 =new YunCustomSpinnerData("PHP");
        arr.add(yunCustomData1);
        YunCustomSpinnerData yunCustomData2 =new YunCustomSpinnerData("DB");
        arr.add(yunCustomData2);
        YunCustomSpinnerData yunCustomData3 =new YunCustomSpinnerData("JSP");
        arr.add(yunCustomData3);
        adapter=new YunCustomSpinnerAdapter(this,R.layout.yun_custom_spinner,arr);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(YunLoginActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

    }


    public void onClickLogin(View view){
        String dbEmail=dbSearch.searchIdPw(editTextEmail.getText().toString());
        String[] arr=dbEmail.split(" ");
        String email=arr[0];
        String pw=arr[1];

        if(editTextEmail.getText().toString().equals(email)&&editTextPw.getText().toString().equals(pw)){
            Intent intent = new Intent(YunLoginActivity.this,MainActivity.class);
            YunLoginActivity.this.startActivity(intent);
        }else{
            if(!editTextEmail.getText().toString().equals(email)){
                Toast.makeText(YunLoginActivity.this, "이메일이 틀립니다", Toast.LENGTH_SHORT).show();
            }
            if(!editTextPw.getText().toString().equals(pw)){
                Toast.makeText(YunLoginActivity.this, "비밀번호가 틀립니다", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onClickRegister(View view){
        intent = new Intent(YunLoginActivity.this,YunRegisterActivity.class);
        YunLoginActivity.this.startActivity(intent);
    }
    public void onClickDBInfo(View view){
        intent = new Intent(YunLoginActivity.this,YunDBInfoActivity.class);
        YunLoginActivity.this.startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str[]=data.getStringExtra("INFO").split(" ");
        editTextEmail.setText(str[0]);
        editTextPw.setText(str[1]);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
