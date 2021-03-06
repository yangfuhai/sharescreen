package com.archermind.ashare.mirror;

import com.archermind.ashare.mirror.AShareJniCallBack.AShareJniCallBackListener;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import archermind.ashare.R;

public class ScreenDisplayActivity extends Activity implements AShareJniCallBackListener{
	
	private static final String TAG = "ClientDisplay";
	private ServerScreenView mServerScreenView;
	private Context mContext;
	private AShareJniCallBack mJniCallBack;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = ScreenDisplayActivity.this;
		DisplayMetrics dm = getResources().getDisplayMetrics();
       Log.d(TAG, "dm.widthPixels="  +dm.widthPixels + " dm.dm.heightPixels=" + dm.heightPixels);
		setContentView(R.layout.ashare_show);
		mServerScreenView = (ServerScreenView) findViewById(R.id.server_screen_view);
		mServerScreenView.setKeepScreenOn(true);
		mJniCallBack = AShareJniCallBack.getInstance();
    	mJniCallBack.addCallBackListener(this);
	}
	
	public void onResume() {
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "ondestroy-------------");
		//unbindService(mServerManagerConnection);
	}

	@Override
	public void onAShareServerConnected() {
		Log.d(TAG, "onAShareServerConnected..........");
	}

	@Override
	public void onAShareServerDisconnected() {
		Log.d(TAG, "onAShareServerDisconnected..........");
		finish();
	}
}
