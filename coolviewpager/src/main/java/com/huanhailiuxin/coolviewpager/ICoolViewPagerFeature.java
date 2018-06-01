package com.huanhailiuxin.coolviewpager;

import android.support.annotation.ColorInt;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/1/17 20:52
 *
 * 为CoolViewPager提供自定义属性的设置方法
 */

interface ICoolViewPagerFeature {
    /**
     * 设置滑动方向
     *
     * @param scrollMode
     */
    void setScrollMode(CoolViewPager.ScrollMode scrollMode);

    /**
     * 设置是否开启自动滚动,并设置自动滚动时间间隔
     *
     * @param autoScroll
     * @param intervalInMillis
     */
    void setAutoScroll(boolean autoScroll, int... intervalInMillis);



    /**
     * 设置自动滚动方向
     *
     * @param autoScrollDirection
     */
    void setAutoScrollDirection(CoolViewPager.AutoScrollDirection autoScrollDirection);

    /**
     * 在自动滚动开启情况下,自动滚动到下一页
     */
    void autoScrollNextPage();

    /**
     * 设置是否循环滚动
     *
     * @param infiniteLoop
     */
    void setInfiniteLoop(boolean infiniteLoop);

    /**
     * 设置是否绘制EdgeEffect
     *
     * @param drawEdgeEffect
     */
    void setDrawEdgeEffect(boolean drawEdgeEffect);

    /**
     * 设置EdgeEffect的颜色
     *
     * @param color
     */
    void setEdgeEffectColor(@ColorInt int color);

    /**
     * 设置是否自定义自动滑动耗时,并设置自动滑动耗时毫秒值
     *
     * @param ifSetScrollDuration
     * @param scrollDuration
     */
    void setScrollDuration(boolean ifSetScrollDuration, int... scrollDuration);
}
