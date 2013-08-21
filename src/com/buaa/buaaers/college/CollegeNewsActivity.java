package com.buaa.buaaers.college;

import com.buaa.buaaers.R;
import com.buaa.buaaers.common.BaseActivity;
import com.buaa.buaaers.common.view.CommentItemView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class CollegeNewsActivity extends BaseActivity {

    private LinearLayout mCommentCotainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwitchBar.setVisibility(View.GONE);
        mLeftMenu.setVisibility(View.GONE);
        
        View content = LayoutInflater.from(this).inflate(R.layout.college_news_main, null);
        mContainer.addView(content);
        
        mCommentCotainer = (LinearLayout) content.findViewById(R.id.comment_container);
        populateComments();
    }
    
    private void populateComments() {
        for (int i = 0; i < 3; i ++) {
            mCommentCotainer.addView(new CommentItemView(this));
        }
    }

}
