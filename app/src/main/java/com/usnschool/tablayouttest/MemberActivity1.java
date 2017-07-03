package com.usnschool.tablayouttest;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MemberActivity1 extends AppCompatActivity {

    private ImageView imageView
                        ,imageView2
                        ,imageView3
                        ,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView4 = (ImageView)findViewById(R.id.imageView4);

        imageView.setAdjustViewBounds(true);
//        imageView.setMaxWidth(1635);
//        imageView.setMaxHeight(1635);

        imageView2.setAdjustViewBounds(true);
//        imageView2.setMaxWidth(1635);
//        imageView2.setMaxHeight(1635);

        imageView3.setAdjustViewBounds(true);
//        imageView3.setMaxWidth(400);
//        imageView3.setMaxHeight(400);


        imageView4.setAdjustViewBounds(true);
//        imageView4.setMaxWidth(400);
//        imageView4.setMaxHeight(400);

        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dahyun444));
        imageView2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dahyun5));
        imageView3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dahyun11));
        imageView4.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dahyun33));
    }
}
