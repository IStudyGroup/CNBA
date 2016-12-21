package com.hanyu.cnba.precenters;

import android.content.Context;

import com.hanyu.cnba.models.IMatchModel;
import com.hanyu.cnba.models.MatchInfoModel;
import com.hanyu.cnba.models.MatchListModel;
import com.hanyu.cnba.models.MatchListModelImpl;
import com.hanyu.cnba.views.IView;

import java.util.ArrayList;

/**
 * Created by Dell on 2016/12/21.
 */
public class MatchListPresenter implements IPresenter {
    private MatchListModelImpl impl;
    private Context mContext;

    public MatchListPresenter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public void setList() {
        impl = new MatchListModelImpl(mContext);

    }
}
