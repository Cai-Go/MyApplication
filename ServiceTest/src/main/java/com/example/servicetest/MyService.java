package com.example.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by WWW on 2016/2/4.
 */
public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
/*
* onCreate()方法在服务创建的时候调用
* */
    @Override
    public void onCreate() {
        super.onCreate();
        //使用前台服务
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0
                , intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder builder =new Notification.Builder(this)
                .setContentText("Notification comes")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(pi)//把PendingIntent传入进来
                .setWhen(System.currentTimeMillis());
        Notification notification = builder.getNotification();
        startForeground(1,notification);//第一个参数是id ，第二个参数是Notification对象

        Log.d("MyService","onCreat executed");
    }

    /*
    * onStartCommand()方法早每次服务启动的时候调用
    * */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    /*
    * onDestroy()方法在服务销毁的时候调用
    * */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService","onDestroy executed");
    }
/*
* 让活动和服务的关系更紧密
* */
     class DownloadBinder extends Binder{
        public  void startDownload(){
            Log.d("MyService","startDownload executed");
        }
    public int getProgress(){
        Log.d("MyService","getProgress executed");
        return 0;
    }
    }
}
