package com.example.catherinejohnson.fooddiaryapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    private Animation rotateAnimation;
    @BindView(R.id.activity_main_loading)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        iv.startAnimation(rotateAnimation);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoActivity(ActivityStartPage.class);
            }
        }, 5000);

    }





}
