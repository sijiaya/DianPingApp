package com.example.vedioapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.vedioapp.R;
import com.example.vedioapp.entity.Shop;

import java.util.List;

/**
 * 店铺 适配器
 */
public class ShopAdapter extends BaseAdapter {
    private Context context;
    private List<Shop> shops;

    public ShopAdapter(Context context, List<Shop> shopList) {
        this.context = context;
        this.shops = shopList;
    }

    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public Object getItem(int i) {
        return shops.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //声明ViewHolder
        ViewHolder viewHolder = null;
        if (view == null){
            view = View.inflate(context,R.layout.tuan_shop_item,null);
            viewHolder = new ViewHolder();
            viewHolder.ivShopPic = view.findViewById(R.id.iv_shop_pic);
            viewHolder.tvShopName = view.findViewById(R.id.tv_shop_name);
            viewHolder.tvGrade = view.findViewById(R.id.tv_grade);
            viewHolder.tvPricePerson = view.findViewById(R.id.tv_price_person);
            viewHolder.tvPosition = view.findViewById(R.id.tv_position);
            viewHolder.tvDiscount = view.findViewById(R.id.tv_discount);
            viewHolder.tvDistance = view.findViewById(R.id.tv_distance);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Shop shop = shops.get(i);
        viewHolder.ivShopPic.setImageResource(shop.getShopPicId());
        viewHolder.tvShopName.setText(shop.getShopName());
        viewHolder.tvGrade.setText(shop.getGrade());
        viewHolder.tvPricePerson.setText(shop.getPricePerson());
        viewHolder.tvPosition.setText(shop.getPosition());
        viewHolder.tvDiscount.setText(shop.getDiscount());
        viewHolder.tvDistance.setText(shop.getDistance());
        return view;
    }
    class ViewHolder{
        TextView tvShopName,tvGrade,tvPricePerson,tvPosition,tvDiscount,tvDistance;
        ImageView ivShopPic;
    }
}
