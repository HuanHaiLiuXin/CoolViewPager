package com.huanhailiuxin.coolviewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 对应代码家的RotateDownTransformer,VerticalRotateDownTransformer适用于CoolViewPager在垂直方向滚动的情况
 *
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/1/26 14:18
 */
public class VerticalRotateDownTransformer implements ViewPager.PageTransformer {

	private static final float ROT_MOD = 75F;

	@Override
	public void transformPage(View page, float position) {
		if(position <= -1 || position >= 1){
			page.setRotation(0F);
		}else{
			final float width = page.getWidth();
			final float height = page.getHeight();
			final float rotation = ROT_MOD * position * -1.25F;
			page.setPivotX(width);
			page.setPivotY(height * 0.5F);
			page.setRotation(rotation);
		}
	}

}
