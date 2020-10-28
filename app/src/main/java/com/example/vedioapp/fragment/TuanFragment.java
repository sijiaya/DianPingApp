package com.example.vedioapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vedioapp.R;
import com.example.vedioapp.activity.GlassActivity;
import com.example.vedioapp.adapter.SearchAdapter;
import com.example.vedioapp.adapter.ShopAdapter;
import com.example.vedioapp.entity.Food;
import com.example.vedioapp.entity.HomeIconInfo;
import com.example.vedioapp.entity.Shop;
import com.example.vedioapp.utils.FoodUtils;
import com.example.vedioapp.utils.ShopUtils;
import com.example.vedioapp.view.ShopListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TuanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TuanFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TuanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tuaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TuanFragment newInstance(String param1, String param2) {
        TuanFragment fragment = new TuanFragment();
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

    private ListView lvShopList;
    private List<Shop> shops;
    private ShopAdapter shopAdapter;
    private ImageView ivSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tuan,container,false);
        lvShopList = view.findViewById(R.id.lv_shop_list);
        ivSearch = view.findViewById(R.id.iv_search);
        //获取数据内容
        shops = ShopUtils.getAllShopList();
        //创建适配器对象
        shopAdapter = new ShopAdapter(getContext(), shops);
        lvShopList.setAdapter(shopAdapter);

        //点击搜索图标 跳转到 搜索页面
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), GlassActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}