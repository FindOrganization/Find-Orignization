package com.example.zhaozuzhi;

import com.example.zhaozuzhi.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MainPageActivity extends Activity {

	
	private String username;
	private TextView showUserName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		showUserName=(TextView)findViewById(R.id.showUserName);
		Intent receiveIntent = getIntent();
		username=receiveIntent.getStringExtra("name");
		showUserName.setText("welcome "+username);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

}
