package com.example.project.smartbutler.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtils {

    private static String NAME = "config";

    public static void putString(Context mContent, String key, String value) {
        SharedPreferences sp = mContent.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }

    public static String getString(Context mContent, String key, String defValue) {
        SharedPreferences sp = mContent.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void putInt(Context mContent, String key, int value) {
        SharedPreferences sp = mContent.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).apply();
    }

    public static int getInt(Context mContent, String key, int defValue) {
        SharedPreferences sp = mContent.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static void putBoolean(Context mContent, String key, boolean value) {
        SharedPreferences sp = mContent.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(Context mContent, String key, boolean defValue) {
        SharedPreferences sp = mContent.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }


    //删除 单个
    public static void deleteShare(Context mContent, String key) {
        SharedPreferences sp = mContent.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }

    //删除全部
    public static void deleteAll(Context mContent) {
        SharedPreferences sp = mContent.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }
}
