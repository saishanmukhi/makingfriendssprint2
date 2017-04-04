<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>SETTIME</title>
</head>
<body>
<h3> here ${uname}</h3>
<form action="meet" method="post">
<table>
<tr>
<th>DATE</th>
	<td><input type ="text" name = "date1" placeholder="mm/dd/yyyy"/></td>
</tr>
<tr>
<th>From</th>
	<td><input type ="text" name ="from" placeholder="HH:MM"/></td>
	<th>
<td></td>
</th>
<th>To</th>
	<td><input type ="text" name = "to" placeholder="HH:MM"/></td>
</tr>
<tr>
<td align="center"><input type ="submit" disabled="disabled" value ="SUBMIT" id ="signup"/></td>
</tr>
</table>
</body>
</html>