package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
Thread timer;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.giffy);
        Glide.with(this).load(R.drawable.splash).into(imageView);
        mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.backgroundmusic);
        mediaPlayer.start();




        timer=new Thread()
        {
            public void run()
            {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mediaPlayer.stop();
                    Intent intent_my = new Intent(getApplicationContext(),Welcome.class);
                    startActivity(intent_my);
                }
            }

        };
    timer.start();
    }
}