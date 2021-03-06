package com.nicootech.fragment8tablayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;


import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar,toolbartab;
    ViewPager viewPager;
    TabLayout tabLayout;

    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbartab = findViewById(R.id.toolbartab);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);

        setSupportActionBar(toolbar);



        pageAdapter= new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new RedFragment(), "Red");
        pageAdapter.addFragment(new GreenFragment(), "Green");
        pageAdapter.addFragment(new BlueFragment(), "Blue");

        //viewPager.setPageTransformer(true,new ZoomOutPageTransformer());
        //or
        viewPager.setPageTransformer(true,new DepthPageTransformer());

        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                        getWindow().setStatusBarColor(Color.RED);
                        toolbar.setBackgroundColor(Color.RED);
                        toolbartab.setBackgroundColor(Color.RED);
                        tabLayout.setBackgroundColor(Color.RED);
                        break;
                    case 1:
                        getWindow().setStatusBarColor(Color.GREEN);
                        toolbar.setBackgroundColor(Color.GREEN);
                        toolbartab.setBackgroundColor(Color.GREEN);
                        tabLayout.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        getWindow().setStatusBarColor(Color.BLUE);
                        toolbar.setBackgroundColor(Color.BLUE);
                        toolbartab.setBackgroundColor(Color.BLUE);
                        tabLayout.setBackgroundColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
