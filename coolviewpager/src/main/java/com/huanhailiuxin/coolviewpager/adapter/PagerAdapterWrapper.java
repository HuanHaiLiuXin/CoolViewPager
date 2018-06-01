package com.huanhailiuxin.coolviewpager.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2018/1/24 9:20
 *
 * <p>
 *     重写getItemPosition,解决原生PagerAdapter实例调用{@link PagerAdapter#notifyDataSetChanged()},ViewPager界面不刷新的问题
 * </p>
 */

public class PagerAdapterWrapper extends PagerAdapter {
    private PagerAdapter mAdapter;
    public PagerAdapterWrapper(PagerAdapter adapter){
        this.mAdapter = adapter;
    }

    @Override
    public int getCount() {
        return mAdapter == null ? 0 : mAdapter.getCount();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return mAdapter.isViewFromObject(view,object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return mAdapter.instantiateItem(container,position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        mAdapter.destroyItem(container,position,object);
    }

    /**
     * 解决原生PagerAdapter实例调用{@link PagerAdapter#notifyDataSetChanged()},ViewPager界面不刷新的问题
     * 详见:http://www.07net01.com/program/642011.html
     *
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(@NonNull Object object) {
        int mChildCount = getCount();
        if(mChildCount > 0){
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }
}
