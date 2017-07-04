package com.usnschool.tablayouttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by it on 2017-03-08.
 */

public class YunCustomAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<YunCustomData> arr;
    private LayoutInflater layoutInflater;

    public YunCustomAdapter(Context context, int layout, ArrayList<YunCustomData> arr){
        this.context=context;
        this.layout=layout;
        this.arr=arr;
        this.layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        int position = i;

        if(convertView==null){
            convertView = layoutInflater.inflate(layout,parent,false);
        }
        TextView txtViewIdx =(TextView)convertView.findViewById(R.id.yun_customData_TextViewIdx);
        TextView txtViewEmail =(TextView)convertView.findViewById(R.id.yun_customData_TextViewEmail);
        TextView txtViewPw =(TextView)convertView.findViewById(R.id.yun_customData_TextViewPw);

        Integer converter = arr.get(position).getIdx();
        txtViewIdx.setText(converter.toString());
        txtViewEmail.setText(arr.get(position).getEmail());
        txtViewPw.setText(arr.get(position).getPw());

        return convertView;
    }
}
