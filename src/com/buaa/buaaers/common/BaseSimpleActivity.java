/**
 * 
 */
package com.buaa.buaaers.common;

import com.buaa.buaaers.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 用在次级界面
 * @author gordongeng
 *
 */
public class BaseSimpleActivity extends Activity implements OnClickListener{

    protected LinearLayout mContainer;
    
    protected ImageView mTitle, mTopBarLogo, mRightBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_simple_layout);       
        
        mContainer = (LinearLayout)findViewById(R.id.container);
        
        mTopBarLogo = (ImageView)findViewById(R.id.logo_image);
        mRightBtn = (ImageView)findViewById(R.id.top_bar_right_btn);
        mTitle = (ImageView)findViewById(R.id.topbar_title);
        
        mTopBarLogo.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        if(v == mTopBarLogo) {
            onBackPressed();
            onDestroy();
        }
    }
}
