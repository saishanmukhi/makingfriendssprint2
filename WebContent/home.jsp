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
<style>
.btn {
    margin-right: 5px;
}
</style>
</head>
<c:if test="${not empty updatedmessage}">
    <script>
    alert("Profile saved");
</script>
</c:if>
<c:if test="${not empty available}">
    <script>
    alert("Available time has been set");
</script>
</c:if>
<c:if test="${not empty notifications}">
    <script>
    alert("No messages to display !!");
</script>
</c:if>
<body>
<div class = "container">
<div class = "page-header">
<h1>Welcome !</h1>
    <div class="btn-toolbar pull-right">
        <form action="profile" method="get">
		<input type ="submit" name="PROFILE" button class ="btn btn-info" value ="PROFILE"/>
		</form>
        <a href="login.jsp"><input type ="button" button class ="btn btn-info" value ="LOGOUT"/></a>
    </div>
 </div>
 <h3 align ="left" >Hello,</h3>
<h3>${uname}</h3>
<form action="matchuser" method="post">
<input type ="submit" name="MATCH" button class ="btn btn-info" value ="MATCH"/>
</form>
<form action="meet" method="post">
<input type ="submit" name="MEET" button class ="btn btn-info" value ="MEET"/>
</form>
<form action="notification" method="post">
<input type ="submit" name="NOTIFICATIONS" button class ="btn btn-info" value ="NOTIFICATIONS"/>
</form>
</div>
</body>
</html>