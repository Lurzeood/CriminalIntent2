package com.example.lurzeood.criminalintent2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by Lurzeood on 2017/5/10 0010.
 */

public class PictureUtils {

    public static Bitmap getScaledBitmap(String path,int destWidth, int destHeight){

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path,options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        int InSampleSize = 1;
        if (srcHeight>destHeight || srcWidth > destWidth){
            if (srcWidth > srcHeight){
                InSampleSize = Math.round(srcHeight/destHeight);
            }else {
                InSampleSize = Math.round(srcWidth/destWidth);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = InSampleSize;

        return BitmapFactory.decodeFile(path,options);
    }

    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path,size.x,size.y);
    }

}
