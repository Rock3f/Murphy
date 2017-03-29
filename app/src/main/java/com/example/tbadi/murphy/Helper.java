package com.example.tbadi.murphy;

import android.media.MediaPlayer;

/**
 * Created by tbadi on 19/03/2017.
 */

public class Helper {

    public static MediaPlayer mediaPlayer;
    public static  MediaPlayer mediaPlayerLoop;

    public static int[] SetValueToParamArrayFromSlideLeft(int param [])
    {
        for(int i = 0 ;  i < param.length; i++)
        {
            if(param[i] == 1)
            {
                param[i] = 0;

                if(param[(i-1)] < 0)
                {
                    param[0] = 1;
                }
                else
                {
                    param[(i-1)] = 1;
                }
                break;
            }
        }
        return  param;
    }

    public static int[] SetValueToParamArrayFromSlideRight(int param [])
    {
        for(int i = 0 ;  i < param.length; i++)
        {
            if(param[i] == 1)
            {
                param[i] = 0;

                if(param[(i+1)] > param.length)
                {
                    param[0] = 1;
                }
                else
                {
                    param[(i+1)] = 1;
                }
                break;
            }
        }
        return param;
    }
}
