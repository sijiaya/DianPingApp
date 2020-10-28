package com.example.vedioapp.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vedioapp.R;
import com.example.vedioapp.adapter.FoodAdapter;
import com.example.vedioapp.entity.Food;
import com.example.vedioapp.utils.FoodUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 搜索
 */

public class GlassActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivBack;
    private EditText etGlass;
    private ListView lvGlass;
    //搜索文本
    private TextView tvSearchText,tvSearchCancel;


    private List<Food> foods;
    private List<Food> allFoodList;
    private FoodAdapter foodAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass);
        //查找控件
        initView();
        foods = new ArrayList<>();
        allFoodList = FoodUtils.getAllFoodList();
        foods.addAll(allFoodList);

        //点击返回图标 跳转到 团购页面
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GlassActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //创建适配器
        foodAdapter = new FoodAdapter(this,foods);
        //设置适配器
        lvGlass.setAdapter(foodAdapter);

        //设置单向点击监听
        setListener();
    }

    private void setListener() {
        lvGlass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Food food = foods.get(position);
                Intent intent = new Intent(GlassActivity.this,FoodDescActivity.class);
                intent.putExtra("food",food);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        ivBack = findViewById(R.id.iv_back);
        etGlass = findViewById(R.id.et_glass);
        tvSearchText = findViewById(R.id.tv_search_text);
        tvSearchCancel = findViewById(R.id.tv_search_cancel);

        lvGlass = findViewById(R.id.lv_glass);

        //添加 搜索、取消 文本的点击监听事件
        tvSearchText.setOnClickListener(this);
        tvSearchCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击搜索
            case R.id.tv_search_text:
                //获取 搜索款中 输入的内容
                String msg = etGlass.getText().toString().trim();
                if(TextUtils.isEmpty(msg)){
                Toast.makeText(this,"输入内容不能为空!!!",Toast.LENGTH_SHORT).show();
                return;
            }
            //判断美食列表中是否包含输入内容
            // 显示搜索中 存在内容的集合
            List<Food> existList = new ArrayList<>();
                for (int i=0;i<allFoodList.size();i++){
                    //得到 搜索到的美食名称
                    String name = allFoodList.get(i).getFoodName();
                    //如果搜索的内容中包含美食名字的信息，就放入existList集合中
                    if (name.contains(msg)){
                        existList.add(allFoodList.get(i));
                    }
                }
                //获取新的集合后，清空原来的数据源
                foods.clear();
                //添加新的数据源
                foods.addAll(existList);
                //提示适配器更新
                foodAdapter.notifyDataSetChanged();
                break;
            //点击取消/刷新
            case R.id.tv_search_cancel:
                foods.clear();
                foods.addAll(allFoodList);
                foodAdapter.notifyDataSetChanged();
                break;
        }
    }
}