package com.huanhailiuxin.coolviewpager.transformer;

/**
 * Created by daimajia on 14-5-29.
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class AccordionTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        if(position < -1 || position > 1){
            page.setTranslationX(0F);
            page.setScaleX(1F);
        }else{
            page.setPivotX(position < 0F ? 0F : page.getWidth());
            page.setScaleX(position < 0F ? 1F + position : 1F - position);
            page.setTranslationX(page.getWidth() * -position);
        }
    }
}