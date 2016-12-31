package com.hanyu.cnba.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanyu.cnba.R;
import com.hanyu.cnba.adapters.MatchFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2016/12/19.
 */
public class MatchFragment extends BasicFragment {
    View rootView;
    @Bind(R.id.vp_base_frg)
    ViewPager vp_baseFrg;
    private List<MatchChildFragment> list = new ArrayList<>();
    private MatchFragmentAdapter adapter;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        vp_baseFrg.setOffscreenPageLimit(5);
        rootView = inflater.inflate(R.layout.match_base_frg, container, false);
        ButterKnife.bind(this,rootView);
        adapter = new MatchFragmentAdapter(getChildFragmentManager(),list);
        FragmentManager fgmM = getChildFragmentManager() ;
        Fragment mtcFgm = new MatchChildFragment();
        FragmentTransaction ft = fgmM.beginTransaction();
        ft.add(R.id.base_frg, mtcFgm, null);
        ft.commitAllowingStateLoss();

        for(int i = -31 ; i < 32 ; i++){
            MatchChildFragment fragment = new MatchChildFragment();
            fragment.setDay(i);
            list.add(fragment);
        }
        vp_baseFrg.setAdapter(adapter);
        vp_baseFrg.setCurrentItem(31);
        vp_baseFrg.setOffscreenPageLimit(5);

       /* MatchChildFragment fragment1 = new MatchChildFragment();
        fragment1.setDay(-1);
        OtherMatchFragment fragment2 = new OtherMatchFragment();
        fragment2.setDay(1);
        OtherMatchFragment fragment3 = new OtherMatchFragment();
        fragment3.setDay(2);
        // 将要分页显示的View装入数组中
        final List<Fragment> list = new ArrayList<>();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        final MatchFragmentAdapter adapter = new MatchFragmentAdapter(getChildFragmentManager(), list);
        vp_baseFrg.setAdapter(adapter);
        vp_baseFrg.setCurrentItem(2);*/
        return rootView;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }


}
