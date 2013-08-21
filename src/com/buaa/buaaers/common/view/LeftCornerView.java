package com.buaa.buaaers.common.view;

import com.buaa.buaaers.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class LeftCornerView extends FrameLayout implements OnClickListener{
    
    public static final int RIGHT_IMAGE_INDEX = 1;
    public static final int TOP_IMAGE_INDEX = 2;
    
    public static final int ANIM_TRANS_DIS = 120;

	ImageView mRightImage, mTopImage, mCenterImage;// musicImage ,placeImage,sleepImage,thoughtImage,
	
	boolean sign = false;
	
	static final int animationTime = 100;
	
	private LeftCornerListener mListener;
	
	public LeftCornerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		View view = View.inflate(context, R.layout.left_corner_view, this);
		mRightImage = (ImageView)view.findViewById(R.id.right_image);                       
        mTopImage = (ImageView)view.findViewById(R.id.top_image);        
        mCenterImage = (ImageView)view.findViewById(R.id.myplus);
        
        mRightImage.setOnClickListener(this);
        mTopImage.setOnClickListener(this);
	}
	
	public void myanimation(){
    	
    	showRotateAnimation(sign);
    	if (mListener != null) {
    	    mListener.onAnimChaged(!sign);
    	}
    	if(!sign){
    	    sign = true;
    	    outAnimation();
    	}else{
    		sign = false;
    		inAnimation();
    	}
    	
    }
	
    public void outAnimation(){
    	TranslateAnimation translateAnimation = new TranslateAnimation(0, ANIM_TRANS_DIS, 0, 0);
 	    translateAnimation.setInterpolator(new OvershootInterpolator());
 	    translateAnimation.setDuration(animationTime * 1); 
 	    translateAnimation.setFillAfter(true);
 	    translateAnimation.setAnimationListener(new AnimationListener() {
           
           @Override
           public void onAnimationStart(Animation animation) {
               
           }
           
           @Override
           public void onAnimationRepeat(Animation animation) {
               
           }
           
           @Override
           public void onAnimationEnd(Animation animation) {
               int top = mRightImage.getTop();
               int left = mRightImage.getLeft();
               int width = mRightImage.getWidth();
               int height = mRightImage.getHeight();
               mRightImage.clearAnimation();
               mRightImage.layout(left + ANIM_TRANS_DIS, top, left + width + ANIM_TRANS_DIS, top + height);
           }
        });
 	    mRightImage.startAnimation(translateAnimation); 
 	    
 	    
// 	    TranslateAnimation translateAnimation1 = new TranslateAnimation(0,190, 0, -60);
// 	    translateAnimation1.setInterpolator(new OvershootInterpolator());
// 	    translateAnimation1.setDuration(animationTime * 1+180); 
// 	    translateAnimation1.setStartOffset(20);
// 	    translateAnimation1.setFillAfter(true); 
// 	    musicImage.startAnimation(translateAnimation1); 
// 	    
// 	    
// 	    TranslateAnimation translateAnimation2 = new TranslateAnimation(0,170, 0, -120);
// 	    translateAnimation2.setInterpolator(new OvershootInterpolator());
// 	    translateAnimation2.setDuration(animationTime * 1+120); 
// 	    translateAnimation2.setStartOffset(40);
// 	    translateAnimation2.setFillAfter(true); 
// 	    placeImage.startAnimation(translateAnimation2);
// 	    
// 	    TranslateAnimation translateAnimation3 = new TranslateAnimation(0,120, 0, -165);
// 	    translateAnimation3.setInterpolator(new OvershootInterpolator());
// 	    translateAnimation3.setDuration(animationTime * 1+80); 
// 	    translateAnimation3.setStartOffset(60);
// 	    translateAnimation3.setFillAfter(true); 
// 	    sleepImage.startAnimation(translateAnimation3);
// 	    
// 	    TranslateAnimation translateAnimation4 = new TranslateAnimation(0,60, 0, -190);
// 	    translateAnimation4.setInterpolator(new OvershootInterpolator());
// 	    translateAnimation4.setDuration(animationTime * 1+40); 
// 	    translateAnimation4.setStartOffset(80);
// 	    translateAnimation4.setFillAfter(true); 
// 	    thoughtImage.startAnimation(translateAnimation4);
 	    
 	    TranslateAnimation translateAnimation5 = new TranslateAnimation(0, 0, 0, -1*ANIM_TRANS_DIS);
 	    translateAnimation5.setInterpolator(new OvershootInterpolator());
 	    translateAnimation5.setDuration(animationTime * 1); 
 	    translateAnimation5.setStartOffset(40);
 	    translateAnimation5.setFillAfter(true);
 	    translateAnimation5.setAnimationListener(new AnimationListener() {
           
           @Override
           public void onAnimationStart(Animation animation) {
               
           }
           
           @Override
           public void onAnimationRepeat(Animation animation) {
               
           }
           
           @Override
           public void onAnimationEnd(Animation animation) {
               int top = mTopImage.getTop();
               int left = mTopImage.getLeft();
               int width = mTopImage.getWidth();
               int height = mTopImage.getHeight();
               mTopImage.clearAnimation();
               mTopImage.layout(left, top - ANIM_TRANS_DIS, left + width, top + height - ANIM_TRANS_DIS);
           }
        });
 	    mTopImage.startAnimation(translateAnimation5);
    }
    
    public void inAnimation(){
    	TranslateAnimation translateAnimation = new TranslateAnimation(ANIM_TRANS_DIS, 0, 0, 0);
 	   
 	    translateAnimation.setDuration(animationTime * 10); 
 	    translateAnimation.setFillAfter(true);
 	    translateAnimation.setAnimationListener(new AnimationListener() {
            
            @Override
            public void onAnimationStart(Animation animation) {
                
            }
            
            @Override
            public void onAnimationRepeat(Animation animation) {
                
            }
            
            @Override
            public void onAnimationEnd(Animation animation) {
                int top = mRightImage.getTop();
                int left = mRightImage.getLeft();
                int width = mRightImage.getWidth();
                int height = mRightImage.getHeight();
                mRightImage.clearAnimation();
                mRightImage.layout(left - ANIM_TRANS_DIS, top, left + width - ANIM_TRANS_DIS, top + height);
            }
        });
 	    mRightImage.startAnimation(translateAnimation); 
 	    
 	    
// 	    TranslateAnimation translateAnimation1 = new TranslateAnimation(190,0,-60, 0);
// 	   
// 	    translateAnimation1.setDuration(animationTime * 1); 
// 	    translateAnimation1.setStartOffset(30);
// 	    translateAnimation1.setFillAfter(true); 
// 	    musicImage.startAnimation(translateAnimation1); 
// 	    
// 	    
// 	    TranslateAnimation translateAnimation2 = new TranslateAnimation(170,0,-120, 0);
//// 	    translateAnimation2.setInterpolator(new OvershootInterpolator());
// 	    translateAnimation2.setDuration(animationTime * 1); 
// 	    translateAnimation2.setStartOffset(60);
// 	    translateAnimation2.setFillAfter(true); 
// 	    placeImage.startAnimation(translateAnimation2);
// 	    
// 	    TranslateAnimation translateAnimation3 = new TranslateAnimation(120,0,-165, 0);
//// 	    translateAnimation3.setInterpolator(new OvershootInterpolator());
// 	    translateAnimation3.setDuration(animationTime * 1); 
// 	    translateAnimation3.setStartOffset(90);
// 	    translateAnimation3.setFillAfter(true); 
// 	    sleepImage.startAnimation(translateAnimation3);
// 	    
// 	    TranslateAnimation translateAnimation4 = new TranslateAnimation(60,0, -190, 0);
//// 	    translateAnimation4.setInterpolator(new OvershootInterpolator());
// 	    translateAnimation4.setDuration(animationTime * 1); 
// 	    translateAnimation4.setStartOffset(120);
// 	    translateAnimation4.setFillAfter(true); 
// 	    thoughtImage.startAnimation(translateAnimation4);
 	    
 	    TranslateAnimation translateAnimation5 = new TranslateAnimation(0, 0, - ANIM_TRANS_DIS, 0);
// 	    translateAnimation5.setInterpolator(new OvershootInterpolator());
 	    translateAnimation5.setDuration(animationTime * 10);
 	    translateAnimation5.setStartOffset(40);
 	    translateAnimation5.setFillAfter(true);
 	    translateAnimation5.setAnimationListener(new AnimationListener() {
           
           @Override
           public void onAnimationStart(Animation animation) {
               
           }
           
           @Override
           public void onAnimationRepeat(Animation animation) {
               
           }
           
           @Override
           public void onAnimationEnd(Animation animation) {
               int top = mTopImage.getTop();
               int left = mTopImage.getLeft();
               int width = mTopImage.getWidth();
               int height = mTopImage.getHeight();
               mTopImage.clearAnimation();
               mTopImage.layout(left, top + ANIM_TRANS_DIS, left + width, top + height + ANIM_TRANS_DIS);
           }
        });
 	    mTopImage.startAnimation(translateAnimation5);
    }
    
    
    public void showRotateAnimation(boolean sign) {           	
        final float centerX = mCenterImage.getWidth() / 2.0f; 
        final float centerY = mCenterImage.getHeight() / 2.0f;
        RotateAnimation rotateAnimation = null; 
        if(!sign){
        	  rotateAnimation = new RotateAnimation(0, 360, centerX, 
                      centerY);               
        }else{
        	 rotateAnimation = new RotateAnimation(360, 0, centerX, 
                     centerY); 
        }
        rotateAnimation.setDuration(animationTime + 120); 
        rotateAnimation.setFillAfter(true); 
        mCenterImage.startAnimation(rotateAnimation); 
    }
    
    public void setListener(LeftCornerListener listener) {
        mListener = listener;
    }
    
    public void setTopImage(int topId) {
        mTopImage.setImageResource(topId);
    }
    
    public void setRightImage(int rightId) {
        mRightImage.setImageResource(rightId);
    }
    
    public void setCenterImage(int centerId) {
        mCenterImage.setImageResource(centerId);
    }

    @Override
    public void onClick(View v) {
        if (mListener == null)
            return;
        if (v == mRightImage) {
            mListener.onClickImage(RIGHT_IMAGE_INDEX);
        } else if (v == mTopImage) {
            mListener.onClickImage(TOP_IMAGE_INDEX);
        }
    }
    
}
