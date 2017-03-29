package com.example.tbadi.murphy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import static com.example.tbadi.murphy.Helper.SetValueToParamArrayFromSlideLeft;
import static com.example.tbadi.murphy.Helper.SetValueToParamArrayFromSlideRight;
import static com.example.tbadi.murphy.Helper.mediaPlayer;
import static com.example.tbadi.murphy.Helper.mediaPlayerLoop;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

<<<<<<< HEAD
    private int param [] = { 1, 0, 0 };
=======
    private int param [] = { 1,0,0,0};
>>>>>>> origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        playMainMenuSong();

        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayerLoop.stop();
        }
    }

    private void playMainMenuSong(){
        mediaPlayerLoop = MediaPlayer.create(this, R.raw.mainmenusound);
        mediaPlayerLoop.setLooping(true);
        mediaPlayerLoop.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        if(mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                return true;
            }
        }

        //Velocity > 0 = slide vers la droite
        if(velocityX > 0)
        {
            param = SetValueToParamArrayFromSlideRight(param);
        }
        else
        {
            param = SetValueToParamArrayFromSlideLeft(param);
        }
        return true;
    }



    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + e1.toString()+e2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }
}
