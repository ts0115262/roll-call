package com.example.project.smartbutler.utils;

import android.util.Log;

public class L {

    //开关
    public static final boolean DEBUG = true;
    //TAG
    public static final String TAG = "SmartButler";

    //四个等级 DIWE

    public static void d(String text, String activity) {
        if (DEBUG) Log.d(TAG, activity + ":" + text);
    }

    public static void i(String text, String activity) {
        if (DEBUG) Log.i(TAG, activity + ":" + text);
    }

    public static void w(String text, String activity) {
        if (DEBUG) Log.w(TAG, activity + ":" + text);
    }

    public static void e(String text, String activity) {
        if (DEBUG) Log.e(TAG, activity + ":" + text);
    }

}
