package com.huanhailiuxin.demo.coolviewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void changeOrientation(View view) {
        startActivity(new Intent(MainActivity.this,ActivityOrientation.class));
    }

    public void changeEdgeEffectColor(View view) {
        startActivity(new Intent(MainActivity.this,ActivityEdgeEffectColor.class));
    }

    public void enableNotifyDataSetChanged(View view) {
        startActivity(new Intent(MainActivity.this,EnableNotifyActivity.class));
    }

    public void changeAutoScroll(View view) {
        startActivity(new Intent(MainActivity.this,ActivityAutoScroll.class));
    }

    public void changePageTransformer(View view) {
        startActivity(new Intent(MainActivity.this,ActivityPageTransformer.class));
    }
}
