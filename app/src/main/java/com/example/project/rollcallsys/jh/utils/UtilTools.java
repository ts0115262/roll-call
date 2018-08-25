package com.example.project.smartbutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * 项目名：    SmartButler
 * 包名：     com.example.project.smartbutler.utils
 * 文件名：    UtilTools
 * 创建者： Jiang Hao
 * 创建时间：   2018-08-19  21:42
 * 描述： 工具统一类
 */
public class UtilTools {
    public static void setFont(Context mContent, TextView textView){
        Typeface fontType =Typeface.createFromAsset(mContent.getAssets(),"fonts/FONT.TTF");
        textView.setTypeface(fontType);
    }
}