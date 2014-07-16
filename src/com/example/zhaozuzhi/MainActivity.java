package com.example.zhaozuzhi;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	private TextView titleProject = null;
	private TextView inputUser = null;
	private TextView userName = null;
	private TextView password = null;
	private EditText inputName = null;
	private EditText inputPassword= null;
	private Button register = null;
	private Button logIn = null;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		titleProject=(TextView)findViewById(R.id.titleProject);
		titleProject.setText(R.string.project_title);
		inputUser=(TextView)findViewById(R.id.inputUser);
		inputUser.setText(R.string.ask_user_log_in);
		userName=(TextView)findViewById(R.id.inputName);
		userName.setText(R.string.username);
		password=(TextView)findViewById(R.id.inputPassword);
		password.setText(R.string.password);
		inputName=(EditText)findViewById(R.id.userName);
		inputPassword=(EditText)findViewById(R.id.password);
		register=(Button)findViewById(R.id.register);
		register.setText(R.string.register);
		logIn =(Button)findViewById(R.id.logIn);
		logIn.setText(R.string.login);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
