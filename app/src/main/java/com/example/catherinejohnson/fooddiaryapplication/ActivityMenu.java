package com.example.catherinejohnson.fooddiaryapplication;

import android.os.Bundle;
import android.widget.ListView;

import com.example.catherinejohnson.fooddiaryapplication.adapter.ListNormalAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ActivityMenu extends BaseActivity {

    @BindView(R.id.activty_main_lv)
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        ArrayList<String> list = new ArrayList<>();
        list.add("Shopping List");
        list.add("Recipes");
        list.add("Timer");
        list.add("Coupons");
        list.add("Restaurants");
        list.add("About Foodi");
        ListNormalAdapter adapter = new ListNormalAdapter(this, list);
        lv.setAdapter(adapter);

    }

    @OnItemClick(R.id.activty_main_lv)
    public void itemSelect(int position){
        switch (position){
            case 0:
                gotoActivity(ActivityShoppingList.class);
                break;
            case 1:
                gotoActivity(ActivityRecipes.class);
                break;
            case 2:
                gotoActivity(ActivityTimer.class);
                break;
            case 3:
                gotoActivity(ActivityCoupons.class);
                break;
            case 4:
                gotoActivity(MapsActivity.class);
                break;
        }
    }
}
