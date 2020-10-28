package com.example.vedioapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.vedioapp.R;
import com.example.vedioapp.entity.HomeIconInfo;
import java.util.List;

/**
 * 所有分类 适配器
 */
public class AllCategoryAdapter extends BaseAdapter {
    private Context context;
    private List<HomeIconInfo> iconInfoList;

    public AllCategoryAdapter(Context context, List<HomeIconInfo> iconInfoList) {
        this.context = context;
        this.iconInfoList = iconInfoList;
    }

    @Override
    public int getCount() {
        return iconInfoList.size();
    }

    @Override
    public Object getItem(int i) {
        return iconInfoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder holder = null;
        if (view == null){
            view = View.inflate(context, R.layout.home_index_nav_all_item,null);
            holder = new MyHolder();
            holder.textView = view.findViewById(R.id.home_nav_all_item_desc);
            holder.imageView = view.findViewById(R.id.home_nav_all_item_image);
            view.setTag(holder);
        }else {
            holder = (MyHolder) view.getTag();
        }
        HomeIconInfo homeIconInfo = iconInfoList.get(i);
        holder.textView.setText(homeIconInfo.getIconName());
        holder.imageView.setBackgroundResource(homeIconInfo.getIconId());
        return view;
    }

    public class MyHolder{
        TextView textView;
        ImageView imageView;
    }
}
