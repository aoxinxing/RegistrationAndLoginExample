<!DOCTYPE html>
<html>
<head>
	<title>Login Example</title>
   	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  	<script src="js/main.js"></script>
  	<script src="js/alert.js"></script>
</head>
<body>
	<div class="container">    
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
	<div class="panel panel-info" >
		<div class="panel-heading">
			<div class="panel-title">Sign In</div>
				<div style="float:right; font-size: 80%; position: relative; top:-10px">
					<a href="#" onclick="$('#signupbox').hide(); $('#forgetpasswordbox').show();$('#loginbox').hide()">Forgot password?</a>
				</div>
        </div>     

		<div style="padding-top:30px" class="panel-body" >
			<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
          	<form action="login" method="post" id="loginform" class="form-horizontal" role="form">

			    <div class="form-group">
			      <label class="col-md-3 control-label" for="email">Email</label>
			      <div class="col-md-6">
			        <div class="input-group"> <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
			          <input id="email" name="email" type="text" placeholder="Enter Your Email" class="form-control input-md">
			        </div>
			      </div>
			    </div>

			    <div class="form-group">
			      <label class="col-md-3 control-label" for="Password">Password</label>
			      <div class="col-md-6">
			        <div class="input-group"> <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
			          <input id="password" name="password" type="password" placeholder="Enter Your Password" class="form-control input-md">
			        </div>
			      </div>
			    </div>

			    <div class="form-group">
			      <label class="col-md-3 control-label" for="Submit"></label>
			      <div class="checkbox col-md-4">
                    	<label><input id="login-remember" type="checkbox" name="remember" value="1" > Remember me</label>
                  </div>
			      <div class="col-md-4">
			        <input id="Submit" class="btn btn-success" type="submit" value="Login">
			      </div>
			    </div>                        

                  <div class="form-group">
                  	<div class="col-md-12 control">
                   		<div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                            Don't have an account?
                        	<a href="#" onClick="$('#loginbox').hide();$('#forgetpasswordbox').hide(); $('#signupbox').show()">Sign Up Here</a>
                        </div>
                       </div>
                  </div>    
			</form>    
		</div>                     
	</div>  
    </div>
    <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
           	<div class="panel-heading">
               	<div class="panel-title">Sign Up</div>
                   <div style="float:right; font-size: 85%; position: relative; top:-10px">
                   <a id="signinlink" onclick="$('#signupbox').hide(); $('#forgetpasswordbox').hide();$('#loginbox').show()">Sign In</a></div>
               </div>  
               <div class="panel-body" >
               	<form action="register" method="post" id="signupform" class="form-horizontal" role="form" onSubmit="return checkForm('signUpEmail')">
               	
                       <div class="form-group">
                           <label for="signUpEmail" class="col-md-3 control-label">Email</label>
                           <div class="col-md-9">
                               <input type="text" class="form-control" id = "signupEmail" name="signupEmail" placeholder="Email Address" onblur="checkEmail(signupEmail)">
                           </div>
                       </div>
                       
                       <div class="form-group">
                           <label for="username" class="col-md-3 control-label">User Name</label>
                           <div class="col-md-9">
                               <input type="text" class="form-control" name="signupUsername" placeholder="User Name">
                           </div>
                       </div>
                       
                       <div class="form-group">
                           <label for="signupPassword" class="col-md-3 control-label">Password</label>
                           <div class="col-md-9">
                               <input type="password" id="signupPassword" class="form-control" name="signupPassword" placeholder="Password">
                           </div>
                       </div>
                           
                       <div class="form-group">
                           <label for="confirmPassword" class="col-md-3 control-label">Confirm Password</label>
                           <div class="col-md-9">
                               <input type="password" class="form-control" name="confirm" id="confirm" placeholder="Confirm Password">
                           </div>
                       </div>

                       <div class="form-group">                                     
                           <div class="col-md-offset-3 col-md-9">
                               <input id="btn-signup" type="submit" class="btn btn-info" value="Sign Up"/>
                           </div>
                       </div>
                   </form>
                </div>
    	</div>
    </div> 
    
    <div id="forgetpasswordbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
           	<div class="panel-heading">
               	<div class="panel-title">Forgot Password</div>
                   <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide();$('#forgetpasswordbox').hide();$('#loginbox').show()">Sign In</a></div>
               </div>  
               <div class="panel-body" >
	               <form action="forgotPassword" method="post" id="forgotPasswordForm" class="form-horizontal" role="form" onSubmit="return checkForm('forgotPasswordEmail')">
	               		<div class="form-group">
			      			<label class="col-md-3 control-label" for="email">Email</label>
			     			<div class="col-md-6">
			        			<div class="input-group"> <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
			          				<input id="forgotPasswordEmail" name="forgotPasswordEmail" type="text" placeholder="Enter Your Email" class="form-control input-md" onblur="checkForm('forgotPasswordEmail')">
			        			</div>
			      			</div>
			      			<div class="col-md-3">
			      				<input id="btn-sendEmail" type="submit" class="btn btn-success" value="Send Email"/>
			      			</div>
			    		</div> 
			    		<div class="form-group">
                  			<div class="col-md-12 control">
	                   			<div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
	                            	Don't have an account?
	                        	<a href="#" onClick="$('#loginbox').hide(); $('#forgetpasswordbox').hide();$('#signupbox').show()">Sign Up Here</a>
	                       		</div>
                       		</div>
                 	 	</div>      
	               </form>
               </div>
    	</div>
    </div> 
    
    </div>
</body>
</html>			