<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<marquee direction="right" scrollamount="12" behavior="scroll">MEETING
	ROOM BOOKING SYSTEM</marquee>
<meta charset="UTF-8">
<title>Admin MRB</title>
</head>
<body align="center">
	<h2 align="center">Facility Manager Functionalities</h2>

	<h3>
		<a href="FacilityManagerServlet?varname=add">Add user</a>
	</h3>
	<h3>
		<a href="FacilityManagerServlet?varname=delete">Delete user</a>
	</h3>
	<h3>
		<a href="FacilityManagerServlet?varname=accept">Accept A Request</a>
	</h3>
	<h3>
		<a href="FacilityManagerServlet?varname=reject">Reject A Request</a>
	</h3>
	<h3>
		<a href="FacilityManagerServlet?varname=noofrequests">No of
			Meeting requests in A Day</a>
	</h3>
	<h3>
		<a href="FacilityManagerServlet?varname=monthrequests">Meeting
			Requests in a month</a>
	</h3>
	<h3>
		<a href="FacilityManagerServlet?varname=mostusedresource">No of
			times a resource is used</a>
	</h3>
	<h3>
		<a href="FacilityManagerServlet?varname=addmeetingroom">Add
			Meeting Room</a>
	</h3>
	<h3>
		<a href="FacilityManagerServlet?varname=addresource">Add resource</a>
	</h3>
	<a href="Login.jsp"><input type="button" value="LOGOUT"></a>
</body>
</html>