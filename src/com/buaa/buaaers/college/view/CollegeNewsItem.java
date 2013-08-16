package com.buaa.buaaers.college.view;

import com.buaa.buaaers.common.data.NewsData;

import com.buaa.buaaers.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class CollegeNewsItem {
    private View mView;
    
    private Context mContext;
    
    public CollegeNewsItem(Context context) {
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.college_news_item, null);
    }
    
    public View getView() {
        return mView;
    }
    
    public void populate(NewsData data) {
        
    }
}
