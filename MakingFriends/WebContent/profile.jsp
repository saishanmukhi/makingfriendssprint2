<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROFILE</title>
<meta charset="utf-8">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>SIGN UP</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.page-header{
	text-align: center;
}
</style>
</head>
<body>

<script>
function myfunction(){
	document.getElementById("EDIT").disabled = true;
	document.getElementById("password").disabled = false;
	document.getElementById("cpassword").disabled = false;
	document.getElementById("name").disabled = false;
	document.getElementById("email").disabled = false;
	document.getElementById("sports").disabled = false;
	document.getElementById("animation").disabled = false;
	document.getElementById("music").disabled = false;
	document.getElementById("books").disabled = false;
	document.getElementById("videogames").disabled = false;
	document.getElementById("travel").disabled = false;
	document.getElementById("fitness").disabled = false;
	document.getElementById("boardgames").disabled = false;
	document.getElementById("food").disabled = false;
	document.getElementById("tvmovies").disabled = false;
	document.getElementById("youtubemedia").disabled = false;
	document.getElementById("arts").disabled = false;
	document.getElementById("address").disabled = false;
	document.getElementById("submit").disabled = false;
}

</script>
<div class="page-header">
<h1>PROFILE</h1>
</div>
<table>
<tr>
<td><a href="profile1.jsp"> <input type ="button" class ="btn btn-info" value ="EDIT" onclick="myfunction()" id ="EDIT"/></a></td>
</tr>
<tr>
<th>NAME</th>
	<td><input type = "text" name = "name" disabled ="disabled" value='${pname}' id="name" /></td>
</tr>
<tr>
<th>EMAIL</th>
	<td><input type ="text" name ="email"  disabled ="disabled" value='${pemail}' id="email"  placeholder="abc@uncc.edu"/></td>
</tr>
<tr>
<th>DATE_OF_BIRTH</th>
	<td><input type ="text" name = "dob"  disabled ="disabled" value='${pdob}' id="dob" placeholder="mm/dd/yyyy"/></td>
</tr>
<tr>
<th>INTERESTS</th>
</tr>
    
<c:forEach var="values" items = "${arrayList}">

<tr>
<td>
<c:choose>

<c:when test="${values eq 'sports' }">
<input type = "checkbox" name ="sports" value ="Sports" checked="checked" disabled ="disabled" id="sports" />Sports </c:when></c:choose></td>
    
<td>
<c:choose>
<c:when test="${values eq 'animation' }">
<input type = "checkbox"  name ="animation" value ="Animation" checked="checked" disabled ="disabled" id="animation"/>Animation</c:when>

</c:choose></td>
<td>
<c:choose>
<c:when test="${values eq 'music' }">
<input type = "checkbox" name ="music" value ="Music" checked="checked" disabled ="disabled" id="music"/>Music</c:when></c:choose></td>
</tr>
<tr>
<td>
<c:choose>
<c:when test="${values eq 'books' }">
<input type = "checkbox" name ="books" value ="Books" checked="checked" disabled ="disabled" id="books"/>Books</c:when></c:choose></td>
<td>
<c:choose>
<c:when test="${values eq 'videogames' }">
<input type = "checkbox" name ="videogames" value ="Video Games" checked="checked" disabled ="disabled" id="videogames"/>Video Games</c:when></c:choose></td>
<td>
<c:choose>
<c:when test="${values eq 'travel' }">
<input type = "checkbox" name ="travel" value = "Travel" checked="checked" disabled ="disabled" id="travel"/>Travel</c:when></c:choose></td>
</tr>
<tr>
<td>
<c:choose>
<c:when test="${values eq 'fitness' }">
<input type = "checkbox" name ="fitness" value ="Fitness" checked="checked" disabled ="disabled" id="fitness"/>Fitness</c:when></c:choose></td>
<td>
<c:choose>
<c:when test="${values eq 'boardgames' }">
<input type = "checkbox" name ="boardgames" value ="Board Games" checked="checked" disabled ="disabled" id="boardgames" />Board Games</c:when></c:choose></td>
<td>
<c:choose>
<c:when test="${values eq 'food' }">
<input type = "checkbox" name ="food" value ="Food" checked="checked" disabled ="disabled" id="food"/>Food</c:when></c:choose></td>
</tr>
<tr>
<td>
<c:choose>
<c:when test="${values eq 'tvmovies' }">
<input type = "checkbox" name ="tvmovies" value ="TV/Movies" checked="checked" disabled ="disabled" id="tvmovies"/>TV/Movies</c:when></c:choose></td>
<td>
<c:choose>
<c:when test="${values eq 'youtubemedia' }">
<input type = "checkbox" name ="youtubemedia" value ="Youtube/Media" checked="checked" disabled ="disabled" id="youtubemedia" />Youtube/Media</c:when></c:choose></td>
<td>
<c:choose>
<c:when test="${values eq 'arts' }">
<input type = "checkbox" name ="arts" value ="Arts" checked="checked" disabled ="disabled" id="arts"/>Arts</c:when></c:choose></td>
</tr>
</c:forEach>
<tr>
<th>ADDRESS</th>
	<td><input type = "text" name = "address" disabled ="disabled" value='${paddress}' id="address" ></td>
</tr>
<tr>
<th>USERNAME</th>
	<td><input type = "text" name = "username" disabled="disabled" value ='${uname}'></td>
</tr>
<tr>
<th>PASSWORD</th>
	<td><input type = "password" name = "password" placeholder="******" disabled ="disabled" value='${ppassword}' id="password"/></td>
</tr>
<tr>
<th>CONFIRM PASSWORD</th>
	<td><input type = "password" name = "confirmpassword" placeholder="******" disabled="disabled" value='${cpassword}' id="cpassword" /></td>
</tr>
<tr>
<td align="center"><input type ="submit" class ="btn btn-info" value ="SUBMIT" disabled="disabled" id ="submit"/></td>
</tr>
</table>
</body>
</html>