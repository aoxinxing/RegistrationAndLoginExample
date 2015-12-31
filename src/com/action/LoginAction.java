package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.UserService;
import com.util.MD5Util;
import com.model.User;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		String email = (String) stack.findValue("email");
		
		String password = (String) stack.findValue("password");
		password = MD5Util.encode2hex(password);
		
		if (email != null && email.length() > 0) {
			if (password != null && password.length() > 0) {
				if (this.userService == null) {
					return ERROR;
				}
				User user = this.userService.find(email);
				if (user != null) {
					if(user.getStatus()==0){
						return ERROR;
					}else if (user.getPassword().equals(password)) {
						HttpServletRequest request = ServletActionContext.getRequest();
						HttpSession session = request.getSession();
						session.setAttribute("user", user);
						return SUCCESS;
					} 
				}
			}
		}
		return ERROR;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
