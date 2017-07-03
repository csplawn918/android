package com.usnschool.tablayouttest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by it on 2017-03-17.
 */

public class Fragment1 extends Fragment {

    Button btnOne;
    private ArrayList<Member> arr;
    private CustomAdapter adapter;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater
                            , final ViewGroup container
                            , Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,container,false);
        if(Fragment2.music.isPlaying()) {
            Fragment2.music.stop();
        }

        arr = new ArrayList<Member>();
        Member member;
        member = new Member(R.drawable.dahyun,"다현");
        arr.add(member);
//        member = new Member(R.drawable.momo,"모모");
//        arr.add(member);
//        member = new Member(R.drawable.sana,"사나");
//        arr.add(member);
//        member = new Member(R.drawable.cheayoung,"채영");
//        arr.add(member);
//        member = new Member(R.drawable.jihyo,"지효");
//        arr.add(member);
//        member = new Member(R.drawable.jungyeon,"정연");
//        arr.add(member);
//        member = new Member(R.drawable.mina,"미나");
//        arr.add(member);
//        member = new Member(R.drawable.nayeon,"나연");
//        arr.add(member);
//        member = new Member(R.drawable.thuwe,"쯔위");
//        arr.add(member);

        adapter = new CustomAdapter(view.getContext(), R.layout.custom, arr);

        listView = (ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);


//        btnOne = (Button)view.findViewById(R.id.btnOne);
//        btnOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                btnOne.setText("test");
//
//            }
//        });
//        Toast.makeText(view.getContext(), "Test", Toast.LENGTH_SHORT).show();

        return view;
    }
}
