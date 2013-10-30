/**
 * 
 */
package com.buaa.buaaers.common;

import com.buaa.buaaers.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author gordongeng
 *
 */
public class ReleaseActivity extends BaseSimpleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRightBtn.setVisibility(View.GONE);
        mTitle.setVisibility(View.GONE);
        
        View content = LayoutInflater.from(this).inflate(R.layout.release_content, mContainer);
//        mContainer.addView(content);
    }
}
