<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Opret bruger</title>
</head>
<body>

<form method="post" action="createUser">
<pre>
Brugernavn:			<input type="text" name="username" /><br>
Email:				<input type="text" name="email" /><br>
Adgangskode:			<input type="password" name="pass" /><br>
Gentag adganskode:		<input type="password" name="pass2" /><br>
</pre>
<input type="submit" name="btnOK" value="OK" style="width:80px" />
<input type="submit" name="Tilbage" value="Tilbage"/>
<%
if (request.getParameter("Tilbage") != null)
	{
	response.sendRedirect("Login.jsp");
	return;	
	}
%>
</form>
</body>
</html>