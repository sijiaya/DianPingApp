package com.example.vedioapp.utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class ShareUtils {
    private static final String FILE_NAME = "dianping";
    private static final String MODE_NAME="welcome";

    //获取Boolean类的值
    public static boolean getWelcomeBoolean(Context context){
        return context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)
                .getBoolean(MODE_NAME,false);
    }
    //写入Boolean类的值
    public static void putWelcomeBoolean(Context context,boolean isFirst){
        Editor editor = context.getSharedPreferences(FILE_NAME, Context.MODE_APPEND).edit();
        editor.putBoolean(MODE_NAME,isFirst);
        editor.commit();
    }

    //写入一个String类型的值
    public static void putCityName(Context context,String cityName){
        Editor editor = context.getSharedPreferences(FILE_NAME, Context.MODE_APPEND).edit();
        editor.putString("cityName",cityName);
        editor.commit();
    }
    //获取String类型的值
    public static String getCityName(Context context){
        return context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).getString("cityName","选择城市");
    }
}
