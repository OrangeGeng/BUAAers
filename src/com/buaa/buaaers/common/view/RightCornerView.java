/**
 * 
 */
package com.buaa.buaaers.common.view;

import java.util.ArrayList;

import com.buaa.buaaers.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * @author Gavin
 *
 */
public class RightCornerView extends FrameLayout implements OnClickListener{

    
    public static final int RIGHT_IMAGE_INDEX = 1;
    public static final int TOP_IMAGE_INDEX = 2;
    public static final int THIRD_IMAGE_INDEX = 3;
    public static final int FORTH_IMAGE_INDEX = 4;
    
    public static final int ANIM_TRANS_DIS = 120;

	ImageView mLeftImage, mTopImage, mCenterImage;// musicImage ,placeImage,sleepImage,thoughtImage,
	
	ArrayList<ImageView> mImages;
	
	boolean sign = false;
	
	static final int animationTime = 100;
	
	private RightCornerListener mListener;
	
	/**
	 * 中间按钮的个数
	 */
	private int mMiddleNum = 0;
	
	public RightCornerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mImages = new ArrayList<ImageView>();
		View view = View.inflate(context, R.layout.right_corner_view, this);
		mLeftImage = (ImageView)view.findViewById(R.id.left_image);                       
        mTopImage = (ImageView)view.findViewById(R.id.top_image);        
        mCenterImage = (ImageView)view.findViewById(R.id.myplus);
        mImages.add((ImageView)view.findViewById(R.id.image1));
        mImages.add((ImageView)view.findViewById(R.id.image2));
        
        mLeftImage.setOnClickListener(this);
        mTopImage.setOnClickListener(this);
        mCenterImage.setOnClickListener(this);
	}
	
	/**
	 * 设置中间按钮个数
	 * @param num
	 */
    public void setMiddleNum(int num) {
        if (num >= 0 && num < 3) {
            mMiddleNum = num;
        } else {
            return;
        }

        for (int i = 0; i < 2 - num; i++) {
            mImages.get(1 - i).setVisibility(View.GONE);
        }
    }
	
	private void myanimation(){
    	
    	//showRotateAnimation(sign);
    	if (mListener != null) {
    	    mListener.onRightCornerAnimChaged(!sign);
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
    	TranslateAnimation translateAnimation = new TranslateAnimation(0, - ANIM_TRANS_DIS, 0, 0);
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
               int top = mLeftImage.getTop();
               int left = mLeftImage.getLeft();
               int width = mLeftImage.getWidth();
               int height = mLeftImage.getHeight();
               mLeftImage.clearAnimation();
               mLeftImage.layout(left - ANIM_TRANS_DIS, top, left + width - ANIM_TRANS_DIS, top + height);
           }
        });
 	    mLeftImage.startAnimation(translateAnimation); 
 	    
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
 	   
 	    if (mMiddleNum == 0) return;
        final int detX, detY;
        if (mMiddleNum == 1) {
            detX = (int)(0.7071f * ANIM_TRANS_DIS);
            detY = (int)(0.7071f * ANIM_TRANS_DIS);
        } else {
            detX = (int)(0.866f * ANIM_TRANS_DIS);
            detY = (int)(0.5f * ANIM_TRANS_DIS);
        }
        
        TranslateAnimation translateAnimation1 = new TranslateAnimation(0, - detX, 0, - detY);
        translateAnimation1.setInterpolator(new OvershootInterpolator());
        translateAnimation1.setDuration(animationTime * 1); 
        translateAnimation1.setFillAfter(true);
        translateAnimation1.setAnimationListener(new AnimationListener() {
           
           @Override
           public void onAnimationStart(Animation animation) {
               
           }
           
           @Override
           public void onAnimationRepeat(Animation animation) {
               
           }
           
           @Override
           public void onAnimationEnd(Animation animation) {
               int top = mImages.get(0).getTop();
               int left = mImages.get(0).getLeft();
               int width = mImages.get(0).getWidth();
               int height = mImages.get(0).getHeight();
               mImages.get(0).clearAnimation();
               mImages.get(0).layout(left - detX, top - detY, left + width - detX, top + height - detY);
           }
        });
        mImages.get(0).startAnimation(translateAnimation1); 
        
        if (mMiddleNum == 1) return;
        final int detX2, detY2;
        detY2 = (int)(0.866f * ANIM_TRANS_DIS);
        detX2 = (int)(0.5f * ANIM_TRANS_DIS);
        
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0, - detX2, 0, - detY2);
        translateAnimation2.setInterpolator(new OvershootInterpolator());
        translateAnimation2.setDuration(animationTime * 1); 
        translateAnimation2.setFillAfter(true);
        translateAnimation2.setAnimationListener(new AnimationListener() {
           
           @Override
           public void onAnimationStart(Animation animation) {
               
           }
           
           @Override
           public void onAnimationRepeat(Animation animation) {
               
           }
           
           @Override
           public void onAnimationEnd(Animation animation) {
               int top = mImages.get(1).getTop();
               int left = mImages.get(1).getLeft();
               int width = mImages.get(1).getWidth();
               int height = mImages.get(1).getHeight();
               mImages.get(1).clearAnimation();
               mImages.get(1).layout(left - detX2, top - detY2, left + width - detX2, top + height - detY2);
           }
        });
        mImages.get(1).startAnimation(translateAnimation2); 
        
    }
    
    public void inAnimation(){
    	TranslateAnimation translateAnimation = new TranslateAnimation(-ANIM_TRANS_DIS, 0, 0, 0);
 	   
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
                int top = mLeftImage.getTop();
                int left = mLeftImage.getLeft();
                int width = mLeftImage.getWidth();
                int height = mLeftImage.getHeight();
                mLeftImage.clearAnimation();
                mLeftImage.layout(left + ANIM_TRANS_DIS, top, left + width + ANIM_TRANS_DIS, top + height);
            }
        });
 	    mLeftImage.startAnimation(translateAnimation); 
 	    
 	    
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
 	    
 	    TranslateAnimation translateAnimation5 = new TranslateAnimation(0, 0, -ANIM_TRANS_DIS, 0);
