<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<h1>Register User</h1>
	<form action="UserServlet" method="post">
		<label for="name">Your name:</label> <input type="text" name="name">
		<label for="age">Your age:</label> <input type="text" name="age">
		<input type="submit" value="Go">
	</form>
	
	<h1>Check user list</h1>
	<form action="UserServlet">
		<input type="submit" value="Show registered users">
	</form>
</body>
</html>