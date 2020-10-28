package com.example.vedioapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.vedioapp.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    //获取图片资源
    int[] imgRes = new int[]{
        R.drawable.guide1,
        R.drawable.guide2,
        R.drawable.guide3
    };
    private List<View> mViewList = new ArrayList<>();
    private ViewPager mVpGuide;
    private Button mBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        //控件初始化
        mVpGuide = findViewById(R.id.viewPager);
        mBtnStart = findViewById(R.id.btn_start);
        mVpGuide.setAdapter(new MyPagerAdapter());

        mVpGuide.setOnPageChangeListener(new MyListener());

        //点击按钮 跳转到主界面
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i=0;i<imgRes.length;i++) {
            View inflate = getLayoutInflater().inflate(R.layout.guide_item, null);
            ImageView ivGuide = inflate.findViewById(R.id.iv_guide);
            ivGuide.setBackgroundResource(imgRes[i]);
            mViewList.add(inflate);
        }
    }
    //定义ViewPager的适配器 （引导界面）
    class MyPagerAdapter extends PagerAdapter{

        @Override
        public Object instantiateItem(ViewGroup container,int position){
            View view = mViewList.get(position);
            container.addView(view);
            return view;
        }

        //计算需要多少item显示
        @Override
        public int getCount() {
            return imgRes.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container,int position,Object object){
           container.removeView(mViewList.get(position));
        }
    }

    class  MyListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        //ViewPager滚动到第几张
        @Override
        public void onPageSelected(int position) {
            // 假如ViewPager滚动到最后一张，就会显示按钮
            if (position == imgRes.length-1){
                mBtnStart.setVisibility(View.VISIBLE);
                //设置动画
                Animation animation = AnimationUtils.loadAnimation(GuideActivity.this, R.anim.anim_guide_btn_start);
                mBtnStart.startAnimation(animation);
            }else {
                mBtnStart.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}