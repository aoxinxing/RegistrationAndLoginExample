package com.action;

import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.UserService;
import com.util.ServiceException;

public class ResetPasswordAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String email;
	private String validateCode;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		String email = (String) stack.findValue("email");
		String validateCode = (String) stack.findValue("validateCode");
		User user = this.userService.find(email);
        if(user!=null) {  
            if(user.getStatus()!=0) { 
                Long currentTime = System.currentTimeMillis();
                if(currentTime<Long.parseLong(validateCode)) {  
                    return SUCCESS;
                } else { 
                	return ERROR;
                } 
            } else {
               throw new ServiceException("email has not been activated!");  
            }  
        } else {
            throw new ServiceException("this email has not been registered!");  
        }
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
