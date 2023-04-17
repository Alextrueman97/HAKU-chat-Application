<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Registration</title>
</head>
<body>
	<h2>User Registration</h2>
	
	<form:form method="POST" action="/register">
		<table>
			<tr>
				<td><label for="email">Email:</label></td>
				<td><form:input path="email" id="email" /></td>
			</tr>
			<tr>
				<td><label for="username">Username:</label></td>
				<td><form:input path="username" id="username" /></td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><form:password path="password" id="password" /></td>
			</tr>
			<tr>
				<td><label for="confirmPassword">Confirm Password:</label></td>
				<td><form:password path="confirmPassword" id="confirmPassword" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>