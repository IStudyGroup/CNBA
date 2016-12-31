package com.hanyu.cnba.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.hanyu.cnba.R;
import com.hanyu.cnba.adapters.MatchListAdapter;
import com.hanyu.cnba.models.MatchInfoModel;
import com.hanyu.cnba.models.MatchListModel;
import com.hanyu.cnba.precenters.IMatchListPresenter;
import com.hanyu.cnba.precenters.MatchListPresenter;
import com.hanyu.cnba.utils.Date;
import com.hanyu.cnba.utils.Util;
import com.hanyu.cnba.views.IMatchListView;

import java.util.ArrayList;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Dell on 2016/12/23.
 */
public class OtherMatchFragment extends Fragment implements IMatchListView {
    private ArrayList<MatchInfoModel> datas = new ArrayList<>();
    private MatchListAdapter matchListAdapter ;
    private ListView lv_match;
    private IMatchListPresenter presenter ;
    private TextView tv_tip;
    private int day;
    private String date ;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.match_frg_layout, container, false);
        getData();
        matchListAdapter = new MatchListAdapter(getActivity().getApplicationContext());
        lv_match = (ListView) view.findViewById(R.id.lv_match);
        tv_tip = (TextView) view.findViewById(R.id.match_day);
        lv_match.setAdapter(matchListAdapter);
        return view;
    }

    public void setDay(int day){
        this.day = day;
    }
    public void getData() {
        presenter = new MatchListPresenter(getActivity().getApplicationContext(), this);
        date = new Date().getDate(day);
        presenter.getData(date,1);
    }
    @Override
    public void setViewData(MatchListModel data,int source) {
        if (data != null && data.data != null && data.data.matches != null) {
            if (data.data.matches.size() == 0){
                tv_tip.setText(date + getString(R.string.no_match));
            }else {
                tv_tip.setText(date);
                int size = data.data.matches.size();
                for (int i = 0; i < size; i++) {
                    datas.add(data.data.matches.get(i).matchInfo);
                    matchListAdapter.setDatas(datas);
                    matchListAdapter.notifyDataSetChanged();
                }
            }

        } else {
            Util.toastTips(getActivity().getApplicationContext(), "请求数据失败");
        }
    }
}
