<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account page</title>

	
<head>
	<title>My Account</title>
</head>
<body>
	<h1>Welcome to your account</h1>
	<p>Account ID: ${accountId}</p>
	<p>Username: ${username}</p>
	<p>Email: ${email}</p>
	<p>Role: ${role}</p>
	<p>Avatar: <img src="${avatar}" alt="Avatar"></p>
</body>
</html>
