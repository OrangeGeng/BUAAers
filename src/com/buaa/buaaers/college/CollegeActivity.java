package com.buaa.buaaers.college;

import com.buaa.buaaers.college.view.CollegeNewsItem;
import com.buaa.buaaers.college.view.ShiMeiItem;
import com.buaa.buaaers.common.BaseActivity;
import com.buaa.buaaers.common.data.NewsData;
import com.buaa.buaaers.common.view.CustomableListAdapter;
import com.buaa.buaaers.common.view.LeftCornerListener;
import com.buaa.buaaers.common.view.LeftCornerView;
import com.buaa.buaaers.common.view.Populator;

import com.buaa.buaaers.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class CollegeActivity extends BaseActivity implements OnItemClickListener, LeftCornerListener, OnClickListener{

    private ListView mListView;
    
    private CustomableListAdapter mGongGaoAdapter, mShiMeiAdapter;
    
    private ImageView mSwitchYwggButton, mSwitchSxsmButton;
    
    /**
     * 是否在师兄师妹界面
     */
    private boolean mIsShiMei = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = new ListView(this);
        mContainer.addView(mListView);
        
        mListView.setAdapter(getGongGaoAdapter());
        mListView.setOnItemClickListener(this);
        mGongGaoAdapter.update(getCollegeNewsData());
        mLeftMenu.setListener(this);
        
        mSwitchYwggButton = (ImageView)mSwitchBar.findViewById(R.id.iv1);
        mSwitchSxsmButton = (ImageView)mSwitchBar.findViewById(R.id.iv2);
        mSwitchYwggButton.setOnClickListener(this);
        mSwitchSxsmButton.setOnClickListener(this);
        
        mIsShiMei = false;
    }
    
    /**
     * 获取院务公告adapter
     * @return
     */
    private CustomableListAdapter getGongGaoAdapter() {
        if (mGongGaoAdapter == null) {
            mGongGaoAdapter = new CustomableListAdapter(new Populator() {
                
                @Override
                public View populate(int position, View convertView, ViewGroup parent, Object item) {
                    CollegeNewsItem newsItem = new CollegeNewsItem(CollegeActivity.this);
                    return newsItem.getView();
                }
            });
        }
        return mGongGaoAdapter;
    }
    
    /**
     * 获取院务公告数据
     * @return
     */
    private ArrayList<NewsData> getCollegeNewsData() {
        ArrayList<NewsData> news = new ArrayList<NewsData>();
        news.add(new NewsData());
        news.add(new NewsData());
        news.add(new NewsData());
        return news;
    }
    
    /**
     * 获取师兄师妹adapter
     * @return
     */
    private CustomableListAdapter getShiMeiAdapter() {
        if (mShiMeiAdapter == null) {
            mShiMeiAdapter = new CustomableListAdapter(new Populator() {
                
                @Override
                public View populate(int position, View convertView, ViewGroup parent, Object item) {
                    ShiMeiItem newsItem = new ShiMeiItem(CollegeActivity.this);
                    return newsItem.getView();
                }
            });
        }
        return mShiMeiAdapter;
    }
    
    private ArrayList<NewsData> getShiMeiData() {
        ArrayList<NewsData> news = new ArrayList<NewsData>();
        news.add(new NewsData());
        news.add(new NewsData());
        return news;
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Intent intent = new Intent(this, CollegeNewsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClickImage(int index) {
        if (index == LeftCornerView.TOP_IMAGE_INDEX) {
            Log.d("gordongeng", "click the top image");
        } else if (index == LeftCornerView.RIGHT_IMAGE_INDEX) {
            Log.d("gordongeng", "click the right image");
        }
    }

    @Override
    public void onAnimChaged(boolean isGoOut) {
        mLeftMenu.setCenterImage(isGoOut ? R.drawable.ywgg_center_button_yuan_pressed : R.drawable.ywgg_center_button_yuan);
    }

    @Override
    public void onClick(View v) {
        if (v == mSwitchSxsmButton) {
            Log.d("gordongeng", "click the shi xiong shi mei");
            switchContent(false);
        } else if (v == mSwitchYwggButton) {
            Log.d("gordongeng", "click the yuan wu gong gao");
            switchContent(true);
        }
    }
    
    private void switchContent(boolean goGongGao) {
        if (goGongGao) {
            if (!mIsShiMei) return;
            mListView.setAdapter(getGongGaoAdapter());
            mGongGaoAdapter.update(getCollegeNewsData());
            mIsShiMei = false;
        } else {
            if (mIsShiMei) return;
            mListView.setAdapter(getShiMeiAdapter());
            mShiMeiAdapter.update(getShiMeiData());
            mIsShiMei = true;
        }
    }
	
}
