package com.example.mydesigntest;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setContentView(R.layout.main_layout);

//        final TextInputLayout textInput = (TextInputLayout) findViewById(R.id.textInput);
//        textInput.setHint("请输入用户名");
//        EditText editText = textInput.getEditText();

//        if (editText != null) {
//            editText.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                    if(charSequence.length()>10){
//                        textInput.setError("用户名不能超过10位");
//                        textInput.setErrorEnabled(true);
//                    }else {
//                        textInput.setErrorEnabled(false);
//                    }
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable editable) {
//
//                }
//            });
//        }
//       final  FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Snackbar snackbar = Snackbar.make( btn ,"你点击了按钮",Snackbar.LENGTH_LONG);
//                snackbar.show();
//                //snackbar添加点击事件
//                snackbar.setAction("知道了", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        snackbar.dismiss();//隐藏snackbar
//                    }
//                });
//            }
//        });
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        List<String> titles = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0;i<4;i++){
            String title= "Tab"+(i+1);
            tabs.addTab(tabs.newTab().setText(title));
            titles.add(title);
            Fragment fragment = new myFragment(title);
            fragments.add(fragment);
        }

        ViewPager viewPager  = (ViewPager) findViewById(R.id.viewpager);
        myFragmentAdapter mAdapter = new myFragmentAdapter(getSupportFragmentManager()
                ,titles,fragments);
        viewPager.setAdapter(mAdapter);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabsFromPagerAdapter(mAdapter);


//        DrawerLayout drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawerLayout.closeDrawer();
    }
}

