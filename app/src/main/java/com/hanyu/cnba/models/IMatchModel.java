package com.hanyu.cnba.models;

import android.content.Context;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Dell on 2016/12/19.
 */
public interface IMatchModel {
    MatchListModel getMatchInfo(LinkedHashMap<String,String> map);

}
