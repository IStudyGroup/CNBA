package com.hanyu.cnba.activities;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanyu.cnba.R;
import com.hanyu.cnba.fragments.BasicFragment;
import com.hanyu.cnba.fragments.DataFragment;
import com.hanyu.cnba.fragments.LatestFragment;
import com.hanyu.cnba.fragments.MatchFragment;
import com.hanyu.cnba.fragments.MoreFragment;
import com.hanyu.cnba.fragments.VideoFragment;
import com.hanyu.cnba.managers.ActivityManager;
import com.hanyu.cnba.utils.CLog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BasicActivity {
    private int currentFrg ;
    @Bind(R.id.imgv_match)
    ImageView imgv_match;
    @Bind(R.id.tv_match)
    TextView tv_match;
    @Bind(R.id.imgv_latest)
    ImageView imgv_latest;
    @Bind(R.id.tv_latest)
    TextView tv_latest;
    @Bind(R.id.imgv_video)
    ImageView imgv_video;
    @Bind(R.id.tv_video)
    TextView tv_video;
    @Bind(R.id.imgv_data)
    ImageView imgv_data;
    @Bind(R.id.tv_data)
    TextView tv_data;
    @Bind(R.id.imgv_more)
    ImageView imgv_more;
    @Bind(R.id.tv_more)
    TextView tv_more;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        /**设置默认fra**/
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        currentFrg = 1;
        FragmentManager fgmM = getSupportFragmentManager();
        MatchFragment mtcFgm = new MatchFragment();
        FragmentTransaction ft = fgmM.beginTransaction();
        ft.add(R.id.act_frg, mtcFgm, null);
        ft.commitAllowingStateLoss();
        imgv_match.setSelected(true);
        tv_match.setSelected(true);



    }

    @Override
    void initView() {


    }

    @Override
    int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    View getContentView() {
        return null;
    }

    @OnClick({R.id.layout_match, R.id.layout_latest, R.id.layout_video, R.id.layout_data, R.id.layout_more})
    public void onClick(View view) {
        BasicFragment fragment = null;
        int frgId = 1;
        switch (view.getId()){
            case R.id.layout_match:
                 fragment = new MatchFragment();
                 frgId = 1;
                break;
            case R.id.layout_latest:
                fragment = new LatestFragment();
                frgId = 2;
                break;
            case R.id.layout_video:
                fragment = new VideoFragment();
                frgId = 3;
                break;
            case R.id.layout_data:
                fragment = new DataFragment();
                frgId = 4;
                break;
            case R.id.layout_more:
                fragment = new MoreFragment();
                frgId = 5;
                break;
        }
        if(fragment != null) {
            changeFrg(fragment,frgId);
        }

        changeBkg(view.getId());

    }

    private void changeFrg(BasicFragment fragment,int id){
        if(currentFrg != id) {
            FragmentManager fgmM = getSupportFragmentManager();
            FragmentTransaction ft = fgmM.beginTransaction();
            ft.replace(R.id.act_frg, fragment);
            ft.commitAllowingStateLoss();
            currentFrg = id;
            CLog.i("+++++++++++++++++"+id+"+=====================");
        }
    }
    private void changeBkg(int id){
        switch (id) {
            case R.id.layout_match:
                imgv_match.setSelected(true);
                tv_match.setSelected(true);
                imgv_latest.setSelected(false);
                tv_latest.setSelected(false);
                imgv_video.setSelected(false);
                tv_video.setSelected(false);
                imgv_data.setSelected(false);
                tv_data.setSelected(false);
                imgv_more.setSelected(false);
                tv_more.setSelected(false);

                break;
            case R.id.layout_latest:
                imgv_match.setSelected(false);
                tv_match.setSelected(false);
                imgv_latest.setSelected(true);
                tv_latest.setSelected(true);
                imgv_video.setSelected(false);
                tv_video.setSelected(false);
                imgv_data.setSelected(false);
                tv_data.setSelected(false);
                imgv_more.setSelected(false);
                tv_more.setSelected(false);

                break;
            case R.id.layout_video:
                imgv_match.setSelected(false);
                tv_match.setSelected(false);
                imgv_latest.setSelected(false);
                tv_latest.setSelected(false);
                imgv_video.setSelected(true);
                tv_video.setSelected(true);
                imgv_data.setSelected(false);
                tv_data.setSelected(false);
                imgv_more.setSelected(false);
                tv_more.setSelected(false);
                break;
            case R.id.layout_data:
                imgv_match.setSelected(false);
                tv_match.setSelected(false);
                imgv_latest.setSelected(false);
                tv_latest.setSelected(false);
                imgv_video.setSelected(false);
                tv_video.setSelected(false);
                imgv_data.setSelected(true);
                tv_data.setSelected(true);
                imgv_more.setSelected(false);
                tv_more.setSelected(false);
                break;
            case R.id.layout_more:
                imgv_match.setSelected(false);
                tv_match.setSelected(false);
                imgv_latest.setSelected(false);
                tv_latest.setSelected(false);
                imgv_video.setSelected(false);
                tv_video.setSelected(false);
                imgv_data.setSelected(false);
                tv_data.setSelected(false);
                imgv_more.setSelected(true);
                tv_more.setSelected(true);
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityManager.finishAll();
    }
}
