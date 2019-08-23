package com.MeetingRoom.MRBS.Controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.MeetingRoom.MRBS.bean.LoginBean;
import com.MeetingRoom.MRBS.bean.MeetingRequestBean;
import com.MeetingRoom.MRBS.bean.MeetingRoom;
import com.MeetingRoom.MRBS.bean.ResourceUsage;
import com.MeetingRoom.MRBS.resources.UserResource;

/**
 * Servlet implementation class FacilityManagerServlet
 */
public class FacilityManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacilityManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String option = request.getParameter("varname");
		if (option.equals("add"))
			response.sendRedirect("AddUser.jsp");
		else if (option.equals("adddetails")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			LoginBean loginbean = new LoginBean();
			loginbean.setUsername(username);
			loginbean.setPassword(password);
			loginbean.setRole(role);
			Client client = ClientBuilder.newClient(new ClientConfig());
			String apiURL = "http://localhost:8080/MRBS/webapi/FacilityManagerRest";
			WebTarget webTarget = client.target(apiURL).path("AddUser");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(loginbean, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			PrintWriter out = response.getWriter();
			response.sendRedirect(status);
		}
		if (option.equals("delete"))
			response.sendRedirect("DeleteUser.jsp");
		else if (option.equals("deletedetails")) {
			String username = request.getParameter("username");
			LoginBean loginbean = new LoginBean();
			loginbean.setUsername(username);
			Client client = ClientBuilder.newClient(new ClientConfig());
			String apiURL = "http://localhost:8080/MRBS/webapi/FacilityManagerRest";
			WebTarget webTarget = client.target(apiURL).path("DeleteUser");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(loginbean, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			PrintWriter out = response.getWriter();
			response.sendRedirect(status);
		}
		if (option.equals("accept")) {
			MeetingRequestBean meetingrequest = new MeetingRequestBean();
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8080/MRBS/webapi/FacilityManagerRest/bookings");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(meetingrequest, MediaType.APPLICATION_JSON));
			GenericType<ArrayList<MeetingRequestBean>> gType = new GenericType<ArrayList<MeetingRequestBean>>() {
			};
			ArrayList<MeetingRequestBean> meetingrequests = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("AcceptRequest.jsp");
			if (meetingrequests != null) {
				HttpSession session = request.getSession();
				session.setAttribute("meetingrequests", meetingrequests);
				dispatch.forward(request, response);
			}

		} else if (option.equals("acceptrequest")) {
			String Id = request.getParameter("requestid");
			System.out.println(Id);
			MeetingRequestBean meetingrequestbean = new MeetingRequestBean();
			meetingrequestbean.setID((Integer.parseInt(Id)));
			Client client = ClientBuilder.newClient(new ClientConfig());
			String apiURL = "http://localhost:8080/MRBS/webapi/FacilityManagerRest";
			WebTarget webTarget = client.target(apiURL).path("acceptrequest");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder
					.post(Entity.entity(meetingrequestbean, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			PrintWriter out = response.getWriter();
			response.sendRedirect(status);
		}
		if (option.equals("reject")) {
			MeetingRequestBean meetingrequest = new MeetingRequestBean();
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8080/MRBS/webapi/FacilityManagerRest/bookings");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(meetingrequest, MediaType.APPLICATION_JSON));
			GenericType<ArrayList<MeetingRequestBean>> gType = new GenericType<ArrayList<MeetingRequestBean>>() {
			};
			ArrayList<MeetingRequestBean> meetingrequests = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("RejectRequest.jsp");
			if (meetingrequests != null) {
				HttpSession session = request.getSession();
				session.setAttribute("meetingrequests", meetingrequests);
				dispatch.forward(request, response);
			}
		} else if (option.equals("rejectrequest")) {
			String Id = request.getParameter("requestid");
			MeetingRequestBean meetingrequestbean = new MeetingRequestBean();
			meetingrequestbean.setID((Integer.parseInt(Id)));
			Client client = ClientBuilder.newClient(new ClientConfig());
			String apiURL = "http://localhost:8080/MRBS/webapi/FacilityManagerRest";
			WebTarget webTarget = client.target(apiURL).path("rejectrequest");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder
					.post(Entity.entity(meetingrequestbean, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			PrintWriter out = response.getWriter();
			response.sendRedirect(status);
		}
		if (option.equals("noofrequests"))
			response.sendRedirect("DayRequests.jsp");
		else if (option.equals("DayRequestsMade")) {
			MeetingRequestBean meetingrequestbean = new MeetingRequestBean();
			meetingrequestbean.setTimestamp(request.getParameter("date"));
			System.out.println(request.getParameter("date"));
			Client client = ClientBuilder.newClient(new ClientConfig());
			String apiURL = "http://localhost:8080/MRBS/webapi/FacilityManagerRest";
			WebTarget webTarget = client.target(apiURL).path("DayRequests");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder
					.post(Entity.entity(meetingrequestbean, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			PrintWriter out = response.getWriter();
			System.out.println(status);
			RequestDispatcher dispatch = request.getRequestDispatcher("FMFunctionalities.jsp");
			dispatch.include(request, response);
			out.print("No of requests in a day are:"+status);
		}
		if (option.equals("monthrequests")) {
			MeetingRequestBean meetingrequest = new MeetingRequestBean();
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8080/MRBS/webapi/FacilityManagerRest/monthbookings");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(meetingrequest, MediaType.APPLICATION_JSON));
			GenericType<ArrayList<MeetingRequestBean>> gType = new GenericType<ArrayList<MeetingRequestBean>>() {
			};
			ArrayList<MeetingRequestBean> meetingrequests = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("MonthBookings.jsp");
			if (meetingrequests != null) {
				HttpSession session = request.getSession();
				session.setAttribute("meetingrequests", meetingrequests);
				dispatch.forward(request, response);
			}
			System.out.println("DONE");

		}

		if (option.equals("mostusedresource"))
		{
			ArrayList<String> resource = new UserResource().getResource();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("MostUsedResource.jsp");
			request.setAttribute("resources", resource);
			requestDispatcher.forward(request, response);
		}
		else if(option.equals("MostUsedResource"))
		{
			PrintWriter out = response.getWriter();
			MeetingRequestBean meetingrequest = new MeetingRequestBean();
				meetingrequest.setResource(request.getParameter("Resource_no"));
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8080/MRBS/webapi/FacilityManagerRest/mostusedresource");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(meetingrequest, MediaType.APPLICATION_JSON));
			Long status = clientResponse.readEntity(Long.class);
			RequestDispatcher dispatch = request.getRequestDispatcher("FMFunctionalities.jsp");
			dispatch.include(request, response);
			out.print("The Resource used is "+request.getParameter("Resource_no")+" and it is used " +status+" times");
			
		}

		if (option.equals("addmeetingroom"))
			response.sendRedirect("AddMeetingRoom.jsp");
		else if (option.equals("AddMeeting")) {
			MeetingRoom meetingroom = new MeetingRoom();
			meetingroom.setMeetingroomnumber(request.getParameter("meetingroomid"));
			meetingroom.setMeetingroomname(request.getParameter("meetingroomname"));
			Client client = ClientBuilder.newClient(new ClientConfig());
			String apiURL = "http://localhost:8080/MRBS/webapi/FacilityManagerRest";
			WebTarget webTarget = client.target(apiURL).path("Addmeetingroom");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(meetingroom, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			PrintWriter out = response.getWriter();
			response.sendRedirect(status);
		}
		if (option.equals("addresource"))
			response.sendRedirect("AddResource.jsp");
		else if (option.equals("AddResource")) {
			ResourceUsage resource = new ResourceUsage();
			resource.setResourcenumber(request.getParameter("resourceid"));
			resource.setResourcename(request.getParameter("resourcename"));
			Client client = ClientBuilder.newClient(new ClientConfig());
			String apiURL = "http://localhost:8080/MRBS/webapi/FacilityManagerRest";
			WebTarget webTarget = client.target(apiURL).path("Addresource");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(resource, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			PrintWriter out = response.getWriter();
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
