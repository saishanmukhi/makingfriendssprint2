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
<title>MESSAGE</title>
 <style>
  body {
      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
      color: #f5f6f7;
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  .bg-1 { 
      background-color: red; 
      color: #ffffff;
  }
  .container-fluid {
      padding-top: 70px;
      padding-bottom: 70px;
  }
  .navbar {
      padding-top: 15px;
      padding-bottom: 15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 12px;
      letter-spacing: 5px;
  }
  .navbar-nav  li a:hover {
      color: #1abc9c !important;
  }
table{
	margin: 0 auto;
}
  </style>
</head>
<body>
<div class="container">
<div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" align="left" href="#">MakingFriends.com</a>
    </div>    	
  </div>

<div class="container-fluid bg-1 text-center">
<form action="send" method="post">
<table>
<tr>
<th>Recipient</th>
	<td><input type = "text" name = "recipient"/></td>
</tr>
<tr>
<th>Message</th>
	<td><input type ="text" name ="message"/></td>
</tr>
<tr>
<td><input type ="submit" name="SEND" button class ="btn btn-info" value ="SEND"/></td>
</tr>
<tr>
<td><input type="hidden" name="uname" value='${uname}'/></td>
</tr>
</table>
</form>
 <img src="http://25.media.tumblr.com/45b282472ef16a99ab0cda3ed282d7d3/tumblr_mig85jWNzC1qc58tto1_400.gif" class="img-responsive img-circle margin" style="display:inline" alt="Bird" width="350" height="350">
</div>
</body>
</html>