<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>
<h1 align ="left" >MakingFriends.com</h1>
<h3>${uname}</h3>
<form action="profile" method="get">
<input type ="submit" name="PROFILE" value ="PROFILE"/>
</form>
<table>
<tr>
<td align="right"><a href="login.jsp"><input type ="submit" value ="LOGOUT"/></a></td>
</tr>
</table>
</body>
</html>