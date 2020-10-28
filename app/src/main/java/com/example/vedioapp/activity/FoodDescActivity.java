package com.example.vedioapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vedioapp.R;
import com.example.vedioapp.entity.Food;

public class FoodDescActivity extends AppCompatActivity {
    private TextView tvTitle1,tvTitle2,tvDesc;
    private ImageView  ivBack,ivBigPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_desc);
        initView();
        //接收上一级页面的数据
        Intent intent = getIntent();
        Food food = (Food) intent.getSerializableExtra("food");
        //设置显示控件
        tvTitle1.setText(food.getFoodName());
        tvTitle2.setText(food.getFoodName());
        tvDesc.setText(food.getDesc());
        ivBigPic.setImageResource(food.getPicId());
    }

    private void initView() {
        tvTitle1 = findViewById(R.id.tv_fooddesc_title1);
        tvTitle2 = findViewById(R.id.tv_fooddesc_title2);
        tvDesc = findViewById(R.id.tv_fooddesc_desc);
        ivBack = findViewById(R.id.iv_fooddesc_back);
        ivBigPic = findViewById(R.id.iv_fooddesc_bigpic);

        //点击返回
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //销毁当前activity
                finish();
            }
        });


    }
}