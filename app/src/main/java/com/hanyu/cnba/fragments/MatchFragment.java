package com.hanyu.cnba.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.hanyu.cnba.R;
import com.hanyu.cnba.adapters.MatchListAdapter;
import com.hanyu.cnba.managers.NetManager;
import com.hanyu.cnba.models.MatchInfoModel;
import com.hanyu.cnba.models.MatchListModel;
import com.hanyu.cnba.models.MatchModel;
import com.hanyu.cnba.precenters.IMatchListPresenter;
import com.hanyu.cnba.precenters.MatchListPresenter;
import com.hanyu.cnba.utils.API;
import com.hanyu.cnba.utils.CLog;
import com.hanyu.cnba.utils.Date;
import com.hanyu.cnba.utils.Util;
import com.hanyu.cnba.views.IMatchListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2016/12/19.
 */
public class MatchFragment extends BasicFragment implements IMatchListView {
    private ArrayList<MatchInfoModel> datas = new ArrayList<>();
    private MatchListAdapter matchListAdapter;
    private ListView lv_match;
    private IMatchListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.match_frg_layout, container, false);
        getData();
        matchListAdapter = new MatchListAdapter(getActivity().getApplicationContext());
        lv_match = (ListView) view.findViewById(R.id.lv_match);
        lv_match.setAdapter(matchListAdapter);
        //lv_match.setAdapter();
        return view;
    }

    public void getData() {
        presenter = new MatchListPresenter(getActivity().getApplicationContext(), this);
        String date = new Date().getDate();
        presenter.getData(date);
    }

    @Override
    public void setViewData(MatchListModel data) {
        if (data != null && data.data != null && data.data.matches != null) {
            int size = data.data.matches.size();
            for (int i = 0; i < size; i++) {
                datas.add(data.data.matches.get(i).matchInfo);
                matchListAdapter.setDatas(datas);
                matchListAdapter.notifyDataSetChanged();
            }
        } else {
            // 网络获取失败，提示
            Util.toastTips(getActivity().getApplicationContext(),"请求数据失败");
        }
    }
}
