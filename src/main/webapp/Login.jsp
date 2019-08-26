<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<marquee direction="right" scrollamount="12" behavior="alternate">MEETING
	ROOM BOOKING SYSTEM</marquee>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form name="index" style="text-align: center" method="post"
		action="LoginServlet">
		<h2 align="center">Login</h2>
		<table align="center">
			<tr>
				<td>User name:-</td>
				<td><input type="text" name="username" value=""></td>
			</tr>
			<tr>
				<td>Password:-</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td><input type="reset" name="index_clear" value="Clear"></td>
				<td><input type="submit" name="index_validate" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>