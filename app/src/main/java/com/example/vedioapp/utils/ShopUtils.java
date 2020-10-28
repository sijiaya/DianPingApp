package com.example.vedioapp.utils;

import com.example.vedioapp.R;
import com.example.vedioapp.entity.Food;
import com.example.vedioapp.entity.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopUtils {
    public static int[] imagesId={R.mipmap.shop1,R.mipmap.shop2,R.mipmap.shop3,R.mipmap.shop4,R.mipmap.shop5,R.mipmap.shop6,R.mipmap.shop7};
    public static String[] shopNameSort= {"麻喜大","BOPEYE炸鸡","付小姐在成都","济物浦","回味鸭血粉丝汤","清真·金同记","李记清真馆"};
    public static String[] gradeSort = {"4.79","4.87","4.86","4.82","4.36","4.69","4.61" };
    public static String[] pricePersonSort = {"¥77/人","¥66/人","¥76/人","¥60/人","¥22/人","¥25/人","¥25/人"};
    public static String[] positionSort={"仙林大学城","仙林大学城","仙林大学城","仙林大学城","新街口地区","南京老字号夫子庙","打钉巷1号"
    };
    public static String[] distanceSort = {"3.5km","3.6km","3.4km","3.4km","16.7km","14.6km","13.7"};
    public static String[] discountSort = {"买单9.5折","45代50元","买单满100减2","100元双人餐","价值20元的代金券1张，全场通用，可叠加使用",
    "价值20元的代金券1张，全场通用，可叠加使用","价值28元的经典传承牛肉锅贴+牛肉馄饨套餐"};


    public static List<Shop> getAllShopList(){
        List<Shop> list = new ArrayList<>();
        for (int i = 0; i < shopNameSort.length; i++) {
            Shop shop = new Shop(imagesId[i],shopNameSort[i],gradeSort[i],pricePersonSort[i],
                    positionSort[i],distanceSort[i],discountSort[i]);
            list.add(shop);
        }
        return list;
    }
}
