package com.buaa.buaaers.common;

import com.buaa.buaaers.R;
import com.buaa.buaaers.common.view.LeftCornerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

public class BaseActivity extends Activity{

	/**
	 * 左下角menu
	 */
	protected LeftCornerView mLeftMenu;
	
	/**
	 * 顶部切换页面bar
	 */
	protected LinearLayout mSwitchBar;
	
	/**
	 * 页面主体内容Container
	 */
	protected LinearLayout mContainer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.base_layout);		
		mLeftMenu = (LeftCornerView)findViewById(R.id.left_menu);
		
        mSwitchBar = (LinearLayout)findViewById(R.id.switch_bar);
		mContainer = (LinearLayout)findViewById(R.id.container);
	}
}
