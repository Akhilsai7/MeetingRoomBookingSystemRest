<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>
</head>
<body>
	<%@include file="FMFunctionalities.jsp"%>
	<form name="NewUser" style="text-align: center" method="post"
		action="FacilityManagerServlet?varname=deletedetails">
		<h2 align="center">Deleting A User</h2>
		<table align="center">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="username" value=""></td>
			</tr>
			<tr>
				<td><input type="reset" name="index_clear" value="Clear"></td>
				<td><input type="submit" name="index_validate" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>