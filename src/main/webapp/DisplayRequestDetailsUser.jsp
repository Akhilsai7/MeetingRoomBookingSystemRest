<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.MeetingRoom.MRBS.bean.*" import="javax.persistence.EntityManager" import="javax.persistence.EntityManagerFactory"
    import="javax.persistence.Persistence" import="javax.persistence.Query" import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String username=(String)session.getAttribute("username");

	Query query;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
	EntityManager em = emf.createEntityManager();
	
	
	query = em.createQuery("select s from MeetingRequestBean s where s.status='NEW'and user='"+username+"'");
	
	
	List<MeetingRequestBean> list =(List<MeetingRequestBean>)query.getResultList();
	%>
	
	<div style="overflow: auto;height: 180px;">
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
				<th>TIMESTAMP</th>
				<th>TIME</th>
			</tr>
		</thead>
		<tr>
<% System.out.println("printing");
for(MeetingRequestBean meetingrequest:list){ %>

<tr><td><input type="text" value=<%=meetingrequest.getID()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getStartdate()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getEnddate()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getStarttime()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getEndtime()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getUser()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getMR_no()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getResource()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getStatus()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getTimestamp()%> readonly></td>
<td><input type="text" value=<%=meetingrequest.getTime()%> readonly></td></tr>

<% }%>

</table>
</div> 
	
</body>
</html>