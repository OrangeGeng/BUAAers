package com.buaa.buaaers.college;

import com.buaa.buaaers.R;
import com.buaa.buaaers.common.BaseSimpleActivity;
import com.buaa.buaaers.common.view.CommentItemView;
import com.buaa.buaaers.common.view.RightCornerListener;
import com.buaa.buaaers.common.view.RightCornerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

public class CollegeNewsActivity extends BaseSimpleActivity implements RightCornerListener{

    private LinearLayout mCommentCotainer;
    
    private boolean mIsLikeThisNews = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRightBtn.setVisibility(View.GONE);
        mTitle.setVisibility(View.GONE);
        
        mReleaseCommentBtn.setOnClickListener(this);
        
        View content = LayoutInflater.from(this).inflate(R.layout.college_news_main, null);
        mContainer.addView(content);
        
        mCommentCotainer = (LinearLayout) content.findViewById(R.id.comment_container);
        populateComments();
        
        populateRightCorner();
    }
    
    private void populateComments() {
        for (int i = 0; i < 3; i ++) {
            mCommentCotainer.addView(new CommentItemView(this));
        }
    }
    
    private void populateRightCorner() {
        mRightCornerMenu.setVisibility(View.VISIBLE);
        mRightCornerMenu.setListener(this);
        mRightCornerMenu.setCenterImage(R.drawable.rightcorner_center_centerbutton);
        mRightCornerMenu.setTopImage(R.drawable.rightcorner_side_replybutton);
        
        mIsLikeThisNews = getIsLikeThisNews();
        if (mIsLikeThisNews) {
            mRightCornerMenu.setLeftImage(R.drawable.rightcorner_side_pushedlikebutton);
        } else {
            mRightCornerMenu.setLeftImage(R.drawable.rightcorner_side_likebutton);
        }
    }
    
//    private void buildHandler() {
//        mHandler = new Handler() {
//
//            @Override
//            public void handleMessage(Message msg) {
//                switch (msg.what) {
//                    case MessageFactory.MESSAGE_CHANG_LIKEICON:
//                        mRightCornerMenu.setShowImageView();
//                        if (mIsLikeThisNews) {
//                            mRightCornerMenu.setLeftImage(R.drawable.rightcorner_side_pushedlikebutton);
//                        } else {
//                            mRightCornerMenu.setLeftImage(R.drawable.rightcorner_side_likebutton);
//                        }
//                        
//                        break;
//                }
//            }
//            
//        };
//    }

    @Override
    public void onRightCornerClickImage(int index) {
        if (index == RightCornerView.TOP_IMAGE_INDEX) {
            // 评论
            mReleaseCommentContainer.setVisibility(View.VISIBLE);
            mReleaseCommentInput.requestFocus();
            showOrHideInput(true);
            mRightCornerMenu.setVisibility(View.INVISIBLE);
            mRightCornerMenu.inAnimation();
            mRightCornerMenu.sign = false;
            mRightCornerMenu.setCenterImage(R.drawable.rightcorner_center_centerbutton);
            
        } else if (index == RightCornerView.RIGHT_IMAGE_INDEX) {
            // 喜欢本帖
            mIsLikeThisNews = !mIsLikeThisNews;
            //mHandler.sendEmptyMessage(MessageFactory.MESSAGE_CHANG_LIKEICON);
            mRightCornerMenu.inAnimation();
            mRightCornerMenu.sign = false;
            mRightCornerMenu.setCenterImage(R.drawable.rightcorner_center_centerbutton);
            //mRightCornerMenu.requestLayout();
        }
    }

    @Override
    public void onRightCornerAnimChaged(boolean isGoOut) {
        mRightCornerMenu.setCenterImage(isGoOut ? R.drawable.rightcorner_center_pushedcenterbutton : R.drawable.rightcorner_center_centerbutton);
    }
    
    /**
     * 是否喜欢这个帖子 or 新闻
     * @return
     */
    private boolean getIsLikeThisNews() {
        return false;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == mReleaseCommentBtn) {
            mReleaseCommentContainer.setVisibility(View.GONE);
            showOrHideInput(false);
            mRightCornerMenu.setVisibility(View.VISIBLE);
        }
    }
    
    /**
     * 收起或展开软键盘
     * @param isOpen
     */
    private void showOrHideInput(boolean isOpen) {
        InputMethodManager input;
        input = (InputMethodManager)CollegeNewsActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (isOpen) {
            input.showSoftInput(mReleaseCommentInput, InputMethodManager.SHOW_IMPLICIT);
        } else {
            input.hideSoftInputFromWindow(mReleaseCommentInput.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    
}
