<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%
    Object o = request.getAttribute("foreName");
    String fName = (String)o;
    o = request.getAttribute("lastName");
    String lName = (String)o;
    o = request.getAttribute("passwd");
    String pwd = (String)o;
    o = request.getAttribute("nickName");
    String nName = (String)o;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<h1>Seawas <%=fName+" "+lName%></h1> <br>
<p>Dei password isch "<%=pwd%>"</p>
<h3>Du bisch da beste <%=nName%></h3>

</body>
</html>