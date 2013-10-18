package com.buaa.buaaers.common;

import com.buaa.buaaers.R;
import com.buaa.buaaers.common.view.LeftCornerView;
import com.buaa.buaaers.common.view.TopBarMenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BaseActivity extends Activity implements OnClickListener{

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
	
	/**
	 * 顶栏logo
	 */
	protected ImageView mTopBarLogo;
	
	/**
     * 顶栏Menu按钮
     */
    protected ImageView mTopBarMenuBtn;
    
    /**
     * 菜单
     */
    protected TopBarMenu mTopBarMenu;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.base_layout);		
		mLeftMenu = (LeftCornerView)findViewById(R.id.left_menu);
		
        mSwitchBar = (LinearLayout)findViewById(R.id.switch_bar);
		mContainer = (LinearLayout)findViewById(R.id.container);
		
		mTopBarLogo = (ImageView)findViewById(R.id.logo_image);
		mTopBarMenuBtn = (ImageView)findViewById(R.id.top_bar_menu_btn);
		mTopBarMenuBtn.setOnClickListener(this);
		mTopBarMenu = (TopBarMenu)findViewById(R.id.top_bar_menu);
	}
	
    @Override
    public void onClick(View v) {
        if(v == mTopBarMenuBtn) {
            if(mTopBarMenu.getVisibility() == View.VISIBLE)
                mTopBarMenu.setVisibility(View.GONE);
            else 
                mTopBarMenu.setVisibility(View.VISIBLE);
        }
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            boolean reasult = onBackKey();
            if (reasult)
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    protected boolean onBackKey() {
        return false;
    }
    
    private void showExitDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("退出");
        dialog.setMessage("是否要退出BUAAers");
        dialog.setPositiveButton("", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
          finish(); 
         }
        });
        
        dialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener(){
         @Override
         public void onClick(DialogInterface dialog, int which) {
         
         }
        });
        
    }
}
