package com.example.vedioapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vedioapp.R;
import com.example.vedioapp.utils.FileUtil;

import java.util.Map;

/**
 * 用户登录
 */
public class MyLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText loginName;
    private EditText loginPassword;
    private CheckBox cbAutoLogin;
    private Button loginBtn;
    private TextView register;
    private TextView loginByQQ;
    private TextView loginByWeixin;
    private ImageView loginBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_login_act);

        //初始化控件
        loginName = findViewById(R.id.login_name);
        loginPassword = findViewById(R.id.login_pass);
        cbAutoLogin = findViewById(R.id.cb_auto_login);
        loginBtn = findViewById(R.id.login_btn);
        loginBack = findViewById(R.id.login_back);
        findViewById(R.id.login_register).setOnClickListener(this);
        findViewById(R.id.login_by_qq).setOnClickListener(this);
        findViewById(R.id.login_by_weixin).setOnClickListener(this);

        Map<String,String> data = FileUtil.getAccount(this);
        if (data.size()>0){
            loginName.setText((String)data.get("123"));
            loginPassword.setText((String)data.get("123"));
        }
        //设置登录按钮 监听事件
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLogin();
            }
        });


        //回退按钮
        loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyLoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击 登录按钮
            case R.id.login_btn:
                handleLogin();
                break;
            //点击 注册按钮
            case R.id.login_register:
                //从当前登录页面 跳转到注册页面
                startActivity(new Intent(this, MyRegisterActivity.class));
                break;
            //点击 QQ登录按钮
            case R.id.login_by_qq:
                break;
            //点击 微信登录按钮
            case R.id.login_by_weixin:
                break;
        }

    }
    //点击 登录按钮
    private void handleLogin() {
        //获取用户名 密码的值
        String name = loginName.getText().toString();
        String password = loginPassword.getText().toString();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)){
            Toast.makeText(this,"用户名或密码为空",Toast.LENGTH_LONG).show();
            return;
        }
        //比较用户名和密码是否正确，给出提示
        if ("123".equals(name) && "123".equals(password)){
            Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
            //从当前登录页面 实现跳转
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);

            //自动登录被勾选
            if (cbAutoLogin.isChecked()){
                boolean isSuccess = FileUtil.saveAccount(this,name,password);
                if (isSuccess){
                    Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this,"保存失败",Toast.LENGTH_LONG).show();
                }
            }else {
                FileUtil.clear(this);
                loginName.setText("");
                loginPassword.setText("");
            }
        }else {
            Toast.makeText(this,"用户名或密码不正确",Toast.LENGTH_LONG).show();
        }
    }
}