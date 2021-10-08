<%-- 
    Document   : login
    Created on : 7-Oct-2021, 12:52:26 PM
    Author     : lixia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Page</title>
	</head>
	<body>
		<h1>Login</h1>
		<form action="login" method="POST">
			<label>Username:</label>
			<input type="text" name="username" value="${username}" />
			<br>
			<label>Password:</label>
			<input type="password" name="password" value="${password}" />
			<br>
			<input type="submit" value="Log in" />
			<p>${message}</p>
		</form>
	</body>
</html>
