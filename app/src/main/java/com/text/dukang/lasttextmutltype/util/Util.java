package com.text.dukang.lasttextmutltype.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @Author : wdk
 * @Email :a15939582085@126.com
 * Created on : 2017/2/21 17:24
 * @Description :
 */

public class Util {
    /**
     * 得到屏幕的高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        if (null == context) {
            return 0;
        }
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getApplicationContext().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 得到屏幕的宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWeight(Context context) {
        if (null == context) {
            return 0;
        }
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getApplicationContext().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }
}
