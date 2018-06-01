package com.huanhailiuxin.demo.coolviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.huanhailiuxin.coolviewpager.CoolViewPager;

import java.util.ArrayList;
import java.util.List;

public class ActivityEdgeEffectColor extends BaseActivity {
    private CoolViewPager vp;
    ActivityOrientation.MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_edge_effect_color);
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
        vp.setScrollMode(CoolViewPager.ScrollMode.HORIZONTAL);
        vp.setAdapter(adapter);
    }

    private int colorIndex = 0;
    private int[] colors = new int[]{Color.GREEN,Color.RED,Color.BLUE};
    public void buttonClick(View view) {
        colorIndex = (++colorIndex)%colors.length;
        vp.setEdgeEffectColor(colors[colorIndex]);
    }
}
