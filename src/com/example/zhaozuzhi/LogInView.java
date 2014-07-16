package com.example.zhaozuzhi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInView extends Activity {
	
//Those are TextViews EditText and buttons in our xml file in log in page	
	private TextView titleProject = null;
	private TextView inputUser = null;
	private TextView userName = null;
	private TextView password = null;
	private EditText inputName = null;
	private EditText inputPassword= null;
	private Button register = null;
	private Button logIn = null;
	private boolean checkMatch;
	
	private LogInModel logInModel;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Find those things and set text to them
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
		
		
		//create button click listener to check if button clicked
		
		register.setOnClickListener(new registerListener());
		logIn.setOnClickListener(new logInListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Button click listener classes
	class registerListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent registerIntent = new Intent();
			registerIntent.setClass(LogInView.this, RegisterView.class);
			LogInView.this.startActivity(registerIntent);
			
		}
		
	}
	class logInListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			String inputUserName = inputName.getText().toString();
			String inputPassWord = inputPassword.getText().toString();
			if (inputUserName.equals("")){
				Toast.makeText(LogInView.this,
                        "user name can't be empty!", Toast.LENGTH_SHORT).show();
			}else if (inputPassWord.equals("")){
				Toast.makeText(LogInView.this,
                        "password can't be empty!", Toast.LENGTH_SHORT).show();
			}else{
				logInModel=new LogInModel(inputUserName, inputPassWord);
				checkMatch = logInModel.CheckMatch();
				if(checkMatch){
					//login successfully
					Toast.makeText(LogInView.this,
	                        "successful!", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(LogInView.this,
	                        "not match!", Toast.LENGTH_SHORT).show();
				}
			}
			
		}
		
	}
}
