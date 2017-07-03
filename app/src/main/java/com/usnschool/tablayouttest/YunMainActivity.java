package com.usnschool.tablayouttest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class YunMainActivity extends Fragment{
    private EditText inputWord;
    private Button enterButton;
    private TextView outputWord;
    private View view;
    private ScrollView scrollView;
    private BufferedReader brr;
    private Socket socket;
    private StringBuffer stringBuffer=new StringBuffer();
    private String tempString;
    private PrintWriter pw;
    private CustomThread customThread = new CustomThread();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.yun_main_activity,container,false);
        Fragment2.music.stop();

        inputWord=(EditText)view.findViewById(R.id.yun_main_EditTextInput);
        outputWord=(TextView)view.findViewById(R.id.yun_main_TextViewOutput);
        enterButton=(Button)view.findViewById(R.id.yun_main_ButtonInput);
        scrollView=(ScrollView)view.findViewById(R.id.yun_main_ScrollView);

        Thread thread = new Thread(customThread);
        thread.start();

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=inputWord.getText().toString();
                customThread.sendToServer(str);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            pw.close();
            brr.close();
            socket.close();
        }catch (Exception e){
            Log.e("tt0",e.getMessage());
        }
    }

    class CustomThread implements Runnable{

        @Override
        public void run() {

            try {
                socket = new Socket("211.179.124.254",7008);
                brr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                pw = new PrintWriter(socket.getOutputStream(),true);
                while(true){
                    String line=brr.readLine();
                    Message msg= Message.obtain();
                    msg.obj = line;
                    handler.sendMessage(msg);
                }
            } catch (IOException e) {
                Log.e("tt1",e.getMessage());
            }
        }
        public void sendToServer(String str){
            pw.println(str);
            inputWord.setText("");
        }

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg){
                try {
                    tempString = (String) msg.obj;
                    stringBuffer.append(tempString+"\n");
                    outputWord.setText(stringBuffer.toString());
                    scrollView.scrollTo(0, scrollView.getHeight());
                    view.invalidate();
                } catch (Exception e) {
                    Log.e("tt2", e.getMessage());
                }
            }
        };
    }



}
