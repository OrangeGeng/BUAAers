package com.buaa.buaaers.common.view;

import com.buaa.buaaers.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class LeftCornerView extends FrameLayout{

	ImageView cameraImage , musicImage ,placeImage,sleepImage,thoughtImage,withImage ,plusImage;
	
	boolean sign = false;
	
	static final int anicatinoTime = 100;
	
	public LeftCornerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		View view = View.inflate(context, R.layout.left_corner_view, this);
		cameraImage = (ImageView)view.findViewById(R.id.picture_tiankong);        
        musicImage = (ImageView)view.findViewById(R.id.music);        
        placeImage = (ImageView)view.findViewById(R.id.place);       
        sleepImage = (ImageView)view.findViewById(R.id.sleep);        
        thoughtImage = (ImageView)view.findViewById(R.id.thought);        
        withImage = (ImageView)view.findViewById(R.id.with);        
        plusImage = (ImageView)view.findViewById(R.id.myplus);
//        
	}
	
	public void myanimation(){
    	
    	showRotateAnimation(sign);
    	
    	if(!sign){
    	    sign = true;
    	    outAnimation();
    	}else{
    		sign = false;
    		inAnimation();
    	}
    	
    }
	
    public void outAnimation(){
    	TranslateAnimation translateAnimation = new TranslateAnimation(0,200, 0, 0);
 	    translateAnimation.setInterpolator(new OvershootInterpolator());
 	    translateAnimation.setDuration(anicatinoTime * 1+240); 
 	    translateAnimation.setFillAfter(true); 
 	    cameraImage.startAnimation(translateAnimation); 
 	    
 	    
 	    TranslateAnimation translateAnimation1 = new TranslateAnimation(0,190, 0, -60);
 	    translateAnimation1.setInterpolator(new OvershootInterpolator());
 	    translateAnimation1.setDuration(anicatinoTime * 1+180); 
 	    translateAnimation1.setStartOffset(20);
 	    translateAnimation1.setFillAfter(true); 
 	    musicImage.startAnimation(translateAnimation1); 
 	    
 	    
 	    TranslateAnimation translateAnimation2 = new TranslateAnimation(0,170, 0, -120);
 	    translateAnimation2.setInterpolator(new OvershootInterpolator());
 	    translateAnimation2.setDuration(anicatinoTime * 1+120); 
 	    translateAnimation2.setStartOffset(40);
 	    translateAnimation2.setFillAfter(true); 
 	    placeImage.startAnimation(translateAnimation2);
 	    
 	    TranslateAnimation translateAnimation3 = new TranslateAnimation(0,120, 0, -165);
 	    translateAnimation3.setInterpolator(new OvershootInterpolator());
 	    translateAnimation3.setDuration(anicatinoTime * 1+80); 
 	    translateAnimation3.setStartOffset(60);
 	    translateAnimation3.setFillAfter(true); 
 	    sleepImage.startAnimation(translateAnimation3);
 	    
 	    TranslateAnimation translateAnimation4 = new TranslateAnimation(0,60, 0, -190);
 	    translateAnimation4.setInterpolator(new OvershootInterpolator());
 	    translateAnimation4.setDuration(anicatinoTime * 1+40); 
 	    translateAnimation4.setStartOffset(80);
 	    translateAnimation4.setFillAfter(true); 
 	    thoughtImage.startAnimation(translateAnimation4);
 	    
 	    TranslateAnimation translateAnimation5 = new TranslateAnimation(0,0, 0, -200);
 	    translateAnimation5.setInterpolator(new OvershootInterpolator());
 	    translateAnimation5.setDuration(anicatinoTime * 1); 
 	    translateAnimation5.setStartOffset(100);
 	    translateAnimation5.setFillAfter(true); 
 	    withImage.startAnimation(translateAnimation5);
    }
    
    public void inAnimation(){
    	 TranslateAnimation translateAnimation = new TranslateAnimation(200,0, 0, 0);
 	   
 	    translateAnimation.setDuration(anicatinoTime * 1); 
 	    translateAnimation.setFillAfter(true); 
 	    cameraImage.startAnimation(translateAnimation); 
 	    
 	    
 	    TranslateAnimation translateAnimation1 = new TranslateAnimation(190,0,-60, 0);
 	   
 	    translateAnimation1.setDuration(anicatinoTime * 1); 
 	    translateAnimation1.setStartOffset(30);
 	    translateAnimation1.setFillAfter(true); 
 	    musicImage.startAnimation(translateAnimation1); 
 	    
 	    
 	    TranslateAnimation translateAnimation2 = new TranslateAnimation(170,0,-120, 0);
// 	    translateAnimation2.setInterpolator(new OvershootInterpolator());
 	    translateAnimation2.setDuration(anicatinoTime * 1); 
 	    translateAnimation2.setStartOffset(60);
 	    translateAnimation2.setFillAfter(true); 
 	    placeImage.startAnimation(translateAnimation2);
 	    
 	    TranslateAnimation translateAnimation3 = new TranslateAnimation(120,0,-165, 0);
// 	    translateAnimation3.setInterpolator(new OvershootInterpolator());
 	    translateAnimation3.setDuration(anicatinoTime * 1); 
 	    translateAnimation3.setStartOffset(90);
 	    translateAnimation3.setFillAfter(true); 
 	    sleepImage.startAnimation(translateAnimation3);
 	    
 	    TranslateAnimation translateAnimation4 = new TranslateAnimation(60,0, -190, 0);
// 	    translateAnimation4.setInterpolator(new OvershootInterpolator());
 	    translateAnimation4.setDuration(anicatinoTime * 1); 
 	    translateAnimation4.setStartOffset(120);
 	    translateAnimation4.setFillAfter(true); 
 	    thoughtImage.startAnimation(translateAnimation4);
 	    
 	    TranslateAnimation translateAnimation5 = new TranslateAnimation(0,0, -200, 0);
// 	    translateAnimation5.setInterpolator(new OvershootInterpolator());
 	    translateAnimation5.setDuration(anicatinoTime * 1);
 	    translateAnimation5.setStartOffset(150);
 	    translateAnimation5.setFillAfter(true); 
 	    withImage.startAnimation(translateAnimation5);
    }
    
    
    public void showRotateAnimation(boolean sign) { 
      
    	
        final float centerX = plusImage.getWidth() / 2.0f; 
        final float centerY = plusImage.getHeight() / 2.0f;
        RotateAnimation rotateAnimation = null; 
        if(!sign){
        	  rotateAnimation = new RotateAnimation(0, 405, centerX, 
                      centerY); 
              
        }else{
        	 rotateAnimation = new RotateAnimation(405, 0, centerX, 
                     centerY); 
        }
        rotateAnimation.setDuration(anicatinoTime+220); 
        rotateAnimation.setFillAfter(true); 
        plusImage.startAnimation(rotateAnimation); 
    }
}
