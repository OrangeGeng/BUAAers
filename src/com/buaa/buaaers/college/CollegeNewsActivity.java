package com.buaa.buaaers.college;

import com.buaa.buaaers.R;
import com.buaa.buaaers.common.BaseActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class CollegeNewsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwitchBar.setVisibility(View.GONE);
        mLeftMenu.setVisibility(View.GONE);
        
        View content = LayoutInflater.from(this).inflate(R.layout.college_news_main, null);
        mContainer.addView(content);
    }

}
