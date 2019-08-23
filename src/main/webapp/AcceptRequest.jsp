<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.MeetingRoom.MRBS.bean.MeetingRequestBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accept Request</title>
</head>
<body>
	<%@include file="AcceptRequestTable.jsp"%>
	<form action="FacilityManagerServlet?varname=acceptrequest"
		method="post">
		<table align="center">
			<tr>
				<td><input type="number" name="requestid" value=""></td>
			</tr>
			<tr>
				<td><input type="submit" name="approve_reject"
					value="approverequest"></td>
			</tr>
		</table>
	</form>
</body>
</html>