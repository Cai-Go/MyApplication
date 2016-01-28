package com.wzh.www.learnrv;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rv  =new RecyclerView(this);
        setContentView(rv);

//        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rv.setLayoutManager(new GridLayoutManager(this,3));//第一个参数是this，第二个是有多少列（垂直方向）或者多少行（水平方向）

        rv.setAdapter(new MyAdapter());



    }

}
