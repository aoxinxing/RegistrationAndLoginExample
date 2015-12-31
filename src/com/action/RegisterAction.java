package com.action;

import java.util.Date;

import com.util.SendEmail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.UserService;
import com.util.MD5Util;
import com.model.User;

public class RegisterAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String signupUsername;
	private String signupPassword;
	private String signupEmail;
	private int status;
	private String validateCode;
	private Date signupTime;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		signupUsername = (String) stack.findValue("signupUsername");
		
		signupPassword = (String) stack.findValue("signupPassword");
		signupPassword = MD5Util.encode2hex(signupPassword);
		
		signupEmail = (String) stack.findValue("signupEmail");
		
		User existingUser = this.userService.find(signupEmail);
		if (existingUser != null) {
			return ERROR;
		} else {
			signupTime = new Date();
			status=0;
			validateCode = MD5Util.encode2hex(signupEmail);
	        
			User user = new User(signupUsername,signupPassword,signupEmail,status,validateCode,signupTime);
			userService.save(user);
			
			StringBuffer sb=new StringBuffer("Please active your account within 48 hours!");
	        sb.append("<br/>");      
	        sb.append("<a href = \"http://localhost:8080/RegistrationAndLoginExample/activeAccount?signupEmail="); 
	        sb.append(signupEmail);
	        sb.append("&validateCode=");
	        sb.append(user.getValidateCode());
	        sb.append("\">Click here to activate your account!</a>");

	        SendEmail.send(signupEmail, sb.toString());
	        
			return SUCCESS;
		}
		
	}

	public String getSignupUsername() {
		return signupUsername;
	}

	public void setSignupUsername(String signupUsername) {
		this.signupUsername = signupUsername;
	}

	public String getSignupPassword() {
		return signupPassword;
	}

	public void setSignupPassword(String signupPassword) {
		this.signupPassword = signupPassword;
	}

	public String getSignupEmail() {
		return signupEmail;
	}

	public void setSignupEmail(String signupEmail) {
		this.signupEmail = signupEmail;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
