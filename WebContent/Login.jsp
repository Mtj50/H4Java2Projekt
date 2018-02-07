<%@page import="Bruger.LoginUser"%>
<%@  page import="java.io.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp id="user" class="Bruger.LoginUser" scope="session"></jsp>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>login</title>
</head>
<body>

<h1><center>Give your login details</center></h1>
<form method="post" action="check.jsp">
Username:<input type="text" name="username" size="20" value="<%=Bruger.getUsername()%>" >       <br>
Password:<input type="password" name="password" size="20" value=<%=Bruger.getPassword()%> ><br>
<input type="submit">
</form>

</body>
</html>