<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a User</title>
</head>
<body>
	<%@include file="FMFunctionalities.jsp" %>
	<form name="NewUser" style="text-align: center" method="post" action="FacilityManagerServlet?varname=adddetails">
		<h2 align="center">Adding A User</h2>
		<table align="center">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="username" value=""></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td>Role:</td>
				<td><input type="text" name="role" value="USER"></td>
			</tr>
			<tr>
				<td><input type="reset" name="index_clear" value="Clear"></td>
				<td><input type="submit" name="index_validate" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>