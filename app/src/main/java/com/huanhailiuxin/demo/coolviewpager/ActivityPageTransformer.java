package com.huanhailiuxin.demo.coolviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.huanhailiuxin.coolviewpager.CoolViewPager;

import java.util.ArrayList;
import java.util.List;

public class ActivityPageTransformer extends BaseActivity {
    private CoolViewPager vp;
    ActivityOrientation.MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_page_transformer);
        getSupportActionBar().hide();
        initViews();
    }

    private void initViews() {
        vp = findViewById(R.id.vp);
        initData();
    }

    private void initData() {
        List<View> items = new ArrayList<>();
        items.add(createImageView(R.mipmap.img3));
        items.add(createImageView(R.mipmap.img5));
        items.add(createImageView(R.mipmap.img6));
        items.add(createImageView(R.mipmap.img7));
        adapter = new ActivityOrientation.MyAdapter(items);
        vp.setAdapter(adapter);
    }

    private int currIndex = -1;
    private ViewPager.PageTransformer[] verticals = new ViewPager.PageTransformer[]{
            new com.huanhailiuxin.coolviewpager.transformer.VerticalAccordionTransformer(),
            new com.huanhailiuxin.coolviewpager.transformer.VerticalRotateTransformer(),
            new com.huanhailiuxin.coolviewpager.transformer.VerticalDepthPageTransformer(),
            new com.huanhailiuxin.coolviewpager.transformer.VerticalRotateDownTransformer(),
            new com.huanhailiuxin.coolviewpager.transformer.VerticalZoomInTransformer()
    };
    public void buttonClick(View view) {
        initData();
        currIndex = (++currIndex)%verticals.length;
        vp.setPageTransformer(false,verticals[currIndex]);
    }
}
