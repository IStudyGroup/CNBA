package com.hanyu.cnba.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Dell on 2016/12/19.
 */
public class NewsDataModel {
    public String title;
    @SerializedName("abstract")
    public String abstractNews;
    public ArrayList<ContentModel> content;
    public String url;
    public String imgurl;
    public String imgurl1;
    public String imgurl2;
    public String atype;
    public String commentId;
    public String newsAppId;
    public String source;
    public String commentsNum;
    public String upNum;
    public String pub_time_new;
    public String isCollect;




}

