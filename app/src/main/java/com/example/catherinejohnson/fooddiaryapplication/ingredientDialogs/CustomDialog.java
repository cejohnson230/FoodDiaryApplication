package com.example.catherinejohnson.fooddiaryapplication.ingredientDialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.catherinejohnson.fooddiaryapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialog extends Dialog {

    private final ICustomDialongListener listener;

    public interface ICustomDialongListener {
        public void onOKClicked(String msg);
//        public void onCancleCLicked();
    }

    @OnClick(R.id.dialog_custom_ok)
    //OnClick always has to have a public method after
    public void ok(View view) {
        listener.onOKClicked("You clicked OK");
        cancel();
    }

    public CustomDialog(@NonNull Context context, ICustomDialongListener listener) {
        super(context, R.style.dialog);
        setContentView(R.layout.dialog_custom);
        ButterKnife.bind(this);
        this.listener = listener;
    }
}
