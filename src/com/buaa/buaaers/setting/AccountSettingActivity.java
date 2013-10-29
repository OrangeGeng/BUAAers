/**
 * 
 */
package com.buaa.buaaers.setting;

import com.buaa.buaaers.R;
import com.buaa.buaaers.common.BaseSimpleActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;

/**
 * @author gordongeng
 *
 */
public class AccountSettingActivity extends BaseSimpleActivity {

    private View mSetAccountImage;
    private ImageView mAccountImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        View content = LayoutInflater.from(this).inflate(R.layout.account_setting, mContainer);
        mRightBtn.setVisibility(View.GONE);
        mTitle.setImageResource(R.drawable.menubar_pushedzhszbutton);
        
        mSetAccountImage = content.findViewById(R.id.account_image_arrow);
        mSetAccountImage.setOnClickListener(this);
        mAccountImage = (ImageView)content.findViewById(R.id.account_image);
    }
    
    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (mSetAccountImage == v) {
            Intent intent = new Intent();
            /* 开启Pictures画面Type设定为image */
            intent.setType("image/*");
            /* 使用Intent.ACTION_GET_CONTENT这个Action */
            intent.setAction(Intent.ACTION_GET_CONTENT); 
            /* 取得相片后返回本画面 */
            startActivityForResult(intent, 1);
        }
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                /* 将Bitmap设定到ImageView */
                mAccountImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
