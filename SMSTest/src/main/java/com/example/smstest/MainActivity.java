package com.example.smstest;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView sender, content;
    private IntentFilter receiveFilter;
    private MessageReceiver messageReceiver;
    private EditText to,msgInput;
    private Button send;
    private IntentFilter sendFilter;
    private SendStatusReceiver sendStatusReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sender = (TextView) findViewById(R.id.sender);
        content = (TextView) findViewById(R.id.content);
        to = (EditText) findViewById(R.id.to);
        msgInput = (EditText) findViewById(R.id.msg_input);
        send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                Intent sentIntent = new Intent("SENT_SMS_ACTION");
                PendingIntent pi  =PendingIntent.getBroadcast(MainActivity.this,0,sentIntent,0);
                smsManager.sendTextMessage(to.getText().toString(),null
                        ,msgInput.getText().toString(),pi,null);
                /*
                * sendTextMessage()方法接收5个参数，
                * 第一个参数用于指定接受人手机号码
                * 第三个参数用于指定短信的内容。
                * 其他参数暂时用不到，直接传入null
                * */
            }
        });


        receiveFilter = new IntentFilter();
        receiveFilter.addAction("android.privoder.Telephony.SMS_RECEIVED");
        receiveFilter.setPriority(100);//提高MessageReceiver的优先级
        messageReceiver = new MessageReceiver();
        registerReceiver(messageReceiver, receiveFilter);
    }
    class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            abortBroadcast();
            Bundle bundle = intent.getExtras();
            Object[] pdus = (Object[]) bundle.get("pdus");//提取短信消息
            SmsMessage[] messages = new SmsMessage[pdus.length];
            for (int i = 1; i < messages.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            String address = messages[0].getOriginatingAddress();//获取发送方号码
            String fullMessage = "";
            for (SmsMessage message : messages) {
                fullMessage += message.getMessageBody();//获取短信内容
            }
            sender.setText(address);
            content.setText(fullMessage);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(messageReceiver);
        unregisterReceiver(sendStatusReceiver);
    }
}
