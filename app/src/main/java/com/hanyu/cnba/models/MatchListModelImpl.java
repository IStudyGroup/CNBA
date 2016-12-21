package com.hanyu.cnba.models;

import android.content.Context;

import com.android.volley.VolleyError;
import com.hanyu.cnba.managers.NetManager;
import com.hanyu.cnba.utils.API;
import com.hanyu.cnba.utils.Date;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Dell on 2016/12/21.
 */
public class MatchListModelImpl implements IMatchModel {
    private Context mContext;
    MatchListModel listModel = null;


    public MatchListModelImpl(Context context){
        mContext =  context;
    }

    @Override
    public MatchListModel getMatchInfo(LinkedHashMap <String,String> map){
        NetManager.doHttpGet(mContext, null, API.BASE_GET_MATCH_LIST, map, MatchListModel.class, new NetManager.ResponseListener<MatchListModel>() {
            @Override
            public void onResponse(MatchListModel response) {
                if (response != null) {
                    listModel = response;
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onAsyncResponse(MatchListModel response) {

            }
        });
        return listModel;
    }

}
