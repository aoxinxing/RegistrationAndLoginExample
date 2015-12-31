package com.action;

import java.util.Date;

import com.model.User;
import com.util.ServiceException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.UserService;

public class ActiveAccountAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String signupEmail;
	private String validateCode;
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		String signupEmail = (String) stack.findValue("signupEmail");
		String validateCode = (String) stack.findValue("validateCode");
		
		User user = this.userService.find(signupEmail);
        if(user!=null) {  
            if(user.getStatus()==0) { 
                Date currentTime = new Date();
                currentTime.before(user.getSignupTime());
                if(currentTime.before(user.getLastActivateTime())) {  
                    if(validateCode.equals(user.getValidateCode())) {    
                        //update status to 1
                    	user.setStatus(1);  	
                    	this.userService.modify(user);
                    } else {  
                       throw new ServiceException("validate code is not correct!");  
                    }  
                } else { throw new ServiceException("validate code has been expired!");  
                }  
            } else {
               throw new ServiceException("email has been activated!");  
            }  
        } else {
            throw new ServiceException("this email has not been registered!");  
        }
		return SUCCESS;
	}
	
	public String getSignupEmail() {
		return signupEmail;
	}
	public void setSignupEmail(String signupEmail) {
		this.signupEmail = signupEmail;
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
