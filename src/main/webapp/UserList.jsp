<!-- Important!! Need to import model and ArrayList -->
<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<h1>Current users</h1>
	<%
	// getAttribute will return object, so we have to cast it to ArrayList type
	ArrayList<User> list =
				(ArrayList<User>)request.getAttribute("list");
	
	for (int i = 0; i < list.size(); i++) {
		User user1 = list.get(i);
	%>
	<h1>Hello</h1>
	<p><%= (i+1) %> user</p>
	<p>
		Name: <%= user1.getName() %></p>
	<p>
		Age: <%= user1.getAge() %></p>
	<% } %>
	<a href="UserInput.jsp">Go Back</a>
</body>
</html>