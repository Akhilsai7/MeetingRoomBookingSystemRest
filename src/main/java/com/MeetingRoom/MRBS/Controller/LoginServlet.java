package com.MeetingRoom.MRBS.Controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.MeetingRoom.MRBS.bean.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals(null) || username.equals("") || password.equals(null) || password.equals("")) {
			response.sendRedirect("Login.jsp");

		}
		LoginBean loginbean = new LoginBean();
		loginbean.setUsername(username);
		loginbean.setPassword(password);

		Client client = ClientBuilder.newClient(new ClientConfig());

		String apiURL = "http://localhost:8080/MRBS/webapi/LoginRest";
		WebTarget webTarget = client.target(apiURL).path("Login");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

//		System.out.println(" ->" + loginbean);

		Response clientResponse = invocationBuilder.post(Entity.entity(loginbean, MediaType.APPLICATION_JSON));

		LoginBean validate = clientResponse.readEntity(LoginBean.class);

//		System.out.println("--------> " + validate);
		String role = validate.getRole();
		if (role != null) {
			if (validate.getRole().equals("FM") && validate.getPassword().equals(loginbean.getPassword())) {

				response.sendRedirect("FMFunctionalities.jsp");

			} else {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);

				response.sendRedirect("UserFunctionalities.jsp");

			}

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
