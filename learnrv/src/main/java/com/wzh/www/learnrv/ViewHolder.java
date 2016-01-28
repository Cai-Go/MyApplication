package com.wzh.www.learnrv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by WWW on 2016/1/28.
 */


public class ViewHolder extends RecyclerView.ViewHolder {
    private View root;
    private TextView tvTitle,tvContent;

    public ViewHolder(View root) {
        super(root);
//        tv = itemView;

        tvContent = (TextView) root.findViewById(R.id.tvContent);
        tvTitle = (TextView) root.findViewById(R.id.tvTitle);
    }

    public TextView getTvContent() {
        return tvContent;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }



    //    public TextView getTv() {
//        return tv;
//    }
}
