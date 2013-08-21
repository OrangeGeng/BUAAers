package com.buaa.buaaers.college;

import com.buaa.buaaers.college.view.CollegeNewsItem;
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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class CollegeActivity extends BaseActivity implements OnItemClickListener, LeftCornerListener{

    private ListView mListView;
    
    private CustomableListAdapter mAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = new ListView(this);
        mContainer.addView(mListView);
        
        getAdapter();
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        mAdapter.update(getCollegeNewsData());
        mLeftMenu.setListener(this);
    }
    
    private void getAdapter() {
        if (mAdapter == null) {
            mAdapter = new CustomableListAdapter(new Populator() {
                
                @Override
                public View populate(int position, View convertView, ViewGroup parent, Object item) {
                    CollegeNewsItem newsItem = new CollegeNewsItem(CollegeActivity.this);
                    return newsItem.getView();
                }
            });
        }
    }
    
    private ArrayList<NewsData> getCollegeNewsData() {
        ArrayList<NewsData> news = new ArrayList<NewsData>();
        news.add(new NewsData());
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
	
}
