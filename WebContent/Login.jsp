<%@ page import="User.dbMethods"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SaWoT Login</title>
<body>
<h1>SaWoT Login</h1>

<form action="Login.jsp">
Indtast Bruger Navn: <br />
<input type="text" name="Name"/><br />
Indtast Password: <br />
<input type="password" name="Pass"/><br /><br />
<input type=submit name="Login" value="Login"/>
</form>

<%

String Name = " ";
String Pwd = " ";
Name = request.getParameter("Name");
Pwd = request.getParameter("Pass");
if (request.getParameter("Login") != null)
{
	if (Name != null && !Name.equals("") && Pwd != null && !Pwd.equals(""))
	{
		if (dbMethods.login(Name, Pwd))
		{
			session.setAttribute("LoggedIn", Name);
			out.println("Logged in: " + Name);
			response.sendRedirect("UserSite.jsp");
			return;
		}
	}
	else
	{
	session.removeAttribute("LoggedIn");
	response.sendRedirect("Login.jsp");
	return;
	}
}
%>
<br /><br />
<a href="createUser.jsp">Not a user. Sign up now</a><br /><br />
</body>
</html>