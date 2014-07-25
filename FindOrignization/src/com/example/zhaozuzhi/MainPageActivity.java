package com.example.zhaozuzhi;

import com.example.zhaozuzhi.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MainPageActivity extends SlidingFragmentActivity {

	
	private String username;
	private TextView showUserName;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//showUserName=(TextView)findViewById(R.id.showUserName);
		//Intent receiveIntent = getIntent();
		//username=receiveIntent.getStringExtra("name");
		//showUserName.setText("welcome "+username);
		setTitle("Sliding Content only");
		
		initSlidingMenu();
	}

	
	private void initSlidingMenu(){
		// 设置滑动菜单打开后的视图界面
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, new SampleListFragment()).commit();

		// 设置主界面视图
		setContentView(R.layout.content_frame);
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SampleListFragment()).commit();
		
		// 设置当打开滑动菜单时，ActionBar不能够跟随着一起滑动
		setSlidingActionBarEnabled(false);
		
		// 设置滑动菜单的属性值
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		getActionBar().setDisplayHomeAsUpEnabled(true);			
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

}
