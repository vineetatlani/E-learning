<%@page import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<i>We Are running on <%= application.getServerInfo() %></i><br>
	 <hr>
	 <a href="course/list">List All Courses</a>
	 <a href="user/register">Register User</a>
</body>
</html>