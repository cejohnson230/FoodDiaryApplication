package com.example.catherinejohnson.fooddiaryapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by catherinejohnson on 6/12/17.
 */

public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> list;

    public BaseViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public BaseViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
