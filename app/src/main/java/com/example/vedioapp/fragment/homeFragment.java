package com.example.vedioapp.fragment;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vedioapp.R;
import com.example.vedioapp.utils.MyUtils;
import com.lidroid.xutils.ViewUtils;

import org.xutils.view.annotation.ViewInject;


/**
 * 首页
 */
public class homeFragment extends Fragment implements LocationListener{

    //当前城市名称
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //将xml文件映射为view对象
        View view = inflater.inflate(R.layout.fragment_home,null);
        GridView navSort = view.findViewById(R.id.home_nav_sort);
//        navSort.setAdapter(new NavAdapter());

        return view;

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

//    private class NavAdapter extends BaseAdapter {
//        //计算需要适配的数据总量
//        @Override
//        public int getCount() {
//            return MyUtils.navsSort.length;
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        //item 对应的view的数据渲染
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            //在convertView为null的时候将布局转换为view
//            MyHolder myHolder = null;
//            if (convertView == null){
//                myHolder = new MyHolder();
//                //加载分类布局文件
//                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_nav_item,null);
//                ViewUtils.inject(myHolder,convertView);
//                convertView.setTag(myHolder);
//            }else {
//                myHolder = (MyHolder) convertView.getTag();
//            }
//            //进行 赋值
//            myHolder.textView.setText(MyUtils.navsSort[position]);
//            myHolder.imageView.setImageResource(MyUtils.navsSortImage[position]);
//            //如果 选择的是 全部
//            if (position == MyUtils.navsSort.length-1){
//                //给 图标 设置监听事件
//                myHolder.imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //开启新的界面，从当前页面跳转到
//                        startActivity(new Intent(getActivity(), AllCategoryActivity.class));
//                    }
//                });
//            }
//            return convertView;
//        }
//    }
//    public class MyHolder{
//        @ViewInject(R.id.home_nav_item_desc)
//        public TextView textView;
//        @ViewInject(R.id.home_nav_item_image)
//        public ImageView imageView;
//    }
}