package com.example.beat;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    SoundPool soundPool ;
    MediaPlayer mediaPlayer,mediaPlayer2 ;
    Random random = new Random() ;
    View v ;
    int explode = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        v = new View(this) ;
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        v.setOnTouchListener(this);
        setContentView(v);
        mediaPlayer = MediaPlayer.create(this,R.raw.migente) ;
        mediaPlayer.start();
        mediaPlayer2 = MediaPlayer.create(this,R.raw.soundtrack) ;
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0) ;
        explode = soundPool.load(this,R.raw.explosion,1) ;

        v.setBackgroundColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
    }

    @Override
    public void onClick(View view) {
    if(explode!=0)
    {
        soundPool.play(explode,1,1,0,1,1) ;
    }
    }

    @Override
    public boolean onLongClick(View view) {
        mediaPlayer.stop();
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mediaPlayer2.start();
        v.setBackgroundColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        return true;
    }
}
