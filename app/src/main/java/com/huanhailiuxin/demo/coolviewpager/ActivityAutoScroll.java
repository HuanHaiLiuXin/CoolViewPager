package com.huanhailiuxin.demo.coolviewpager;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.huanhailiuxin.coolviewpager.CoolViewPager;

import java.util.ArrayList;
import java.util.List;

public class ActivityAutoScroll extends BaseActivity {
    private CoolViewPager vp;
    ActivityOrientation.MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_auto_scroll);
        getSupportActionBar().hide();
        initViews();
    }

    private void initViews() {
        List<View> items = new ArrayList<>();
        items.add(createImageView(R.mipmap.img3));
        items.add(createImageView(R.mipmap.img5));
        items.add(createImageView(R.mipmap.img6));
        items.add(createImageView(R.mipmap.img7));
        adapter = new ActivityOrientation.MyAdapter(items);
        //
        vp = findViewById(R.id.vp);
        vp.setScrollMode(CoolViewPager.ScrollMode.VERTICAL);
        vp.setAutoScroll(true,3000);
        vp.setScrollDuration(true,2000);
        vp.setAdapter(adapter);
    }

    int index = 0;
    public void buttonClick(View view) {
        if(index == 0){
            vp.toggleAutoScrollDirection();
            vp.setScrollDuration(true,1000);
            index = 1;
        }else{
            vp.toggleAutoScrollDirection();
            vp.setScrollDuration(true,500);
            index = 0;
        }
    }
}
