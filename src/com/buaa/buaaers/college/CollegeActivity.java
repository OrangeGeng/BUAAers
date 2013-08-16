package com.buaa.buaaers.college;

import com.buaa.buaaers.common.BaseActivity;
import com.buaa.buaaers.common.data.NewsData;
import com.buaa.buaaers.common.view.CustomableListAdapter;
import com.buaa.buaaers.common.view.Populator;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class CollegeActivity extends BaseActivity {

    private ListView mListView;
    
    private CustomableListAdapter mAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = new ListView(this);
        mContainer.addView(mListView);
        
        getAdapter();
        mListView.setAdapter(mAdapter);
    }
    
    private void getAdapter() {
        if (mAdapter == null) {
            mAdapter = new CustomableListAdapter(new Populator() {
                
                @Override
                public View populate(int position, View convertView, ViewGroup parent, Object item) {
                    return null;
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
	
}
