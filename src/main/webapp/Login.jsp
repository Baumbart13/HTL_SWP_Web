<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String errorMessage = (String)request.getAttribute("errorMessage");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
	.error{
	color: red;
	}
></style>
</head>
<body>
<h1>login</h1>
	<%
	if(errorMessage != null){
		out.append("<p class='error'>"+errorMessage+"</p>");
	}
	%>
	<form action="Anmelden" method="post">
		<label>User:</label> 
		<input type="text" name="username" value=""></input>
		<br>
		<label>Password:</label> 
		<input type="password" name="password" value=""></input>
		<br> 
		<input type="submit" value="Log in">
	</form>

	<a href="Register.jsp">Registration</a>

</body>
</html>