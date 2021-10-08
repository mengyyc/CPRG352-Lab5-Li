<%-- 
    Document   : home
    Created on : 7-Oct-2021, 12:55:26 PM
    Author     : lixia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Home Page</title>
	</head>
	<body>
		<h1>Home Page</h1>
		<p>Hello ${user.username}</p>
		<a href="login?logout">Log out</a>
	</body>
</html>
