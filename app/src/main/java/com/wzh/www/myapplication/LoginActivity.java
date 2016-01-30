package com.wzh.www.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by WWW on 2016/1/27.
 */
public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passordEdit;
    private Button login;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox remenberPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText) findViewById(R.id.account);
        passordEdit= (EditText) findViewById(R.id.password);
        login= (Button) findViewById(R.id.login);
        remenberPass = (CheckBox) findViewById(R.id.remember_pass);
        boolean isRmember = pref.getBoolean("remember_password",false);
        if (isRmember){
            //将账号和密码设置到文本框中
            String account =pref.getString("account" ,"");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passordEdit.setText(password);
            remenberPass.setChecked(true);

        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passordEdit.getText().toString();

                if(account.equals("admin")&&password.equals("123456")){
                    editor = pref.edit();
                    if (remenberPass.isChecked()){//检查复选框是否被选中
                        editor.putBoolean("remember_password",true);
                        editor.putString("account" ,account);
                        editor.putString("password", password);
                    }else {
                        editor.clear();
                    }
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
