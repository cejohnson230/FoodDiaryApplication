package com.example.catherinejohnson.fooddiaryapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.catherinejohnson.fooddiaryapplication.adapter.BaseViewPagerAdapter;
import com.example.catherinejohnson.fooddiaryapplication.fragment.LemonChickenFragment;
import com.example.catherinejohnson.fooddiaryapplication.fragment.MashPotatosFragment;

import java.util.ArrayList;

public class ActivityRecipes extends BaseActivity {

    private ArrayList<Fragment> list = new ArrayList<Fragment>();
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        viewPager = (ViewPager)findViewById(R.id.activity_recipes_vp);

        list.add(new LemonChickenFragment());
        list.add(new MashPotatosFragment());

        BaseViewPagerAdapter pagerAdapter =
                new BaseViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);
    }
}
