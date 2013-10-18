/**
 * 
 */
package com.buaa.buaaers.me;

import com.buaa.buaaers.R;
import com.buaa.buaaers.buaaclass.ClassActivity;
import com.buaa.buaaers.college.CollegeActivity;
import com.buaa.buaaers.common.BaseActivity;
import com.buaa.buaaers.common.view.LeftCornerListener;
import com.buaa.buaaers.common.view.LeftCornerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * @author gordongeng
 *
 */
public class MeActivity extends BaseActivity implements LeftCornerListener{
    
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
        
        mLeftMenu.setCenterImage(R.drawable.leftcorner_center_me);
        mLeftMenu.setTopImage(R.drawable.leftcorner_college);
        mLeftMenu.setRightImage(R.drawable.leftcorner_class);
        mLeftMenu.setListener(this);
    }
    
    @Override
    public void onClick(View v) {
        super.onClick(v);
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

    @Override
    public void onLeftCornerClickImage(int index) {
        if (index == LeftCornerView.TOP_IMAGE_INDEX) {
            Log.d("gordongeng", "click the top image");
            Intent meIntent = new Intent(this, CollegeActivity.class);
            startActivity(meIntent);
            onDestroy();
            finish();
        } else if (index == LeftCornerView.RIGHT_IMAGE_INDEX) {
            Log.d("gordongeng", "click the right image");
            Intent meIntent = new Intent(this, ClassActivity.class);
            startActivity(meIntent);
            onDestroy();
            finish();
        }
    }

    @Override
    public void onLeftCornerAnimChaged(boolean isGoOut) {
        mLeftMenu.setCenterImage(isGoOut ? R.drawable.leftcorner_center_me_pressed : R.drawable.leftcorner_center_me);
    }

    @Override
    protected boolean onBackKey() {
        return true;
    }
    
    

}
