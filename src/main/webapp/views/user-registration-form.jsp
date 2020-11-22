<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error {
	color: red
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration</h1>
	<br > <br > <br >
	fields marked with * are required
	<br >
	<form:form action="register" modelAttribute="crmUser" method="post">
		
		User Name: <form:input path="userName" /> <br ><br >
		<form:errors path="userName" cssClass="error"/> <br ><br >
		
		Password: <form:password path="password" /> <br ><br >
		<form:errors path="password" cssClass="error"/> <br ><br >
		
		Confirm Password: <form:password path="matchingPassword" /> <br ><br >
		<form:errors path="password" cssClass="error"/> <br ><br >
		
		First Name: <form:input path="firstName" /> <br ><br >
		<form:errors path="firstName" cssClass="error"/> <br ><br >
		
		Last Name*: <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/> <br ><br >
		
		Email*: <form:input path="email"/>
		<form:errors path="email" cssClass="error"/> <br ><br >
		
		Phone Number*: <form:input path="phoneNumber"/>
		<form:errors path="phoneNumber" cssClass="error"/> <br ><br >
		
		<input type="submit" >
	</form:form>
</body>
</html>