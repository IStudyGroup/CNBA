package com.hanyu.cnba.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hanyu.cnba.fragments.BasicFragment;
import com.hanyu.cnba.fragments.MatchChildFragment;

import java.util.List;

/**
 * Created by Dell on 2016/12/23.
 */
public class MatchFragmentAdapter extends FragmentPagerAdapter {

        List<MatchChildFragment> list;


        public MatchFragmentAdapter(FragmentManager fm, List<MatchChildFragment> list) {
            super(fm);
            this.list=list;
        }


        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }//根据Item的位置返回对应位置的Fragment，绑定item和Fragment

        @Override
        public int getCount() {
            return list.size();
        }//设置Item的数量

}

