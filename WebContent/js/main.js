$(document).ready(function () {
	jQuery.validator.setDefaults({
		debug : false,
		success : "valid"
	});

	$('#loginform').validate({
		rules : {
			email : {
				required : true,
				email : true
			},
			password : {
				required : true,
				minlength : 6,
				maxlength : 15
			},
		},

		highlight : function (element) {
			$(element).closest('.form-group').addClass('has-error');

		},
		unhighlight : function (element) {
			$(element).closest('.form-group').removeClass('has-error');
		},
		errorElement : 'span',
		errorClass : 'help-block',
		errorPlacement : function (error, element) {
			if (element.parent('.input-group').length) {
				error.insertAfter(element.parent());
			} else {
				error.insertAfter(element);
			}
		}

	});
	
	$('#signupform').validate({
		rules : {
			signupEmail : {
				required : true,
				email : true
			},
			signupUsername : {
				required : true,
				minlength : 4,
				maxlength : 10
			},
			signupPassword : {
				required : true,
				minlength : 6,
				maxlength : 15
			},
			confirm : {
				required : true,
	            equalTo:"#signupPassword"
	        }
		},

		highlight : function (element) {
			$(element).closest('.form-group').addClass('has-error');

		},
		unhighlight : function (element) {
			$(element).closest('.form-group').removeClass('has-error');
		},
		errorElement : 'span',
		errorClass : 'help-block',
		errorPlacement : function (error, element) {
			if (element.parent('.input-group').length) {
				error.insertAfter(element.parent());
			} else {
				error.insertAfter(element);
			}
		}

	});
	
	$('#updatePasswordForm').validate({
		rules : {
			oldPassword : {
				required : true,
			},
			newPassword : {
				required : true,
				minlength : 6,
				maxlength : 15
			},
			confirm : {
				required : true,
	            equalTo:"#newPassword"
	        }
		},

		highlight : function (element) {
			$(element).closest('.form-group').addClass('has-error');

		},
		unhighlight : function (element) {
			$(element).closest('.form-group').removeClass('has-error');
		},
		errorElement : 'span',
		errorClass : 'help-block',
		errorPlacement : function (error, element) {
			if (element.parent('.input-group').length) {
				error.insertAfter(element.parent());
			} else {
				error.insertAfter(element);
			}
		}
	})
	
});

function checkEmail(element){
	var email = $('#signupEmail').val();
	var alert = "Your entered email has already been registered!";
	if(email!=null && email!=""){
		$.ajax({
	        url:'/RegistrationAndLoginExample/userCheck',
	        data:{
	             email : email ,
	        },
	        type:'POST',
	        dataType:'json',
	        async: true,
	        success:function(data) {
	            var result = data.result;
	            if(result!=null && result=="true"){
	            	$(element).closest('.form-group').addClass('has-error');
	            	error='<div id="signUpEmailAlert"><span class = "help-block">'+alert+'</span></div>';
	            	$(error).insertAfter(element);
	            } else {
	            	var alertMessage = $('#signUpEmailAlert span').text();
	            	if(alertMessage==alert){
		            	$(element).next().remove();
	            	}
	            }  
	        },   
	    });
	}
}

function checkForm(emailID){
	var email = document.getElementById(emailID).value;
	if(email!=null && email!=""){
		$.ajax({
	        url:'/RegistrationAndLoginExample/userCheck',
	        data:{
	             email : email ,
	        },
	        type:'POST',
	        dataType:'json',
	        async: false,
	        success:function(data) {
	            var result = data.result;
	            if(result==null || result=="false"){
	            	if(emailID=='forgotPasswordEmail'){
	            		$.alert("Your entered email has Not been registered!","");
	            		return false;
	            	} else
	            		return true;
	            } else {
	            	if(emailID!='forgotPasswordEmail'){
	            		$.alert("Your entered email has already been registered!","");
	            	} else 
	            		return false;
	            }
	        },   
	    });
	} else{
		$.alert("Please enter your email address!","");
	}
}