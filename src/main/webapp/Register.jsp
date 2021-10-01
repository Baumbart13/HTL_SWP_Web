<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<form method="post" action="DoRegister">
    <label for="fName">First name:</label><br>
    <input id="fName" name="fName" type="text"><br>
    <label for="lName">Last name:</label><br>
    <input id="lName" name="lName" type="text"><br>
    <label for="nName">Nickname:</label><br>
    <input id="nName" name="nName" type="text"><br>
    <label for="pwd">Password:</label><br>
    <input id="pwd" name="pwd" type="password"><br>
    <input type="submit" value="Registrieren">
</form><br>

<%
    Object o = request.getAttribute("fail");
    String fail = (String)o;

    if(fail != null){
        for(int i = 0; i < 4; ++i){
            out.append("<h1>"+fail+"</h1>");
        }
    }
%>

</body>
</html>