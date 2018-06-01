package com.huanhailiuxin.demo.coolviewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.huanhailiuxin.coolviewpager.CoolViewPager;

import java.util.ArrayList;
import java.util.List;

public class ActivityOrientation extends BaseActivity {
    private CoolViewPager vp;
    MyAdapter adapter1;
    MyAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_orientation);
        getSupportActionBar().hide();
        initViews();
    }
    private void initViews(){
        List<View> items1 = new ArrayList<>();
        items1.add(createImageView(R.mipmap.i1));
        items1.add(createImageView(R.mipmap.i2));
        items1.add(createImageView(R.mipmap.i5));
        items1.add(createImageView(R.mipmap.i6));
        List<View> items2 = new ArrayList<>();
        items2.add(createImageView(R.mipmap.img3));
        items2.add(createImageView(R.mipmap.img5));
        items2.add(createImageView(R.mipmap.img6));
        items2.add(createImageView(R.mipmap.img7));
        adapter1 = new MyAdapter(items1);
        adapter2 = new MyAdapter(items2);
        //
        vp = findViewById(R.id.vp);
        vp.setScrollMode(CoolViewPager.ScrollMode.HORIZONTAL);
        vp.setAdapter(adapter1);
    }

    private int index = 0;
    public void buttonClick(View view) {
        if(index % 2 == 0){
            vp.setScrollMode(CoolViewPager.ScrollMode.VERTICAL);
            vp.setAdapter(adapter2);
            index = 1;
        }else{
            vp.setScrollMode(CoolViewPager.ScrollMode.HORIZONTAL);
            vp.setAdapter(adapter1);
            index = 0;
        }
    }


    static class MyAdapter extends PagerAdapter {
        private List<View> views;
        public MyAdapter(List<View> items){
            this.views = items;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //必须要先判断,否则报错:java.lang.IllegalStateException: The specified child already has a parent
            //ViewGroup的addView（）方法不能添加一个已存在父控件的视图,所以在执行前需要判断要添加的View实例是不是存在父控件.
            //如果存在父控件,需要其父控件先将该View移除掉,再执行addView
            if(views.get(position).getParent() != null){
                ((ViewGroup)views.get(position).getParent()).removeView(views.get(position));
            }
            container.addView(views.get(position));
            return views.get(position);
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
