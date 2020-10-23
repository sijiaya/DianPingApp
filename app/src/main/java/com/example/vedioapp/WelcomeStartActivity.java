package com.example.vedioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

// 延时跳转
public class WelcomeStartActivity extends AppCompatActivity {
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_start);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getPreferences(MODE_PRIVATE);
                boolean isFirst = sp.getBoolean("isFirst", true);
                Intent intent = new Intent();

                if (isFirst){
                    sp.edit().putBoolean("isFirst",false).commit();
                    //判断用户是否是第一次登录,进入引导界面
                    intent.setClass(WelcomeStartActivity.this,GuideActivity.class);
                    startActivity(intent);
                }else {
                    //不是第一次登录，进入主界面
                    intent.setClass(WelcomeStartActivity.this,MainActivity.class);
                }
                startActivity(intent);
//                //设置界面之间的切换动画
//                overridePendingTransition();
                finish();
            }
        },3000);
    }
}