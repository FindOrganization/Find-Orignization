package com.example.zhaozuzhi;

import com.example.zhaozuzhi.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainPageActivity extends SlidingFragmentActivity {

	
	private String username;
	private TextView showUserName;
	private Fragment mContent;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//showUserName=(TextView)findViewById(R.id.showUserName);
		//Intent receiveIntent = getIntent();
		//username=receiveIntent.getStringExtra("name");
		//showUserName.setText("welcome "+username);
		setTitle("Sliding Content only");
		
		
		//set main page
		setContentView(R.layout.responsive_content_frame);
		initSlidingMenu(savedInstanceState);
	}

	
	private void initSlidingMenu(Bundle savedInstanceState){
		// check if the content frame contains the menu frame
		if (findViewById(R.id.menu_frame) == null) {
			setBehindContentView(R.layout.menu_frame);
			getSlidingMenu().setSlidingEnabled(true);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
			// show home as up so we can toggle
			getActionBar().setDisplayHomeAsUpEnabled(true);
		} else {
			// add a dummy view
			View v = new View(this);
			setBehindContentView(v);
			getSlidingMenu().setSlidingEnabled(false);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
		
		//set fragment view
		if (savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
		if (mContent == null)
			mContent = new CommentsFragment(0);
		
		
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mContent).commit();

		// set the Behind View Fragment
		getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, new MeauView()).commit();
		
		// set menu size
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);


		getActionBar().setDisplayHomeAsUpEnabled(true);			
	}
	
	public void switchContent(final Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
		
		Handler h = new Handler();
		h.postDelayed(new Runnable() {
			public void run() {
				getSlidingMenu().showContent();
			}
		}, 50);
	}
	
	public void onPressed(int pos) {
		Intent intent = SwitchActivity.newInstance(this, pos);
		startActivity(intent);
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

}
