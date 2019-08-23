<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<marquee direction="right" scrollamount="12" behavior="scroll">MEETING
	ROOM BOOKING SYSTEM</marquee>
<meta charset="UTF-8">
<title>Reject Request</title>
</head>
<body>
	<%@include file="AcceptRequestTable.jsp"%>
	<form action="FacilityManagerServlet?varname=rejectrequest"
		method="post">
		<table align="center">
			<tr>
				<td><input type="number" name="requestid" value=""></td>
			</tr>
			<tr>
				<td><input type="submit" name="approve_reject"
					value="rejectrequest"></td>
			</tr>
		</table>
	</form>
</body>
</html>