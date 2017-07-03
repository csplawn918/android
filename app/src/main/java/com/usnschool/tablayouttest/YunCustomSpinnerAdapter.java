package com.usnschool.tablayouttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by it on 2017-03-08.
 */

public class YunCustomSpinnerAdapter extends ArrayAdapter{
    private Context context;
    private int rowResourceId;
    private ArrayList<YunCustomSpinnerData> arr;
    private LayoutInflater layoutInflater;

    public YunCustomSpinnerAdapter(Context context, int textViewResourceId, ArrayList<YunCustomSpinnerData> arr){
        super(context,textViewResourceId,arr);
        this.context=context;
        this.arr=arr;
        this.rowResourceId=textViewResourceId;
        this.layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View con=convertView;

        if(con==null){
            con = layoutInflater.inflate(rowResourceId,parent,false);
        }
        TextView menu =(TextView)con.findViewById(R.id.yun_custom_spinner_text);



        return con;
    }

    @Override
    public View getDropDownView(int position,View convertView,ViewGroup parent){
        View con= convertView;
        if(con==null){
            con=layoutInflater.inflate(rowResourceId,parent,false);
        }
        TextView menu =(TextView)con.findViewById(R.id.yun_custom_spinner_text);
        menu.setText(arr.get(position).getMenu().toString());
        return con;
    }



}
