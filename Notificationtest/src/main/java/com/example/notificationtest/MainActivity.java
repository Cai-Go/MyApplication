package com.example.notificationtest;


import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

                //参考http://blog.csdn.net/u013425527/article/details/41408579
                Notification.Builder builder =new Notification.Builder(this)
                        .setContentTitle("New mail from " + sendNotice.toString())
                        .setContentText("This is ticker text")
                        .setSmallIcon(R.drawable.ic_launcher)
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
                *
                *
                * */
                Notification notification = builder.getNotification();
                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }
}
