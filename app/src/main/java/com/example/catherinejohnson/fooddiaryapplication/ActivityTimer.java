package com.example.catherinejohnson.fooddiaryapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityTimer extends BaseActivity {


    private Thread thread;
    @BindView(R.id.activity_handler_et)
    EditText editText;

    @BindView(R.id.activity_handler_bt)
    Button button;

    @BindView(R.id.activity_handler_timeleft)
    TextView tv;

    @BindView(R.id.counter)
    TextView count;

    private final int TIMER = 123;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
               case TIMER:

                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    shortToast("Message:"+s);
//
//                    count.setText(String.valueOf(Integer.valueOf(editText.getText().toString())*60*1000));
//                    int number = Integer.valueOf(count.getText().toString());
//
//
//                   count.setText(String.valueOf(--number));
//
//
//                   int counter = number--;
//                   int h = ((counter / 1000) / 3600);
//                   int m = (((counter / 1000) / 60) % 60);
//                   int sec = ((counter / 1000) % 60);
//                    tv.setText(h + ":"+ m + ":"+sec);//number--
                   int number = Integer.valueOf(editText.getText().toString());
                   editText.setText(String.valueOf(--number));//number--

                    if (number==0){
                        setAlarm();
                        button.setText("Reset");
                        button.setOnClickListener(resetListener);
                    }else{
                        thread.run();
                    }
                    break;
                default:
            }
            super.handleMessage(msg);
        }
    };

    private View.OnClickListener resetListener;
    private View.OnClickListener startListener;
    private View.OnClickListener stopListener;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);

        startListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Stop");
                editText.setEnabled(false);
                button.setOnClickListener(stopListener);
                startThread();
            }
        };
        stopListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Reset");
                button.setOnClickListener(resetListener);

            }
        };
        resetListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Start");
                editText.setEnabled(true);
                button.setOnClickListener(startListener);
            }
        };

        button.setOnClickListener(startListener);
    }
    private void startThread(){
        thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    Message msg = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString("msg","TimerMessage");
                    msg.setData(bundle);
                    msg.what=TIMER;
                    handler.sendMessage(msg);
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    public void setAlarm(){
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0);
        manager.set(AlarmManager.RTC,5000, pendingIntent);
    }
}
