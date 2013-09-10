/**
 * 
 */
package com.buaa.buaaers.common.view;

import com.buaa.buaaers.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

/**
 * @author gordongeng
 *
 */
public class TopBarMenu extends LinearLayout implements OnClickListener{
    
    View mAccountSetting, mPushControl, mClearCash, mLogout, mOpionReply;

    /**
     * @param context
     */
    public TopBarMenu(Context context) {
        super(context);
        init(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public TopBarMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    
    private void init(Context context) {
        View view = View.inflate(context, R.layout.top_bar_menu, this);
        
        mAccountSetting = view.findViewById(R.id.menubar_account_setting);
        mAccountSetting.setOnClickListener(this);
        
        mPushControl = view.findViewById(R.id.menubar_push_control);
        mPushControl.setOnClickListener(this);
        
        mClearCash = view.findViewById(R.id.menubar_clear_cash);
        mClearCash.setOnClickListener(this);
        
        mOpionReply = view.findViewById(R.id.menubar_opnion_reply);
        mOpionReply.setOnClickListener(this);
        
        mLogout = view.findViewById(R.id.menubar_logout);
        mLogout.setOnClickListener(this);
        
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(mAccountSetting == v) {
            Log.d("gordongeng", "on click the menu item --- mAccountSetting");
        } else if(v == mPushControl) {
            Log.d("gordongeng", "on click the menu item --- mPushControl");
        } else if(v == mClearCash) {
            Log.d("gordongeng", "on click the menu item --- mClearCash");
        } else if(v == mLogout) {
            Log.d("gordongeng", "on click the menu item --- mLogout");
        } else if(v == mOpionReply) {
            Log.d("gordongeng", "on click the menu item --- mOpnionReply");
        }
    }

}
