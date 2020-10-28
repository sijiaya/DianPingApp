package com.example.vedioapp.entity;

import java.io.Serializable;

/**
 * 店铺商品
 */
public class Food implements Serializable {
    //图片
    private int picId;
    //名称
    private String foodName;
    //描述
    private String desc;
    public Food() {
    }

    public Food(int picId, String foodName, String desc) {
        this.picId = picId;
        this.foodName = foodName;
        this.desc = desc;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    @Override
    public String toString() {
        return "Food{" +
                "picId=" + picId +
                ", foodName='" + foodName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
