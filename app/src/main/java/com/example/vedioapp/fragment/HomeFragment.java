package com.example.vedioapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vedioapp.activity.AllCategoryActivity;
import com.example.vedioapp.R;
import com.example.vedioapp.adapter.ShopAdapter;
import com.example.vedioapp.entity.HomeIconInfo;
import com.example.vedioapp.entity.Shop;
import com.example.vedioapp.utils.ShopUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeFragment extends Fragment{
    public static String[] navsSort= {"美食","景点","酒店","休闲","电影","医学美容","丽人/美发",
            "医疗","学习培训","全部"};
    public static int[] navsSortImages={R.drawable.icon_food,R.drawable.icon_spot,R.drawable.icon_hotel,
            R.drawable.icon_relax,R.drawable.icon_movie,R.drawable.icon_beauty,R.drawable.icon_hair,R.drawable.icon_medical,
            R.drawable.icon_study,R.drawable.icon_all};


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyFragment newInstance(String param1, String param2) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private GridView gridView;
    private List<HomeIconInfo> iconInfoList;
    private GridView gvShop;
    private List<Shop> shopList;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        //将xml文件映射为view对象
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        gridView = view.findViewById(R.id.home_nav_sort);
        gvShop = view.findViewById(R.id.home_nav_sort2);

        //获取数据内容
        iconInfoList = new ArrayList<>();
        shopList = ShopUtils.getAllShopList();

        for (int i=0;i<navsSort.length;i++){
            iconInfoList.add(new HomeIconInfo(navsSort[i],navsSortImages[i]));
        }

        //调用适配器
        HomeIconAdapter homeIconAdapter = new HomeIconAdapter(getContext(),iconInfoList);
        ShopAdapter shopAdapter = new ShopAdapter(getContext(),shopList);
        //设置适配器
        gridView.setAdapter(homeIconAdapter);
        gvShop.setAdapter(shopAdapter);
        return view;
    }

    public class HomeIconAdapter extends BaseAdapter{
        private Context context;
        private List<HomeIconInfo> iconInfoList;


        public HomeIconAdapter(Context context, List<HomeIconInfo> iconInfoList) {
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
            ViewHolder holder = null;
            //view 为null的时候布局转换
            if (view == null) {
                //获取icon基础布局xml
                view = View.inflate(context, R.layout.home_index_nav_item, null);
                holder = new ViewHolder();

                holder.textView = view.findViewById(R.id.home_nav_item_desc);
                holder.imageView = view.findViewById(R.id.home_nav_item_image);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            HomeIconInfo homeIconInfo = iconInfoList.get(i);
            //赋值
            holder.textView.setText(homeIconInfo.getIconName());
            holder.imageView.setBackgroundResource(homeIconInfo.getIconId());
            //选中的如果是 全部图标
            if (i == HomeFragment.navsSort.length - 1) {
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //点击 全部图标后 开启一个新的页面
                    startActivity(new Intent(getActivity(), AllCategoryActivity.class));
                    }
                });
            }
            return view;
        }
        public class ViewHolder{
            TextView textView;
            ImageView imageView;
        }
    }

}