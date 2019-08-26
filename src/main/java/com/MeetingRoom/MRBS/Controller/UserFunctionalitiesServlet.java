package com.MeetingRoom.MRBS.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.MeetingRoom.MRBS.bean.MeetingRequestBean;
import com.MeetingRoom.MRBS.bean.MeetingRoom;
import com.MeetingRoom.MRBS.bean.ResourceUsage;
import com.MeetingRoom.MRBS.resources.UserResource;

/**
 * Servlet implementation class UserFunctionalitiesServlet
 */
public class UserFunctionalitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserFunctionalitiesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime nowtime = LocalDateTime.now();
		HttpSession session = request.getSession();
		
		
		//This method is used to Request a meeting room and it passes to UserFunctionalitiesRest
		String option = request.getParameter("varname");
		if (option.equals("request")) {
			ArrayList<String> meeting = new UserResource().getmeetingroom();
			ArrayList<String> resource = new UserResource().getResource();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("RequestMeetingRoom.jsp");
			request.setAttribute("meetingrooms", meeting);
			request.setAttribute("resources", resource);
			requestDispatcher.forward(request, response);
		} else if (option.equals("requestmeetingroom")) {

			MeetingRequestBean meetingbean = new MeetingRequestBean();
			meetingbean.setMR_no(request.getParameter("Meetingroom_no"));
			meetingbean.setStartdate(request.getParameter("startdate"));
			meetingbean.setEnddate(request.getParameter("enddate"));
			meetingbean.setStarttime(request.getParameter("starttime"));
			meetingbean.setEndtime(request.getParameter("endtime"));
			meetingbean.setResource(request.getParameter("Resource_no"));
			meetingbean.setStatus("NEW");
			meetingbean.setTimestamp(dtf.format(now));
			meetingbean.setTime(dtf1.format(nowtime));
			String username = (String) session.getAttribute("username");
			meetingbean.setUser(username);
			System.out.println(session.getAttribute("username"));
			Client client = ClientBuilder.newClient(new ClientConfig());
			String apiURL = "http://localhost:8080/MRBS/webapi/UserFunctionalitiesRest";
			WebTarget webTarget = client.target(apiURL).path("RequestmeetingRoom");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(meetingbean, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			response.sendRedirect(status);

		}
		
		
		//This method is used to cancel a Meeting room and it passes to UserFunctionalitiesRest
		if (option.equals("cancel")) {
			response.sendRedirect("CancelMeetingRoom.jsp");
		} else if (option.equals("cancelmeetingroom")) {
			MeetingRequestBean meetingbean = new MeetingRequestBean();
			int id = (Integer.parseInt(request.getParameter("id")));
			meetingbean.setID(id);
			Client client = ClientBuilder.newClient(new ClientConfig());
			String apiURL = "http://localhost:8080/MRBS/webapi/UserFunctionalitiesRest";
			WebTarget webTarget = client.target(apiURL).path("cancelmeetingRoom");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(meetingbean, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			response.sendRedirect(status);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}