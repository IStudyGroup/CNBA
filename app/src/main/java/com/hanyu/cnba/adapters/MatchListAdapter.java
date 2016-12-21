package com.hanyu.cnba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hanyu.cnba.R;
import com.hanyu.cnba.models.MatchInfoModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Dell on 2016/12/21.
 */
public class MatchListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    public ArrayList<MatchInfoModel> mDatas = new ArrayList<>();

    public MatchListAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(context);
    }
    public void setDatas(ArrayList<MatchInfoModel> datas) {
        this.mDatas.clear();
        this.mDatas.addAll(datas);
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public MatchInfoModel getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_match, null);
            holder = new Holder();
            holder.imgv_item_game_image_left = (ImageView) convertView.findViewById(R.id.item_game_image_left);
            holder.imgv_item_game_image_right = (ImageView) convertView.findViewById(R.id.item_game_image_right);
            holder.tv_item_game_text_score_left = (TextView) convertView.findViewById(R.id.item_game_text_score_left);
            holder.tv_item_game_text_score_right = (TextView) convertView.findViewById(R.id.item_game_text_score_right);
            holder.tv_item_game_text_left_name = (TextView) convertView.findViewById(R.id.item_game_text_left_name);
            holder.tv_item_game_text_right_name = (TextView) convertView.findViewById(R.id.item_game_text_right_name);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        final MatchInfoModel infoModel = mDatas.get(position);
        holder.tv_item_game_text_score_left.setText(infoModel.leftGoal);
        holder.tv_item_game_text_score_right.setText(infoModel.rightGoal);
        holder.tv_item_game_text_left_name.setText(infoModel.leftName);
        holder.tv_item_game_text_right_name.setText(infoModel.rightName);
        Glide.with(mContext).load(infoModel.leftBadge).into(holder.imgv_item_game_image_left);
        Glide.with(mContext).load(infoModel.rightBadge).into(holder.imgv_item_game_image_right);

        return convertView;
    }

    static class Holder {
        public ImageView imgv_item_game_image_left;
        public ImageView imgv_item_game_image_right;
        public TextView tv_item_game_text_left_name;
        public TextView tv_item_game_text_right_name;
        public TextView tv_item_game_text_score_left;
        public TextView tv_item_game_text_score_right;
    }
}
