package com.example.tbadi.murphy;

import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import static com.example.tbadi.murphy.Helper.GetIndexFromArrayInt;
import static com.example.tbadi.murphy.Helper.SetValueToParamArrayFromSlideLeft;
import static com.example.tbadi.murphy.Helper.SetValueToParamArrayFromSlideRight;
import static com.example.tbadi.murphy.Helper.mediaPlayer;

public class Intro extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {


    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    private int paramfirststep [] = { 1,0,0,0};
    private int paramsecondstep [] = { 1,0 };
    private boolean firsttstep = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);
        playPartI();
    }

    private void playPartI() {
        mediaPlayer = MediaPlayer.create(this, R.raw.partone);
        mediaPlayer.start();

        while(mediaPlayer.isPlaying())
        {
            //
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.menuexplication);
        mediaPlayer.start();

        while(mediaPlayer.isPlaying())
        {
            //
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.rep1);
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
        if(firsttstep) {
            if (velocityX > 0) {
                paramfirststep = SetValueToParamArrayFromSlideRight(paramfirststep);
            } else {
                paramfirststep = SetValueToParamArrayFromSlideLeft(paramfirststep);
            }

            PlaySoundMenuFirstStep();
        }
        else {
            if (velocityX > 0) {
                paramsecondstep = SetValueToParamArrayFromSlideRight(paramsecondstep);
            } else {
                paramsecondstep = SetValueToParamArrayFromSlideLeft(paramsecondstep);
            }

            PlaySoundMenuSecondStep();
        }

        return true;
    }

    private void PlaySoundMenuFirstStep()
    {
        switch(GetIndexFromArrayInt(paramfirststep, 1))
        {
            case 0:
                mediaPlayer = MediaPlayer.create(this, R.raw.rep1);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.rep2);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.rep3);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.rep4);
                mediaPlayer.start();
                break;
            default:
                //Do Nothing
                break;
        }
    }

    private void PlaySoundMenuSecondStep()
    {
        switch(GetIndexFromArrayInt(paramfirststep, 1))
        {
            case 0:
                if(GetIndexFromArrayInt(paramsecondstep, 1) == 0){
                    mediaPlayer = MediaPlayer.create(this, R.raw.rep1_1);
                }
                else
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.rep1_2);
                }
                mediaPlayer.start();
                break;
            case 1:
                if(GetIndexFromArrayInt(paramsecondstep, 1) == 0){
                    mediaPlayer = MediaPlayer.create(this, R.raw.rep2_1);
                }
                else
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.rep2_2);
                }
                mediaPlayer.start();
                break;
            case 2:
                if(GetIndexFromArrayInt(paramsecondstep, 1) == 0){
                    mediaPlayer = MediaPlayer.create(this, R.raw.rep3_1);
                }
                else
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.rep3_2);
                }
                mediaPlayer.start();
                break;
            case 3:
                if(GetIndexFromArrayInt(paramsecondstep, 1) == 0){
                    mediaPlayer = MediaPlayer.create(this, R.raw.rep4_1);
                }
                else
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.rep4_2);
                }
                mediaPlayer.start();
                break;
            default:
                //Do Nothing
                break;
        }
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

        if(firsttstep)
        {
            PlaySelectedSoundFirstStep();

            while(mediaPlayer.isPlaying())
            {
                //
            }

            mediaPlayer = MediaPlayer.create(this, R.raw.menuexplication);
            mediaPlayer.start();

            while(mediaPlayer.isPlaying())
            {
                //
            }

            PlaySoundMenuSecondStep();
            firsttstep = false;

        }
        else
        {
            PlaySelectedSoundSecondStep();

            while(mediaPlayer.isPlaying())
            {
                //
            }

            mediaPlayer = MediaPlayer.create(this, R.raw.crisepartoneend);
            mediaPlayer.start();

            while(mediaPlayer.isPlaying())
            {
                //
            }

            mediaPlayer = MediaPlayer.create(this, R.raw.byescreen);
            mediaPlayer.start();
        }
        return true;
    }

    private void PlaySelectedSoundFirstStep(){

        switch(GetIndexFromArrayInt(paramfirststep, 1))
        {
            case 0:
                mediaPlayer = MediaPlayer.create(this, R.raw.discours1);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.discours2);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.discours3);
                mediaPlayer.start();
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.discours4);
                mediaPlayer.start();
                break;
            default:
                //Do Nothing
                break;
        }

    }

    private void PlaySelectedSoundSecondStep()
    {
        switch(GetIndexFromArrayInt(paramfirststep, 1))
        {
            case 0:
                if(GetIndexFromArrayInt(paramsecondstep, 1) == 0){
                    mediaPlayer = MediaPlayer.create(this, R.raw.discours1_1);
                }
                else
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.discours1_2);
                }
                mediaPlayer.start();
                break;
            case 1:
                if(GetIndexFromArrayInt(paramsecondstep, 1) == 0){
                    mediaPlayer = MediaPlayer.create(this, R.raw.discours2_1);
                }
                else
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.discours2_2);
                }
                mediaPlayer.start();
                break;
            case 2:
                if(GetIndexFromArrayInt(paramsecondstep, 1) == 0){
                    mediaPlayer = MediaPlayer.create(this, R.raw.discours3_1);
                }
                else
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.discours3_2);
                }
                mediaPlayer.start();
                break;
            case 3:
                if(GetIndexFromArrayInt(paramsecondstep, 1) == 0){
                    mediaPlayer = MediaPlayer.create(this, R.raw.discours4_1);
                }
                else
                {
                    mediaPlayer = MediaPlayer.create(this, R.raw.discours4_2);
                }
                mediaPlayer.start();
                break;
            default:
                //Do Nothing
                break;
        }
    }

}