// 	    translateAnimation5.setInterpolator(new OvershootInterpolator());
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
               mTopImage.layout(left, top + ANIM_TRANS_DIS, left + width, top + height + ANIM_TRANS_DIS);
           }
        });
 	    mTopImage.startAnimation(translateAnimation5);
 	    
 	   if (mMiddleNum == 0) return;
       final int detX, detY;
       if (mMiddleNum == 1) {
           detX = (int)(0.7071f * ANIM_TRANS_DIS);
           detY = (int)(0.7071f * ANIM_TRANS_DIS);
       } else {
           detX = (int)(0.866f * ANIM_TRANS_DIS);
           detY = (int)(0.5f * ANIM_TRANS_DIS);
       }
       
       TranslateAnimation translateAnimation1 = new TranslateAnimation(-detX, 0, -detY, 0);
//       translateAnimation1.setInterpolator(new OvershootInterpolator());
       translateAnimation1.setDuration(animationTime * 1); 
       translateAnimation1.setFillAfter(true);
       translateAnimation1.setAnimationListener(new AnimationListener() {
          
          @Override
          public void onAnimationStart(Animation animation) {
              
          }
          
          @Override
          public void onAnimationRepeat(Animation animation) {
              
          }
          
          @Override
          public void onAnimationEnd(Animation animation) {
              int top = mImages.get(0).getTop();
              int left = mImages.get(0).getLeft();
              int width = mImages.get(0).getWidth();
              int height = mImages.get(0).getHeight();
              mImages.get(0).clearAnimation();
              mImages.get(0).layout(left + detX, top + detY, left + width + detX, top + height + detY);
          }
       });
       mImages.get(0).startAnimation(translateAnimation1); 
       
       if (mMiddleNum == 1) return;
       final int detX2, detY2;
       detY2 = (int)(0.866f * ANIM_TRANS_DIS);
       detX2 = (int)(0.5f * ANIM_TRANS_DIS);
       
       TranslateAnimation translateAnimation2 = new TranslateAnimation(-detX2, 0, -detY2, 0);
//       translateAnimation2.setInterpolator(new OvershootInterpolator());
       translateAnimation2.setDuration(animationTime * 1); 
       translateAnimation2.setFillAfter(true);
       translateAnimation2.setAnimationListener(new AnimationListener() {
          
          @Override
          public void onAnimationStart(Animation animation) {
              
          }
          
          @Override
          public void onAnimationRepeat(Animation animation) {
              
          }
          
          @Override
          public void onAnimationEnd(Animation animation) {
              int top = mImages.get(1).getTop();
              int left = mImages.get(1).getLeft();
              int width = mImages.get(1).getWidth();
              int height = mImages.get(1).getHeight();
              mImages.get(1).clearAnimation();
              mImages.get(1).layout(left + detX2, top + detY2, left + width + detX2, top + height + detY2);
          }
       });
       mImages.get(1).startAnimation(translateAnimation2);
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
    
    public void setListener(RightCornerListener listener) {
        mListener = listener;
    }
    
    public void setTopImage(int topId) {
        mTopImage.setImageResource(topId);
    }
    
    public void setLeftImage(int rightId) {
        mLeftImage.setImageResource(rightId);
    }
    
    public void setCenterImage(int centerId) {
        mCenterImage.setImageResource(centerId);
    }
    
    public void setMiddleImage(ArrayList<Integer> imageList) {
        if (imageList == null || imageList.size() != mImages.size())
            return;
        for (int i = 0; i < imageList.size(); i++) {
            mImages.get(i).setImageResource(imageList.get(i));
        }
    }

    @Override
    public void onClick(View v) {
        if (mListener == null)
            return;
        if (v == mLeftImage) {
            mListener.onRightCornerClickImage(RIGHT_IMAGE_INDEX);
        } else if (v == mTopImage) {
            mListener.onRightCornerClickImage(TOP_IMAGE_INDEX);
        } else if (v == mCenterImage) {
            myanimation();
        }
    }
    
}
