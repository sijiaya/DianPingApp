package com.example.vedioapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.vedioapp.R;

/**
 * 用户注册
 */
public class MyRegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button checkPassBtn;
    private ImageView backImage;
    private CountTimer countTimer;
    private void init(){
        checkPassBtn = findViewById(R.id.register_get_checkpass);
        backImage = findViewById(R.id.register_back);
        countTimer = new CountTimer(60000,1000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_register_act);

        init();
        //实现监听
        checkPassBtn.setOnClickListener(this);
        backImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击 获取验证码
            case R.id.register_get_checkpass:
                //开启倒计时
                countTimer.start();
                break;
            //点击 返回
            case R.id.register_back:
                finish();
                break;
            default:
                break;
        }
    }
    //每隔1分钟可点击一次验证码
    public class CountTimer extends CountDownTimer{

        /**
         *
         * @param millisInFuture 时间间隔多长的时间
         * @param countDownInterval 回调onTick方法，每隔多久执行一次
         */
        public CountTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        //间隔时间内执行的操作
        @Override
        public void onTick(long l) {
            //更新页面的组件
            checkPassBtn.setText(l/1000+"秒后发送");
            checkPassBtn.setBackgroundResource(R.drawable.btn_light_press);
            //在获取验证码时 设置按钮不可点击
            checkPassBtn.setClickable(false);
        }

        //间隔时间结束的时候调用
        @Override
        public void onFinish() {
            //更新页面的组件
            checkPassBtn.setText("获取验证码");
            checkPassBtn.setBackgroundResource(R.drawable.my_register_get_checkpass);
            //设置按钮可点击
            checkPassBtn.setClickable(true);
        }
    }
}