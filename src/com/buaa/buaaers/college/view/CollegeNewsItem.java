package com.buaa.buaaers.college.view;

import com.buaa.buaaers.common.data.NewsData;

import com.buaa.buaaers.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;

public class CollegeNewsItem implements OnClickListener{
    private View mView;
    
    private Context mContext;
    
    public CollegeNewsItem(Context context) {
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.college_news_item, null);
        LayoutParams layout = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(layout);
        
    }
    
    public View getView() {
        return mView;
    }
    
    public void populate(NewsData data) {
        
    }

    @Override
    public void onClick(View v) {
        
    }
}
