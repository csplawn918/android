package com.usnschool.tablayouttest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class YunRegisterActivity extends AppCompatActivity {
    private EditText editEmail,editPw,editPw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yun_register_activity);

        editEmail=(EditText)findViewById(R.id.yun_register_EditTextEmail);
        editPw=(EditText)findViewById(R.id.yun_register_EditTextPw);
        editPw2=(EditText)findViewById(R.id.yun_register_EditTextPw2);
    }

    public void onClickBtnregister(View view){
        String allText = editEmail.getText().toString()+editPw.getText().toString()+editPw2.getText().toString();
        String email=editEmail.getText().toString();
        String pw=editPw.getText().toString();
        String pw2=editPw2.getText().toString();

        YunDBHelper dbHelper =new YunDBHelper(YunRegisterActivity.this);
        String tempEmail = "temp";
        aa:
        if(allText.contains(" ")){
            if(email.contains(" ")){
                Toast.makeText(YunRegisterActivity.this, "이메일에 공백이 들어갔습니다", Toast.LENGTH_SHORT).show();
                break aa;
            }
            if(pw.contains(" ")){
                Toast.makeText(YunRegisterActivity.this, "첫번째 비밀번호에 공백이 들어갔습니다", Toast.LENGTH_SHORT).show();
                break aa;
            }
            if(pw2.contains(" ")){
                Toast.makeText(YunRegisterActivity.this, "두번째 비밀번호에 공백이 들어갔습니다", Toast.LENGTH_SHORT).show();
                break aa;
            }

        }else{
            SQLiteDatabase sqLiteDatabaseRead = dbHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabaseRead.rawQuery("SELECT emil FROM register1 WHERE emil='" + email + "'", null);

            while (cursor.moveToNext()) {
                tempEmail = cursor.getString(0);
            }
            if(tempEmail.equals(email)) {
                Toast.makeText(YunRegisterActivity.this, "중복된 이메일입니다", Toast.LENGTH_SHORT).show();
                break aa;
            }
            if(!pw.equals(pw2)){
                Toast.makeText(YunRegisterActivity.this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
                break aa;
            }
            if(email.equals("")){
                Toast.makeText(YunRegisterActivity.this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show();
                break aa;
            }
            if(pw.equals("")){
                Toast.makeText(YunRegisterActivity.this, "첫번째 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                break aa;
            }
            if(pw2.equals("")){
                Toast.makeText(YunRegisterActivity.this, "두번째 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                break aa;
            }
            sqLiteDatabaseRead.close();

            SQLiteDatabase sqLiteDatabaseWrite = dbHelper.getWritableDatabase();
            String query = "INSERT INTO register1 (emil,pw) VALUES('"+email+"','"+pw+"')";
            sqLiteDatabaseWrite.execSQL(query);
            sqLiteDatabaseWrite.close();

            Intent intent = new Intent(YunRegisterActivity.this,YunLoginActivity.class);
            YunRegisterActivity.this.startActivity(intent);
            YunRegisterActivity.this.finish();
        }
    }
}
