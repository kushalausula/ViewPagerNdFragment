package com.koderz.viewpagerndfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * The <code>PagerAdapter</code> serves the fragments when paging.
 * @author mwho
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private HashMap<Fragment, String> fragmentHashMap;
    /**
     * @param fm
     * @param fragments
     */
    public PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public PagerAdapter(FragmentManager fm, HashMap<Fragment, String> fragmentHashMap) {
        super(fm);
        fragments = new ArrayList<Fragment>();
        this.fragmentHashMap = fragmentHashMap;
        for (Iterator<Fragment> iterator = fragmentHashMap.keySet().iterator(); iterator.hasNext();) {
            Fragment type = (Fragment) iterator.next();
            fragments.add(type);
        }
    }
    /* (non-Javadoc)
     * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
     */
    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (fragmentHashMap != null) {
            return fragmentHashMap.get(getItem(position));
        } else {
            return "" + position;
        }
    }

    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
