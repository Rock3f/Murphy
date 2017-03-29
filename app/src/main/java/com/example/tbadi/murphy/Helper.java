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

                if( i == 0)
                {
                    int j = param.length - 1;
                    param[j] = 1;
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

                if((i + 1 ) == param.length)
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

    public static int GetIndexFromArrayInt(int param [], int value)
    {
        int index = 0;
        for(int i = 0; i < param.length; i++)
        {
            if(param[i] == value)
            {
                index = i;
                break;
            }
        }
        return index;
    }
}
