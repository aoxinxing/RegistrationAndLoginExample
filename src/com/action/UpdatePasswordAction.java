package com.action;

import java.util.Date;

import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.UserService;
import com.util.MD5Util;
import com.util.ServiceException;

public class UpdatePasswordAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String email;
	private String oldPassword;
	private String newPassword;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		String email = (String) stack.findValue("email");
		String oldPassword = (String) stack.findValue("oldPassword");
		String newPassword = (String) stack.findValue("newPassword");
		User user = this.userService.find(email);
        if(user!=null) {  
            if(user.getStatus()==1) { 
                if(user.getPassword().equals(MD5Util.encode2hex(oldPassword))){
                	user.setPassword(MD5Util.encode2hex(newPassword));
                	this.userService.modify(user);
                } else {
                	throw new ServiceException("Old password is not correct!");  
                }
            } else {
               throw new ServiceException("email has not been activated!");  
            }  
        } else {
            throw new ServiceException("this email has not been registered!");  
        }

		return SUCCESS;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
