package com.example.vedioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.vedioapp.fragment.ExerciseFragment;
import com.example.vedioapp.fragment.homeFragment;
import com.example.vedioapp.fragment.myFragment;
import com.example.vedioapp.fragment.searchFragment;
import com.example.vedioapp.fragment.tuanFragment;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup group;
    private RadioButton main_home;
    //管理fragment的类
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = findViewById(R.id.main_bottom_tabs);
        main_home = findViewById(R.id.main_home);
        //初始化FragmentManager
        fragmentManager = getSupportFragmentManager();
        //设置默认选中页面
        main_home.setChecked(true);
        //对RadioGroup中的四个控件按钮都实现监听
        group.setOnCheckedChangeListener(this);

        //切换不同的页面fragment
        changeFragment(new homeFragment(),false);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId){
            //首页
            case R.id.main_home:
                changeFragment(new homeFragment(),true);
                break;
            //我的
            case R.id.main_my:
                changeFragment(new myFragment(),true);
                break;
            //发现
            case R.id.main_search:
                changeFragment(new searchFragment(),true);
                break;
            //团购
            case R.id.main_tuan:
                changeFragment(new tuanFragment(),true);
                break;

            default:
                break;
        }
    }
    //切换不同的页面fragment
    public void changeFragment(Fragment fragment,boolean isInit){
        //开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content,fragment);
        if (!isInit){
            transaction.addToBackStack(null);
        }
        transaction.commit();

    }

}