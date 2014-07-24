package com.example.zhaozuzhi;

public class LogInModel {

	private String username = null;
	private String password = null;
	
	public LogInModel(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	//connect DB and check if user name and password match return true or false
	public boolean CheckMatch(){
		if(username.equals("jeff")){
			if(password.equals("123")){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
		
	}
}
