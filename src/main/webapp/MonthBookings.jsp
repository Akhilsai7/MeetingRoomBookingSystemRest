<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.MeetingRoom.MRBS.bean.MeetingRequestBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<marquee direction="right" scrollamount="12" behavior="scroll">MEETING
	ROOM BOOKING SYSTEM</marquee>
<meta charset="UTF-8">
<body>
	<%
		ArrayList<MeetingRequestBean> meetingrequests = (ArrayList<MeetingRequestBean>) session
				.getAttribute("meetingrequests");
	%>
	<table border="1" align="center">
		<thead>
			<tr>
				<th>ID</th>
				<th>START DATE</th>
				<th>END DATE</th>
				<th>START TIME</th>
				<th>ENDTIME</th>
				<th>USER</th>
				<th>MRNO</th>
				<th>RESOURCE</th>
				<th>STATUS</th>
			</tr>
		</thead>
		<tr>
			<%
				for (MeetingRequestBean meetingrequest : meetingrequests) {
					out.print("<tr><td>" + meetingrequest.getID() + "</td>" + "<td>" + meetingrequest.getStartdate()
							+ "</td>" + "<td>" + meetingrequest.getEnddate() + "</td>" + "<td>"
							+ meetingrequest.getStarttime() + "</td>" + "<td>" + meetingrequest.getEndtime() + "</td>"
							+ "<td>" + meetingrequest.getUser() + "</td>" + "<td>" + meetingrequest.getMR_no() + "</td>"
							+ "<td>" + meetingrequest.getResource() + "</td>" + "<td>" + meetingrequest.getStatus()
							+ "</td>");
				}
			%>
		</tr>
	</table>
	<br>
	<br>

</body>
</html>