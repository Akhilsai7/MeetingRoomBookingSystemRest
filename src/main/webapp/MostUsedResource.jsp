<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.MeetingRoom.MRBS.bean.ResourceUsage,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resource times</title>
</head>
<body>
<form name="Newrequest" style="text-align: center" method="post"
		action="FacilityManagerServlet?varname=MostUsedResource">
		<h2 align="center">Resource Usage</h2>
		<table align="center">
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