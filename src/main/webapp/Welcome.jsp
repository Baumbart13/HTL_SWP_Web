<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Object object = session.getAttribute("username");
	String user = (String) object;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Hello <%=user%>
		<button onclick="RequestData()">Data</button>
	</h1>
	<div id="tab">

	</div>
<script>
	function RequestData(){
		const x = new XMLHttpRequest();
		x.onload = function(){
			alert(this.responseText);
			var arr = JSON.parse(this.responseText);
			var html = convertArrayToTable(arr);
			document.getElementById("tab").innerHTML = html;
		}
		x.open("POST", "UserList", true);
		x.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
		x.send();
	}

	function convertArrayToTable(arr){
		var s = "<table>";
		for(i = 0; i < arr.length; ++i){
			var o = arr[i];

			s+="<tr>";
			s+="<td>" + o.email + "</td>";
			s+="<td>" + o.foreName + "</td>";
			s+="<td>" + o.lastName + "</td>";
			s+="<td>" + o.userName + "</td>";
			s+="</tr>";
		}
		s+="</table>";

		return s;
	}
</script>

</body>
</html>