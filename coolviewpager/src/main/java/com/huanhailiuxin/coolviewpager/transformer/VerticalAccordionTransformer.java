package com.huanhailiuxin.coolviewpager.transformer;



import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 对应代码家的AccordionTransformer,VerticalAccordionTransformer适用于CoolViewPager在垂直方向滚动的情况
 *
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/1/26 11:37
 */
public class VerticalAccordionTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        page.setTranslationX(page.getWidth() * -position);
        page.setTranslationY(0F);
        if(position < -1 || position > 1){
            page.setScaleX(1F);
        }else{
            page.setPivotY(position < 0F ? 0F : page.getHeight());
            page.setScaleY(position < 0F ? 1F + position : 1F - position);
        }
    }

}