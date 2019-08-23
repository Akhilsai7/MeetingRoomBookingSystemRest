<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Cancel Meeting Room</title>
</head>
<body>
<%@include file="DisplayRequestDetailsUser.jsp"%>

	<form name="Newrequest" style="text-align: center" method="post"
		action="UserFunctionalitiesServlet?varname=cancelmeetingroom">
		<h2 align="center">Cancel Your Meeting Request</h2>
		<table align="center">
			<tr>
				<td>Start Date:</td>
				<td><input type="date" name="startdate"></td>
			</tr>
			<tr>
				<td>End Date:</td>
				<td><input type="date" name="enddate"></td>
			</tr>
			<tr>
				<td>RequestID:</td>
				<td><input type="number" name="id" value=""></td>
			</tr>
			<tr>
				<td><input type="submit" name="SUBMIT" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>