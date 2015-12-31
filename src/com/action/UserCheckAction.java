package com.action;

import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.UserService;

public class UserCheckAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String email;
	private String result;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		String email = (String) stack.findValue("email");
		
		User user = this.userService.find(email);
		if (user != null) {
	           this.result = "true";
	       }else{
	           this.result = "false";
	    }
	       return"success";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
