package com.example.vedioapp.entity;

/**
 * 首页(分类)
 */
public class HomeIconInfo {
    String iconName;
    int iconId;

    public HomeIconInfo(String iconName, int iconId) {
        this.iconName = iconName;
        this.iconId = iconId;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    @Override
    public String toString() {
        return "HomeIconInfo{" +
                "iconName='" + iconName + '\'' +
                ", iconId=" + iconId +
                '}';
    }
}
