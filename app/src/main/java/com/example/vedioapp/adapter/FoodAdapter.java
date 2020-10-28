package com.example.vedioapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vedioapp.R;
import com.example.vedioapp.entity.Food;

import java.util.List;

/**
 * 美食 适配器 (在搜索布局使用)
 */
public class FoodAdapter extends BaseAdapter {
    private Context context;
    List<Food> foodList;

    public FoodAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    //决定布局中ListView展示的行数
    @Override
    public int getCount() {
        return foodList.size();
    }

    //返回指定位置对应的数据
    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    //返回指定位置的id
    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //声明ViewHolder
        ViewHolder holder = null;
        //判断是否有复用的view，如果没有就创建
        if (view == null){
            //将布局转换为view对象的方法
            view = View.inflate(context, R.layout.glass_food_item,null);
            holder = new ViewHolder();
            holder.iv = view.findViewById(R.id.iv_info);
            holder.tv_desc = view.findViewById(R.id.tv_desc);
            holder.tv_info_title = view.findViewById(R.id.tv_info_title);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //加载控件中的显示内容
        Food food = foodList.get(i); //获取集合中指定位置的数据
        holder.iv.setImageResource(food.getPicId());
        holder.tv_desc.setText("用户评价："+food.getDesc());
        holder.tv_info_title.setText(food.getFoodName());
        return view;
    }
    public class ViewHolder{
        ImageView iv;
        TextView tv_desc,tv_info_title;
    }
}
