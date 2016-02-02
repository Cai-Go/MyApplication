package com.example.smstest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by WWW on 2016/2/2.
 */
public  class SendStatusReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (getResultCode() == Activity.RESULT_OK) {
            //短信发送成功
            Toast.makeText(context, "Send succeeded", Toast.LENGTH_SHORT).show();
        } else {
            //短信发送失败
            Toast.makeText(context, "Send failed", Toast.LENGTH_LONG).show();
        }
    }
}
