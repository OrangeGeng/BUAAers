package com.buaa.buaaers.college;

import com.buaa.buaaers.college.view.CollegeNewsItem;
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
        mAdapter.update(getCollegeNewsData());
    }
    
    private void getAdapter() {
        if (mAdapter == null) {
            mAdapter = new CustomableListAdapter(new Populator() {
                
                @Override
                public View populate(int position, View convertView, ViewGroup parent, Object item) {
                    CollegeNewsItem newsItem = new CollegeNewsItem(CollegeActivity.this);
                    return newsItem.getView();
//                    return LayoutInflater.from(CollegeActivity.this).inflate(R.layout.college_news_item, null);
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
