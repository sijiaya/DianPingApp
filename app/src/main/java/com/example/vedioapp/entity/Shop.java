package com.example.vedioapp.entity;

import java.util.List;

/**
 * 店铺
 */
public class Shop {
    //店铺图片
    private int shopPicId;
    //店铺名称
    private String shopName;
    //店铺评分
    private String grade;
    //店铺 人均价格
    private String pricePerson;
    //店铺地址
    private String position;
    //店铺距离
    private String distance;
    //店铺折扣
    private String discount;

    public Shop() {
    }

    public Shop(int shopPicId, String shopName, String grade, String pricePerson, String position, String distance, String discount) {
        this.shopPicId = shopPicId;
        this.shopName = shopName;
        this.grade = grade;
        this.pricePerson = pricePerson;
        this.position = position;
        this.distance = distance;
        this.discount = discount;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPricePerson() {
        return pricePerson;
    }

    public void setPricePerson(String pricePerson) {
        this.pricePerson = pricePerson;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getShopPicId() {
        return shopPicId;
    }

    public void setShopPicId(int shopPicId) {
        this.shopPicId = shopPicId;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopPicId=" + shopPicId +
                ", shopName='" + shopName + '\'' +
                ", grade='" + grade + '\'' +
                ", pricePerson='" + pricePerson + '\'' +
                ", position='" + position + '\'' +
                ", distance='" + distance + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }
}
