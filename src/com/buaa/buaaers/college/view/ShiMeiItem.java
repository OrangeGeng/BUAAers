package com.buaa.buaaers.college.view;

import com.buaa.buaaers.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class ShiMeiItem {
    
    private View mView;
    
    private Context mContext;
    
    public ShiMeiItem(Context context) {
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.shimei_item, null);        
    }
    
    public View getView() {
        return mView;
    }
}
