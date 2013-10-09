/**
 * 
 */
package com.buaa.buaaers.setting;

import com.buaa.buaaers.R;
import com.buaa.buaaers.common.BaseSimpleActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * 推送设置页面
 * @author gordongeng
 *
 */
public class PushSettingActivity extends BaseSimpleActivity {

    private ImageView mCollegeUrgent,mCollegeCourse,mCollegeInternship,mCollegePartry,mCollegeCommonNews,
                mClassUrgent,mClassActivity,mClassCommon,mAboutMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LayoutInflater.from(this).inflate(R.layout.push_setting_layout, mContainer);
        mRightBtn.setVisibility(View.GONE);
        mTitle.setImageResource(R.drawable.menubar_pushedtskzbutton);
        
        mCollegeUrgent = (ImageView)mContainer.findViewById(R.id.push_jinji_btn);
        mCollegeUrgent.setOnClickListener(this);
        if (CommonSettingData.sPushCollegeUrgent) {
            mCollegeUrgent.setImageResource(R.drawable.main_checkedsign);
        }
        
        mCollegeCourse = (ImageView)mContainer.findViewById(R.id.push_course_btn);
        mCollegeCourse.setOnClickListener(this);
        if (CommonSettingData.sPushCollegeCourse) {
            mCollegeCourse.setImageResource(R.drawable.main_checkedsign);
        }
        
        mCollegeInternship = (ImageView)mContainer.findViewById(R.id.push_shixi_btn);
        mCollegeInternship.setOnClickListener(this);
        if (CommonSettingData.sPushCollegeInternship) {
            mCollegeInternship.setImageResource(R.drawable.main_checkedsign);
        }
        
        mCollegePartry = (ImageView)mContainer.findViewById(R.id.push_dangwu_btn);
        mCollegePartry.setOnClickListener(this);
        if (CommonSettingData.sPushCollegePartry) {
            mCollegePartry.setImageResource(R.drawable.main_checkedsign);
        }
        
        mCollegeCommonNews = (ImageView)mContainer.findViewById(R.id.push_commonnews_btn);
        mCollegeCommonNews.setOnClickListener(this);
        if (CommonSettingData.sPushCollegeCommonNews) {
            mCollegeCommonNews.setImageResource(R.drawable.main_checkedsign);
        }
        
        mClassUrgent = (ImageView)mContainer.findViewById(R.id.push_classjinji_btn);
        mClassUrgent.setOnClickListener(this);
        if (CommonSettingData.sPushClassUrgent) {
            mClassUrgent.setImageResource(R.drawable.main_checkedsign);
        }
        
        mClassActivity = (ImageView)mContainer.findViewById(R.id.push_classactivity_btn);
        mClassActivity.setOnClickListener(this);
        if (CommonSettingData.sPushClassActivity) {
            mClassActivity.setImageResource(R.drawable.main_checkedsign);
        }
        
        mClassCommon = (ImageView)mContainer.findViewById(R.id.push_classcommon_btn);
        mClassCommon.setOnClickListener(this);
        if (CommonSettingData.sPushClassCommon) {
            mClassCommon.setImageResource(R.drawable.main_checkedsign);
        }
        
        mAboutMe = (ImageView)mContainer.findViewById(R.id.push_aboutme_btn);
        mAboutMe.setOnClickListener(this);
        if (CommonSettingData.sPushAboutMe) {
            mAboutMe.setImageResource(R.drawable.main_checkedsign);
        }
    }
    
    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == mCollegeUrgent) {
            CommonSettingData.sPushCollegeUrgent = !CommonSettingData.sPushCollegeUrgent;
            mCollegeUrgent.setImageResource(CommonSettingData.sPushCollegeUrgent ? R.drawable.main_checkedsign : R.drawable.main_uncheckedsign);
        } else if (v == mCollegeCourse) {
            CommonSettingData.sPushCollegeCourse = !CommonSettingData.sPushCollegeCourse;
            mCollegeCourse.setImageResource(CommonSettingData.sPushCollegeCourse ? R.drawable.main_checkedsign : R.drawable.main_uncheckedsign);
        } else if (v == mCollegeInternship) {
            CommonSettingData.sPushCollegeInternship = !CommonSettingData.sPushCollegeInternship;
            mCollegeInternship.setImageResource(CommonSettingData.sPushCollegeInternship ? R.drawable.main_checkedsign : R.drawable.main_uncheckedsign);
        } else if (v == mCollegePartry) {
            CommonSettingData.sPushCollegePartry = !CommonSettingData.sPushCollegePartry;
            mCollegePartry.setImageResource(CommonSettingData.sPushCollegePartry ? R.drawable.main_checkedsign : R.drawable.main_uncheckedsign);
        } else if (v == mCollegeCommonNews) {
            CommonSettingData.sPushCollegeCommonNews = !CommonSettingData.sPushCollegeCommonNews;
            mCollegeCommonNews.setImageResource(CommonSettingData.sPushCollegeCommonNews ? R.drawable.main_checkedsign : R.drawable.main_uncheckedsign);
        } else if (v == mClassUrgent) {
            CommonSettingData.sPushClassUrgent = !CommonSettingData.sPushClassUrgent;
            mClassUrgent.setImageResource(CommonSettingData.sPushClassUrgent ? R.drawable.main_checkedsign : R.drawable.main_uncheckedsign);
        } else if (v == mClassActivity) {
            CommonSettingData.sPushClassActivity = !CommonSettingData.sPushClassActivity;
            mClassActivity.setImageResource(CommonSettingData.sPushClassActivity ? R.drawable.main_checkedsign : R.drawable.main_uncheckedsign);
        } else if (v == mClassCommon) {
            CommonSettingData.sPushClassCommon = !CommonSettingData.sPushClassCommon;
            mClassCommon.setImageResource(CommonSettingData.sPushClassCommon ? R.drawable.main_checkedsign : R.drawable.main_uncheckedsign);
        } else if (v == mAboutMe) {
            CommonSettingData.sPushAboutMe = !CommonSettingData.sPushAboutMe;
            mAboutMe.setImageResource(CommonSettingData.sPushAboutMe ? R.drawable.main_checkedsign : R.drawable.main_uncheckedsign);
        }
    }
    
    
    
    

    
}
