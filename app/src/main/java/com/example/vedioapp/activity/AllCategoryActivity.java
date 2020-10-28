package com.example.vedioapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.vedioapp.R;
import com.example.vedioapp.adapter.AllCategoryAdapter;
import com.example.vedioapp.entity.HomeIconInfo;

import java.util.ArrayList;
import java.util.List;

public class AllCategoryActivity extends AppCompatActivity {
    public static String[] allCategory={"美团外卖","KTV","密室","酒吧","洗浴","宠物","生活服务","周边游","火车票",
            "机票","美团打车","健身","家庭保洁"};
    public static int[] allCategoryImages={R.drawable.icon_out,R.drawable.icon_ktv,R.drawable.icon_key,
            R.drawable.icon_bar,R.drawable.icon_wash,R.drawable.icon_pet,R.drawable.icon_life,R.drawable.icon_tour,R.drawable.icon_train,
            R.drawable.icon_plane,R.drawable.icon_car,R.drawable.icon_fitness,R.drawable.icon_clean
    };
    private ImageView ivAllBack;
    private List<HomeIconInfo> iconInfoList;
    private AllCategoryAdapter myAdapter;
    private ListView lvAllCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcategory);
        //初始化view
        initView();
        ivAllBack = findViewById(R.id.home_nav_all_back);
        //点击返回图标 跳转到 主页面
        ivAllBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllCategoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        iconInfoList = new ArrayList<>();
        for (int i=0;i<allCategory.length;i++){
            iconInfoList.add(new HomeIconInfo(allCategory[i],allCategoryImages[i]));
        }
        //初始化listView
        lvAllCategory = findViewById(R.id.home_nav_all_category);
        myAdapter = new AllCategoryAdapter(AllCategoryActivity.this,iconInfoList);
        lvAllCategory.setAdapter(myAdapter);
    }
    //点击back图标 返回上一级页面
    public void onClick(View view){
        switch (view.getId()){
            case R.id.home_nav_all_back:
                finish();
                break;
            default:
                break;
        }
    }
}