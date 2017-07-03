package com.usnschool.tablayouttest;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

/**
 * Created by it on 2017-03-17.
 */

public class Fragment2 extends Fragment{

    private SeekBar seekBar;
    private Button button1;
    static MediaPlayer music;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater
            , ViewGroup container
            , Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);

        button1 = (Button)view.findViewById(R.id.button1);
        seekBar = (SeekBar)view.findViewById(R.id.seekBar);

        music = MediaPlayer.create(getContext(),R.raw.knock);
        music.setLooping(false);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(music.isPlaying()) {
                    music.stop();
                    try {
                        music.prepare();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    music.seekTo(0);
                    button1.setText("START");
                    seekBar.setProgress(0);
                }else{
                    music.start();
                    button1.setText("STOP");
                    Thread thread = new Thread(new tesr());
                    thread.start();
                }
            }
        });

        seekBar.setMax(music.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromMusic) {
                if(fromMusic){
                    music.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }



    class tesr implements Runnable{
        @Override
        public void run() {
            while (music.isPlaying()){
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                seekBar.setProgress(music.getCurrentPosition()/*현재음악 재생위치*/);
            }
        }
    }
}
