package com.wzh.www.learnrv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by WWW on 2016/1/29.
 */
class MyAdapter extends RecyclerView.Adapter {

    //创建ViewHolder方法
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        return new ViewHolder(new TextView(viewGroup.getContext()));
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cell,null));//创建一个布局解释器来解释布局
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewholder, int position) {
        //对TextView进行赋值。
        //第二个参数是一个索引，获取的哪一条
        ViewHolder vh = (ViewHolder) viewholder;
//        vh.getTv().setText("Item" + position);

        CellData cd = data[position];
        vh.getTvTitle().setText(cd.title);
        vh.getTvContent().setText(cd.content);


    }

    //获取RecyclerView的子对象的数量
    @Override
    public int getItemCount() {
        //return 1000;//生成10个子对象
        return data.length;

 }

    private CellData[] data = new CellData[]{new CellData("盐酸","硫酸"),new CellData("新闻","特大新闻") };
//    private  String data[] = new String[]{"Hello","World","WZH"};
}
