package com.example.catherinejohnson.fooddiaryapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.example.catherinejohnson.fooddiaryapplication.adapter.ListNormalAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityShoppingList extends BaseActivity {

    @BindView(R.id.activity_shopping_lv)
    ListView lv;

    @BindView(R.id.activity_new_item)
    EditText newItem;

    ArrayList <String> listView = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        ButterKnife.bind(this);

        ListNormalAdapter adapter = new ListNormalAdapter(this, listView);
        lv.setAdapter(adapter);
    }

    @OnClick(R.id.activity_add_button)
    public void add(){
        listView.add(newItem.getText().toString());
        lv.invalidateViews();
    }

}
