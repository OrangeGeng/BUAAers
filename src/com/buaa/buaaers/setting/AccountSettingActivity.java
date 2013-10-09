/**
 * 
 */
package com.buaa.buaaers.setting;

import com.buaa.buaaers.R;
import com.buaa.buaaers.common.BaseSimpleActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author gordongeng
 *
 */
public class AccountSettingActivity extends BaseSimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LayoutInflater.from(this).inflate(R.layout.account_setting, mContainer);
        mRightBtn.setVisibility(View.GONE);
        mTitle.setImageResource(R.drawable.menubar_pushedzhszbutton);
    }

}
