package com.model;

import java.util.Calendar;
import java.util.Date;

public class User {
	private Integer userid;
	private String username;
	private String password;
	private String email;
	private int status=0;
	private String validateCode;
	private Date signupTime;

	public User() {
		super();
	}
	
	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public User(String username, String password, String email,int status, String validateCode, Date signupTime) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = status;
		this.validateCode = validateCode;
		this.signupTime = signupTime;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public Date getSignupTime() {
		return signupTime;
	}

	public void setSignupTime(Date signupTime) {
		this.signupTime = signupTime;
	}

	 public Date getLastActivateTime() {
	        Calendar cl = Calendar.getInstance();
	        cl.setTime(signupTime);
	        cl.add(Calendar.DATE , 2);

	        return cl.getTime();
	    }
	
}
