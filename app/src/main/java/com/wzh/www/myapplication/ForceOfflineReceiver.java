package com.wzh.www.myapplication;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by WWW on 2016/1/27.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBulider = new AlertDialog.Builder(context);
        dialogBulider.setTitle("Warning");
        dialogBulider.setMessage("You are forced to be offline.Please try tp login again");
        dialogBulider.setCancelable(false);
        dialogBulider.setPositiveButton("OK",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();//销毁所有活动
                Intent intent = new Intent(context, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);//重新启动LoginActibity
            }
        });
        AlertDialog alertDialog = dialogBulider.create();
        //需要设置AlertDialog类型，保证广播接收器中可以正常弹出。

        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();

    }
}
