/**
 * 
 */
package com.buaa.buaaers.buaaclass;

import com.buaa.buaaers.R;
import com.buaa.buaaers.college.CollegeActivity;
import com.buaa.buaaers.college.CollegeNewsActivity;
import com.buaa.buaaers.college.view.CollegeNewsItem;
import com.buaa.buaaers.college.view.ShiMeiItem;
import com.buaa.buaaers.common.BaseActivity;
import com.buaa.buaaers.common.data.NewsData;
import com.buaa.buaaers.common.view.CustomableListAdapter;
import com.buaa.buaaers.common.view.LeftCornerListener;
import com.buaa.buaaers.common.view.LeftCornerView;
import com.buaa.buaaers.common.view.Populator;
import com.buaa.buaaers.me.MeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

/**
 * @author gordongeng
 *
 */
public class ClassActivity extends BaseActivity implements OnItemClickListener, LeftCornerListener{


    private ListView mListView;
    
    private CustomableListAdapter mGongGaoAdapter, mBanHuiAdapter;
    
    private ImageView mSwitchBwggButton, mSwitchZxbhButton;
    
    /**
     * 是否在在线班会界面
     */
    private boolean mIsBanHui = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = new ListView(this);
        mContainer.addView(mListView);
        
        mListView.setAdapter(getGongGaoAdapter());
        mListView.setOnItemClickListener(this);
        mGongGaoAdapter.update(getCollegeNewsData());
        
        mLeftMenu.setCenterImage(R.drawable.leftcorner_center_class);
        mLeftMenu.setTopImage(R.drawable.leftcorner_college);
        mLeftMenu.setRightImage(R.drawable.leftcorner_me);
        mLeftMenu.setListener(this);
        
        mSwitchBwggButton = (ImageView)mSwitchBar.findViewById(R.id.iv1);
        mSwitchZxbhButton = (ImageView)mSwitchBar.findViewById(R.id.iv2);
        mSwitchBwggButton.setOnClickListener(this);
        mSwitchZxbhButton.setOnClickListener(this);
        
        mSwitchBwggButton.setImageResource(R.drawable.navbar_pushedbwgg);
        mSwitchZxbhButton.setImageResource(R.drawable.navbar_zxbh);
        
        mIsBanHui = false;
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
                    CollegeNewsItem newsItem = new CollegeNewsItem(ClassActivity.this);
                    return newsItem.getView();
                }
            });
        }
        return mGongGaoAdapter;
    }
    
    /**
     * 获取班务公告数据
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
     * 获取在线班会adapter
     * @return
     */
    private CustomableListAdapter getShiMeiAdapter() {
        if (mBanHuiAdapter == null) {
            mBanHuiAdapter = new CustomableListAdapter(new Populator() {
                
                @Override
                public View populate(int position, View convertView, ViewGroup parent, Object item) {
                    ShiMeiItem newsItem = new ShiMeiItem(ClassActivity.this);
                    return newsItem.getView();
                }
            });
        }
        return mBanHuiAdapter;
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
    public void onLeftCornerClickImage(int index) {
        if (index == LeftCornerView.TOP_IMAGE_INDEX) {
            Log.d("gordongeng", "click the top image");
            Intent meIntent = new Intent(this, CollegeActivity.class);
            startActivity(meIntent);
            onDestroy();
            finish();
        } else if (index == LeftCornerView.RIGHT_IMAGE_INDEX) {
            Log.d("gordongeng", "click the right image");
            Intent meIntent = new Intent(this, MeActivity.class);
            startActivity(meIntent);
            onDestroy();
            finish();
        }
    }

    @Override
    public void onLeftCornerAnimChaged(boolean isGoOut) {
        mLeftMenu.setCenterImage(isGoOut ? R.drawable.leftcorner_center_class_pressed : R.drawable.leftcorner_class);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == mSwitchZxbhButton) {
            Log.d("gordongeng", "click the shi xiong shi mei");
            switchContent(false);
        } else if (v == mSwitchBwggButton) {
            Log.d("gordongeng", "click the yuan wu gong gao");
            switchContent(true);
        }
    }
    
    private void switchContent(boolean goGongGao) {
        if (goGongGao) {
            if (!mIsBanHui) return;
            mSwitchBwggButton.setImageResource(R.drawable.navbar_pushedbwgg);
            mSwitchZxbhButton.setImageResource(R.drawable.navbar_zxbh);
            mListView.setAdapter(getGongGaoAdapter());
            mGongGaoAdapter.update(getCollegeNewsData());
            mIsBanHui = false;
        } else {
            if (mIsBanHui) return;
            mSwitchBwggButton.setImageResource(R.drawable.navbar_bwgg);
            mSwitchZxbhButton.setImageResource(R.drawable.navbar_pushedzxbh);
            mListView.setAdapter(getShiMeiAdapter());
            mBanHuiAdapter.update(getShiMeiData());
            mIsBanHui = true;
        }
    }
    
}
