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
	    <div id="resetPassord" style=" margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
	           	<div class="panel-heading">
	               	<div class="panel-title">ResetPassword</div>
	            </div>  
	            <div class="panel-body" >
	              	<form action="updatePassword" method="post" id="updatePasswordForm" class="form-horizontal" role="form" onSubmit="return checkForm('email')">
	              	
	                      <div class="form-group">
	                          <label for="email" class="col-md-3 control-label" >Email</label>
	                          <div class="col-md-9">
	                              <input type="text" class="form-control" id = "email" name="email" placeholder="Email Address"  value="<%=request.getParameter("email")%>">
	                          </div>
	                      </div>
	                      
	                      <div class="form-group">
	                          <label for="oldPassword" class="col-md-3 control-label">Old Password</label>
	                          <div class="col-md-9">
	                              <input type="password" class="form-control" name="oldPassword" placeholder="Old Password">
	                          </div>
	                      </div>
	                      
	                      <div class="form-group">
	                          <label for="newPassword" class="col-md-3 control-label">New Password</label>
	                          <div class="col-md-9">
	                              <input type="password" id="newPassword" class="form-control" name="newPassword" placeholder="Password">
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
	                              <input id="btn-signup" type="submit" class="btn btn-info" value="Submit"/>
	                          </div>
	                      </div>
	                  </form>
	               </div>
	    	</div>
	    </div> 
    </div>
</body>
</html>			