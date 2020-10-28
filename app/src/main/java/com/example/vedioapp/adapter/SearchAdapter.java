package com.example.vedioapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vedioapp.R;
import com.example.vedioapp.entity.Food;

import java.util.List;

/**
 * 发现/美食 适配器
 */
public class SearchAdapter extends BaseAdapter {
    private Context context;
    private List<Food> foodList;

    public SearchAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //声明ViewHolder
        ViewHolder holder = null;
        if (view == null){ //判断是否有复用的view，如果没有就创建
            view = View.inflate(context,R.layout.search_food_item,null);
            holder = new ViewHolder();
            holder.iv = view.findViewById(R.id.iv_item_grid);
            holder.tv = view.findViewById(R.id.tv_item_grid);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //获取指定位置的数据
        Food food = foodList.get(i);
        holder.iv.setImageResource(food.getPicId());
        holder.tv.setText(food.getFoodName());
        return view;
    }
    public class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
