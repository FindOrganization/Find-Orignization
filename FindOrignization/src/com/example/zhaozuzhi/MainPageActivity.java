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
		// ���û����˵��򿪺����ͼ����
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, new SampleListFragment()).commit();

		// ������������ͼ
		setContentView(R.layout.content_frame);
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SampleListFragment()).commit();
		
		// ���õ��򿪻����˵�ʱ��ActionBar���ܹ�������һ�𻬶�
		setSlidingActionBarEnabled(false);
		
		// ���û����˵�������ֵ
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
