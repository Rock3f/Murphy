package com.example.tbadi.murphy;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        playPartI();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    private void playPartI() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.partone);
        mediaPlayer.start();
    }
}
