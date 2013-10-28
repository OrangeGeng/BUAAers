
package com.buaa.buaaers.common.view;

import com.buaa.buaaers.R;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * 为SOSO地图定制的一个dialog 为了统一UI风格
 * 
 * @author michaelzuo
 */
public abstract class CustomerDialog extends Dialog {
    /**
     * 上下文
     */
    protected Context context;

    /**
     * dialog的contentView
     */
    private View contentView;

    /**
     * dialog的内容view
     */
    protected View centerView;

    /**
     * dialog的titleView
     */
    protected View titleView;

    /**
     * 按钮点击事件监听的代理
     */
    private ButtonClickDelegate mButtonClickDelegate;

    /**
     * 创建二次确认dialog
     * 
     * @param context
     */
    public CustomerDialog(Context context) {
        super(context, R.style.Dialog);
        this.context = context;
        initCustomerView();

        // 当confirmDialog取消时 如果取消
        setOnCancelListener(new OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                Button negativeButton = getNegativeButton();
                if (negativeButton != null) {
                    negativeButton.performClick();
                }
            }
        });
    }

    /**
     * 设置按钮响应监听的代理
     * 
     * @param delegate
     */
    public void setButtonClickDelegate(ButtonClickDelegate delegate) {
        mButtonClickDelegate = delegate;
    }

    /**
     * 初始化自定义的View对象
     */
    private void initCustomerView() {
        contentView = LayoutInflater.from(context).inflate(R.layout.dialog, null);
        titleView = contentView.findViewById(R.id.dialog_title);

        centerView = initContentView();
        ((ViewGroup)contentView.findViewById(R.id.content_view)).addView(centerView);

        // 初始化按钮监听
        initButtonListener();

        setContentView(contentView);
    }

    /**
     * 初始化按钮监听
     */
    private void initButtonListener() {
        Button positiveButton = (Button)contentView.findViewById(R.id.button_positive);
        positiveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                performButtonOnClick(v);
            }
        });

        Button negativeButton = (Button)contentView.findViewById(R.id.button_negative);
        negativeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                performButtonOnClick(v);
            }
        });
    }

    /**
     * 处理按钮被点击
     * 
     * @param v
     */
    private void performButtonOnClick(View v) {
        // 如果有代理 则让代理去处理
        // 如果没有代理 默认行为为dismiss
        if (mButtonClickDelegate != null) {
            mButtonClickDelegate.onClick(v);
        } else {
            dismiss();
        }
    }

    /**
     * 得到确认button
     * 
     * @return
     */
    public Button getPositiveButton() {
        return (Button)contentView.findViewById(R.id.button_positive);
    }

    /**
     * 得到否定的button
     * 
     * @return
     */
    public Button getNegativeButton() {
        return (Button)contentView.findViewById(R.id.button_negative);
    }

    /**
     * 初始化contentView视图 由子类根据自己不同的风格去实现
     */
    protected abstract View initContentView();

    /**
     * 设置title的文本
     * 
     * @param title
     */
    public void setTitle(String title) {
        TextView titleTextView = (TextView)titleView.findViewById(R.id.dialog_title_text);
        titleTextView.setText(title);
    }

    /**
     * 设置title的文本
     * 
     * @param titleResId
     */
    public void setTitle(int titleResId) {
        String title = getString(titleResId);
        setTitle(title);
    }

    /**
     * 根据资源id获得String
     * 
     * @param resId
     * @return
     */
    protected String getString(int resId) {
        return context.getString(resId);
    }

    /**
     * 隐藏title
     */
    public void hideTitleView() {
        if (null != titleView) {
            titleView.setVisibility(View.GONE);
        }
    }
    
    /**
     * 按钮点击相应的代理接口
     * 
     * @author michaelzuo
     */
    public static interface ButtonClickDelegate {
        public void onClick(View v);
    }
}
