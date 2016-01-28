package com.wzh.www.learnrv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rv  =new RecyclerView(this);
        setContentView(rv);

        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(new RecyclerView.Adapter() {

             //创建ViewHolder方法
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
                return new ViewHolder(new TextView(viewGroup.getContext()));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder viewholder, int position) {
                //对TextView进行赋值。
                //第二个参数是一个索引，获取的哪一条
                ViewHolder   vh = (ViewHolder) viewholder;
                vh.getTv().setText("Item"+ position);

            }
            //获取RecyclerView的子对象的数量
            @Override
            public int getItemCount() {
                return 1000;//生成10个子对象
            }
        });



    }

}
