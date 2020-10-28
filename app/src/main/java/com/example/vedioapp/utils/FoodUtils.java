package com.example.vedioapp.utils;

import com.example.vedioapp.R;
import com.example.vedioapp.entity.Food;

import java.util.ArrayList;
import java.util.List;


public class FoodUtils {
    public static final String[] food = { "蛋糕", "面包", "牛肉", "猪肉", "包子", "饺子","米线",
            "粥","麻辣烫","黄焖鸡","粉丝汤","锅贴","馄饨","小笼包","面条", };

    public static final int[] resId = {
            R.mipmap.food1,R.mipmap.food2,R.mipmap.food21,R.mipmap.food22,R.mipmap.food23,
            R.mipmap.food3,R.mipmap.food31,R.mipmap.food32,R.mipmap.food33,R.mipmap.food53,
            R.mipmap.food41,R.mipmap.food42,R.mipmap.food43,R.mipmap.food51,R.mipmap.food52
    };
    public static final String[] foodjianjie={
            "这里是蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕蛋糕的评论",
            "这里是面包面包面包面包面包面包面包的评论",
            "这里是牛肉牛肉牛肉牛肉牛肉牛肉牛肉牛肉牛肉的评论",
            "这里是猪肉猪肉猪肉猪肉的评论",
            "这里是包子包子包子包子包子包子包子的评论",
            "这里是饺子饺子饺子饺子饺子饺子饺子饺子的评论",
            "这里是米线米线米线米线米线的评论",
            "这里是粥粥粥粥粥粥粥粥粥的评论",
            "99999999","10100101010",
            "111111111111111",
            "121212121",
            "1313131313",
            "14141414",
            "15151515"};

    public static List<Food> getAllFoodList(){
        List<Food> list = new ArrayList<>();
        for (int i = 0; i < food.length; i++) {
            Food foodBean = new Food(resId[i],food[i],foodjianjie[i]);
            //将数据添加到集合中
            list.add(foodBean);
        }
        return list;
    }
}
