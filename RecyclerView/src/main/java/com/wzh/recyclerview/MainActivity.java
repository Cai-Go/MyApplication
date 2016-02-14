package com.wzh.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // 设置高性能模式，必须在确定内容大小不变的情况下设置
        mRecyclerView.setHasFixedSize(true);
        // 设施线性布局
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        public  class ViewHolder extends RecyclerView.ViewHolder{
            private TextView mtext1,mtext2;
            public ViewHolder(View itemView) {
                super(itemView);
                mtext1 = (TextView)itemView. findViewById(R.id.info);
                mtext2 = (TextView)itemView. findViewById(R.id.content);
            }
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list
                    ,parent,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.mtext1.setText("Android入门教程");
            holder.mtext2.setText("本文总结了关于Android开发的入门教程，帮助学习");
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}
