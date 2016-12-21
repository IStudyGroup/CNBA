package com.hanyu.cnba.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanyu.cnba.R;

/**
 * Created by Dell on 2016/12/21.
 */
public class MoreFragment extends BasicFragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.more_frg_layout,container,false);
        return view;
    }
}
