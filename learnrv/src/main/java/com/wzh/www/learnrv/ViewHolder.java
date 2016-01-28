package com.wzh.www.learnrv;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

/**
 * Created by WWW on 2016/1/28.
 */


public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView tv;

    public ViewHolder(TextView itemView) {
        super(itemView);
        tv = itemView;
    }

    public TextView getTv() {
        return tv;
    }
}
