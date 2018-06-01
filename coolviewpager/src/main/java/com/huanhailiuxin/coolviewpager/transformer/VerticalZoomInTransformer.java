package com.huanhailiuxin.coolviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 代码和ZoomInTransformer完全一致,为了使用便利保留
 *
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/1/26 15:41
 */
public class VerticalZoomInTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        if(position <= -1 || position >= 1){
            page.setTranslationX(0F);
            page.setScaleX(1.0F);
            page.setScaleY(1.0F);
            page.setAlpha(1.0F);
        }else{
            page.setTranslationX(page.getWidth() * -position);
            final float scale = position < 0 ? position + 1F : Math.abs(1F - position);
            page.setScaleX(scale);
            page.setScaleY(scale);
            page.setPivotX(page.getWidth() * 0.5F);
            page.setPivotY(page.getHeight() * 0.5F);
            page.setAlpha(position < -1F || position > 1F ? 0F : 1F - (scale - 1F));
        }
    }

}
