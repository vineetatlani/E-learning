<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All Courses</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="course" items="${courses}">
			<tr>
				<td>${course.name }</td>
				<td>${course.price }</td>
			</tr>	
		
		</c:forEach>
	</table>
</body>
</html>