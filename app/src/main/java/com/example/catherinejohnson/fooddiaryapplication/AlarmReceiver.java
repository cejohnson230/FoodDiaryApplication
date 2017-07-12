package com.example.catherinejohnson.fooddiaryapplication;

/**
 * Created by catherinejohnson on 7/11/17.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "ALARM", Toast.LENGTH_LONG).show();
    }
}
