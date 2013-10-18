package com.buaa.buaaers;

import com.buaa.buaaers.college.CollegeActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LoginActivity extends Activity implements OnClickListener{

	private ImageView mLoginBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		mLoginBtn = (ImageView)findViewById(R.id.loginBtn);
		mLoginBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if (mLoginBtn == v) {
			Intent intent = new Intent(this, CollegeActivity.class);
            startActivity(intent);
            finish();
		}
		
	}

}
