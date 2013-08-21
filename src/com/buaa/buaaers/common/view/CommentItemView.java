package com.buaa.buaaers.common.view;

import com.buaa.buaaers.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * 
 * 评论ItemView
 * @author gordongeng
 *
 */
public class CommentItemView extends LinearLayout{

    public CommentItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    
    public CommentItemView(Context context) {
        super(context);
        init(context);
    }
    
    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.comment_item, this);
    }

}
