package com.example.tbadi.murphy;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.tbadi.murphy.Helper.mediaPlayer;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        playPartI();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    private void playPartI() {
        mediaPlayer = MediaPlayer.create(this, R.raw.discours1_1);
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
        }
    }
}
