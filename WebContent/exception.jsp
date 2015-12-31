<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Error</title>
	<style>
	body{
		margin:0px;
		background-repeat:repeat-x;
		background-position:0px 65px;
	}
	body, td, div{
		font-family:Arial, Helvetica, sans-serif;
		font-size:12px; line-height:12px;
	}
	.titleTop{
		font-size:22px;
		font-weight:bold;
		color:#e2a53c;
	}
	.infoBoxOuter{
		width:598px;
		background-repeat:repeat-x;
		background-color:#dedfe1;
		border-right:1px solid #000;
		border-bottom:1px solid #000;
		padding:9px;	
	}
	.infoBoxInner{
		width:568px;
		background-repeat:repeat-x;
		background-color:#f2f2f2;
		border-right:2px solid #000;
		border-bottom:2px solid #000;
		padding:14px;
	}
	
</style>
</head>
<body>
	<table width="598" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td height="65" class="titleTop">Oops...This is embarrassing.</td>
	  </tr>
	  <tr>
	    <td height="160" valign="bottom">
	    <div class="infoBoxOuter">
	    	<div class="infoBoxInner">
	        <h1>We're sorry.</h1><br/>
	        We are experiencing technical difficulties at this moment.<br /><br />
			Error Type: <strong> <s:property value="exception.message"/></strong> <br />
			<p><a href="index.jsp">Return to the homepage</a></p><br />
	        </div>
	    </div>
	    </td>
	  </tr>
	</table>
</body>
</html>
	
	
