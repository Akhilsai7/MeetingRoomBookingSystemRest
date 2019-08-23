<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.MeetingRoom.MRBS.bean.MeetingRoom,com.MeetingRoom.MRBS.bean.ResourceUsage,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Requesting Meeting Room</title>
</head>
<body>
	<%@include file="UserFunctionalities.jsp"%>
	<form name="Newrequest" style="text-align: center" method="post"
		action="UserFunctionalitiesServlet?varname=requestmeetingroom">
		<h2 align="center">Request A Meeting Room</h2>
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
				<td>Start time:</td>
				<td><input type="time" name="starttime"></td>
			</tr>
			<tr>
				<td>End time:</td>
				<td><input type="time" name="endtime"></td>
			</tr>
			<td>Meeting Room No:</td>
			<td><select name="Meetingroom_no">

					<%
						ArrayList<String> meetingrooms = (ArrayList<String>) request.getAttribute("meetingrooms");
						for (String meeting : meetingrooms) {
					%>
					<option>
						<%=meeting%>
					</option>
					<%
						}
					%>
			</select></td>
			</tr>


			<td>Resource No:</td>
			<td><select name="Resource_no">

					<%
						ArrayList<String> resources = (ArrayList<String>) request.getAttribute("resources");
						for (String resource : resources) {
					%>
					<option>
						<%=resource%>
					</option>
					<%
						}
					%>
			</select></td>
			</tr>




		</table>
		<input type="submit" name="SUBMIT" value="submit">
	</form>
</body>
</html>