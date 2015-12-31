package com.action;

import java.util.Date;

import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.UserService;
import com.util.MD5Util;
import com.util.SendEmail;

public class ForgotPasswordAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String forgotPasswordEmail;
	private UserService userService;
	
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		forgotPasswordEmail = (String) stack.findValue("forgotPasswordEmail");
		User existingUser = this.userService.find(forgotPasswordEmail);
		if (existingUser == null) {
			return ERROR;
		} else {
			Long validateCode = System.currentTimeMillis()+30*60*1000;
			
			StringBuffer sb=new StringBuffer("Please reset your password within 30 mins!");
	        sb.append("<br/>");      
	        sb.append("<a href = \"http://localhost:8080/RegistrationAndLoginExample/resetPassword?email="); 
	        sb.append(forgotPasswordEmail);
	        sb.append("&validateCode=");
	        sb.append(validateCode);
	        sb.append("\">Click here to reset your password!</a>");

	        SendEmail.send(forgotPasswordEmail, sb.toString());
	        
			return SUCCESS;
		}
	}
	
	public String getForgotPasswordEmail() {
		return forgotPasswordEmail;
	}
	public void setForgotPasswordEmail(String forgotPasswordEmail) {
		this.forgotPasswordEmail = forgotPasswordEmail;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
