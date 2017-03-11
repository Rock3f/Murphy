package com.example.tbadi.murphy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int param [] = { 1,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        playIntro();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void playIntro(){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.partone); // remplacer par les crédits et nouvelle partie
        mediaPlayer.start();
    }

    public void OnClickButton(View view) {
        Intent i = new Intent(this, Intro.class);
        startActivity(i);
    }
}
