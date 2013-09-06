/**
 * 
 */
package com.buaa.buaaers.me;

import com.buaa.buaaers.R;
import com.buaa.buaaers.common.BaseActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * @author gordongeng
 *
 */
public class MeActivity extends BaseActivity implements OnClickListener{
    
    private ImageView mCourseTableBtn, mMeJoinBtn;
    
    /**
     * 是否处在我参与界面
     */
    private boolean mIsMeJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mContainer.addView()
        
        mCourseTableBtn = (ImageView)mSwitchBar.findViewById(R.id.iv1);
        mMeJoinBtn = (ImageView)mSwitchBar.findViewById(R.id.iv2);
        mCourseTableBtn.setOnClickListener(this);
        mMeJoinBtn.setOnClickListener(this);
        
        mCourseTableBtn.setImageResource(R.drawable.me_switchbar_wdkb_on);
        mMeJoinBtn.setImageResource(R.drawable.me_switchbar_wcy_off);
        
        mIsMeJoin = false;
    }
    
    @Override
    public void onClick(View v) {
        if (v == mCourseTableBtn) {
            switchContent(false);
        } else if (v == mMeJoinBtn) {
            switchContent(true);
        }
    }
    
    /**
     * 切换内容
     * @param goMeJoin
     */
    private void switchContent(boolean goMeJoin) {
        if (!goMeJoin) {
            if (!mIsMeJoin) return;
            // 显示我的课表
            mCourseTableBtn.setImageResource(R.drawable.me_switchbar_wdkb_on);
            mMeJoinBtn.setImageResource(R.drawable.me_switchbar_wcy_off);
            mIsMeJoin = false;
        } else {
            if (mIsMeJoin) return;
            // 显示我参与
            mCourseTableBtn.setImageResource(R.drawable.me_switchbar_wdkb_off);
            mMeJoinBtn.setImageResource(R.drawable.me_switchbar_wcy_on);
            mIsMeJoin = true;
        }
    }

}
