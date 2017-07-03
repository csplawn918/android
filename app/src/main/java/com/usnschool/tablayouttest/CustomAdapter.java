package com.usnschool.tablayouttest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by it on 2017-03-15.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<com.usnschool.tablayouttest.Member> arr;
    private LayoutInflater inflater;
    private Intent intent;

    public CustomAdapter(Context context, int layout, ArrayList<com.usnschool.tablayouttest.Member> arr) {
        this.context = context;
        this.layout = layout;
        this.arr = arr;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {return arr.size();}
    @Override
    public Object getItem(int i) {return arr.get(i).getName();}
    @Override
    public long getItemId(int i) {return i;}
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            view = inflater.inflate(layout,viewGroup,false);
        }
        final int pos = i;

        ImageView imgView = (ImageView)view.findViewById(R.id.imgView);
        imgView.setImageResource(arr.get(i).getIcon());
        TextView txtName = (TextView)view.findViewById(R.id.txtName);
        txtName.setText(arr.get(i).getName());
        Button btn = (Button)view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getItem(pos).toString()=="다현") {
                    intent = new Intent(context, MemberActivity1.class);
                    try {
                        context.startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(context,"실행불가", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

                /*
                if(getItem(pos).toString()=="모모") {
                    intent = new Intent(context, MemberActivity2.class);
                    try {
                        context.startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(context,"실행불가", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

                if(getItem(pos).toString()=="사나"){
                    intent = new Intent(context, MemberActivity3.class);
                    try {
                        context.startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(context,"실행불가", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

                if(getItem(pos).toString()=="채영"){
//                    intent = new Intent(context, MemberActivity3.class);
                    try {
//                        context.startActivity(intent);
                        Toast.makeText(context,"미구현", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(context,"실행불가", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

                if(getItem(pos).toString()=="지효"){
//                    intent = new Intent(context, MemberActivity3.class);
                    try {
//                        context.startActivity(intent);
                        Toast.makeText(context,"미구현", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(context,"실행불가", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

                if(getItem(pos).toString()=="정연"){
//                    intent = new Intent(context, MemberActivity3.class);
                    try {
//                        context.startActivity(intent);
                        Toast.makeText(context,"미구현", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(context,"실행불가", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

                if(getItem(pos).toString()=="미나"){
//                    intent = new Intent(context, MemberActivity3.class);
                    try {
//                        context.startActivity(intent);
                        Toast.makeText(context,"미구현", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(context,"실행불가", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

                if(getItem(pos).toString()=="나연"){
//                    intent = new Intent(context, MemberActivity3.class);
                    try {
//                        context.startActivity(intent);
                        Toast.makeText(context,"미구현", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(context,"실행불가", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

                if(getItem(pos).toString()=="쯔위"){
//                    intent = new Intent(context, MemberActivity3.class);
                    try {
//                        context.startActivity(intent);
                        Toast.makeText(context,"미구현", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(context,"실행불가", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
                */
            }
        });

        return view;
    }
}
