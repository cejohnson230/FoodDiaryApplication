package com.example.catherinejohnson.fooddiaryapplication;

import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityStartPage extends BaseActivity {


    @BindView(R.id.tblogin_username)
    EditText username;


    @BindView(R.id.tblogin_pw)
    EditText password;

   private String un;
    private String pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btlogin_submit)
        public void login(){
        un = username.getText().toString();
        pw = password.getText().toString();

        if(un.equals("admin") && pw.equals("password") ){
            gotoActivity(ActivityMenu.class);
        }else{
            shortToast(un + " " + pw);
        }
    }
}
