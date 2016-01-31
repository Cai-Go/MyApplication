package com.example.mydesigntest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by WWW on 2016/1/31.
 */
public class myFragment extends Fragment {
    String mTitle;
    View view;
    public myFragment(String title){
        mTitle = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view  =inflater.inflate(R.layout.fm_my,container,false);
        TextView txt = (TextView) view.findViewById(R.id.txt);
        txt.setText(mTitle);
        return view;
    }
}
