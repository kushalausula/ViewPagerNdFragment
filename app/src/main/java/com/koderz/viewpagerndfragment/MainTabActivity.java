package com.koderz.viewpagerndfragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import java.util.LinkedHashMap;

public class MainTabActivity extends AppCompatActivity {


    private TabLayout tabLayput;
    ViewPager viewPager;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);
mContext=this;
        tabLayput=(TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        loadFragments();


    }

    private void loadFragments() {

        FragmentManager fragmentManager=getSupportFragmentManager();
        LinkedHashMap<Fragment, String> fragmentHashMap = new LinkedHashMap<Fragment, String>();

        fragmentHashMap.put(Fragment.instantiate(mContext, Fragment1.class.getName()), "First");
        fragmentHashMap.put(Fragment.instantiate(mContext, Fragment2.class.getName()), "Second");

       PagerAdapter mPagerAdapter = new PagerAdapter(fragmentManager, fragmentHashMap);
        viewPager.setAdapter(mPagerAdapter);


        tabLayput.setupWithViewPager(viewPager);


    }
}
