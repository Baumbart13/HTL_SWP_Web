<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<%
		String error = (String)request.getAttribute("error");
		if(error != null){
			if(error.equals("")){
				error = "Default error-message";
			}
			out.append(String.format("<p class=\"error\">%s</p>", error));
		}
	%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="DoRegister" method="post">
		<label>Email</label>
		<input type="text" name="email"><br>

		<label>Username</label>
		<input type="text" name="username"><br>

		<label>Firstname</label>
		<input type="text" name="firstname"><br>

		<label>Lastname</label>
		<input type="text" name="lastname"><br>

		<label>Password</label>
		<input type="password" name="password"><br>

		<label>Repeat password</label>
		<input type="password" name="passwordrepeated"><br>

		<input type="submit" value="Register">
	</form>
</body>
</html>