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
<title>HOME</title>
</head>
<style>
.RbtnMargin { margin-left: 10px; }
</style>

<body>
<div class = "container">
<div class = "page-header">
<h1>Welcome !</h1>
    <div class="btn-toolbar pull-right">
        <form action="profile" method="get">
		<input type ="submit" name="PROFILE" button class ="btn btn-info" value ="PROFILE"/>
		</form>
        <a href="login.jsp"><input type ="submit" button class ="btn btn-info" value ="LOGOUT"/></a>
    </div>
 </div>
<h3 align ="left" >Hello,</h3>
<h3>${uname}</h3>
</div>
</body>
</html>