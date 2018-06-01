package com.huanhailiuxin.coolviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 对应RotateTransformer,VerticalRotateTransformer适用于CoolViewPager在垂直方向滚动的情况
 *
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/1/26 11:45
 */
public class VerticalRotateTransformer implements ViewPager.PageTransformer {
    private float MAX_ROTATE = 90F;

    @Override
    public void transformPage(View page, float position) {
        page.setTranslationX(page.getWidth() * -position);
        page.setTranslationY(page.getHeight() * position);
        page.setCameraDistance(10000F);
        if(position < -1){
            page.setRotationX(0F);
        }else if(position <= 0){
            page.setPivotX(page.getWidth()/2);
            page.setPivotY(page.getHeight());
            page.setRotationX(MAX_ROTATE * -position);
        }else if(position <= 1){
            page.setPivotX(page.getWidth()/2);
            page.setPivotY(0F);
            page.setRotationX(MAX_ROTATE * -position);
        }else {
            page.setRotationX(0F);
        }
    }
}
