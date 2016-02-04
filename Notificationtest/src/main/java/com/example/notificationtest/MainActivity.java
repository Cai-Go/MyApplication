package com.example.notificationtest;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_notice:
                NotificationManager manager = (NotificationManager) getSystemService(
                        NOTIFICATION_SERVICE);
/*                Notification notification = new Notification(R.drawable.ic_launcher
                        , "This is ticker text"
                        , System.currentTimeMillis());
                 第一个参数代表图标
                第二个参数代表提示的内容，
                 第三个参数是指要显示的时间，一般是当即显示，故填入系统当前时间。*/

                //参考 http://blog.csdn.net/u013425527/article/details/41408579

                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0
                        , intent, PendingIntent.FLAG_CANCEL_CURRENT);
                //注意getActivities()方法的选择

                Notification.Builder builder =new Notification.Builder(this)
                        .setContentTitle("New mail from ")
                        .setContentText("This is ticker text")
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentIntent(pi)//把PendingIntent传入进来
                        .setWhen(System.currentTimeMillis());
                        //高于API11低于API16使用。
                /*
                * //API16以上使用
                *Notification notification = new Notification.Builder(context)
                * .setAutoCancel(true)
                * .setContentTitle("title")
                * .setContentText("describe")
                * .setContentIntent(pendingIntent)
                * .setSmallIcon(R.drawable.ic_launcher)
                * .setWhen(System.currentTimeMillis())
                * .build();
                * */
                Notification notification = builder.getNotification();

                /*
                * 通知的高级技巧
                * */
                //使用铃声
                Uri soundUri = Uri.fromFile(new File("/system/media/audio/ringtones/Basic_tone.ogg"));
                notification.sound = soundUri;

                //使用震动
                long[] vibrates = {0,1000,1000,1000};
                /*下标0表示手机静止的时长，
                *下标1表示振动的时长,
                *下标2也表示手机静止的时长。
                * 以毫秒为单位。
                * 需要添加权限：
                * <uses-permission android:name="android.permission.VIBRATE"></uses-permission>
                * */
                notification.vibrate =vibrates;

                //LED灯的显示:
                notification.ledARGB = Color.GREEN;//控制LED灯的颜色
                notification.ledOnMS = 1000;//指定LED灯亮起来的时长
                notification.ledOffMS = 1000;//指定LED灯暗去的时长
                notification.flags = Notification.FLAG_SHOW_LIGHTS;//指导通知的一些行为，包括显示LED灯

                //使用通知的默认效果，自行决定铃声和振动
                notification.defaults = Notification.DEFAULT_ALL;

                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }
}
