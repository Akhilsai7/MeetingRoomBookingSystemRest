package com.MeetingRoom.MRBS.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.MeetingRoom.MRBS.bean.LoginBean;
import com.MeetingRoom.MRBS.bean.MeetingRequestBean;
import com.MeetingRoom.MRBS.bean.MeetingRoom;
import com.MeetingRoom.MRBS.bean.ResourceUsage;

@Path("FacilityManagerRest")
public class FacilityManagerRest {

	@POST
	@Path("AddUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddUser(LoginBean login) {

		FMResource add = new FMResource();
		String status = add.adduser(login);
		if (status.equals("ADDED")) {
			return "FMFunctionalities.jsp";
		}

		return "Error.jsp";
	}

	@POST
	@Path("DeleteUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String DeleteUser(LoginBean loginbean) {
		FMResource add = new FMResource();
		String status = add.deleteuser(loginbean);
		if (status.equals("DELETED")) {
			return "FMFunctionalities.jsp";
		}

		return "Error.jsp";

	}

	@POST
	@Path("acceptrequest")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String Accept(MeetingRequestBean meetingrequestbean) {

		FMResource fmresource = new FMResource();
		String status = fmresource.accept(meetingrequestbean);
		if (status.equals("ACCEPTED")) {
			return "FMFunctionalities.jsp";
		}

		return "Error.jsp";

	}

	@POST
	@Path("rejectrequest")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String Reject(MeetingRequestBean meetingrequestbean) {

		FMResource acceptorreject = new FMResource();
		String status = acceptorreject.reject(meetingrequestbean);
		if (status.equals("REJECTED")) {
			return "FMFunctionalities.jsp";
		}

		return "Error.jsp";

	}

	@POST
	@Path("Addmeetingroom")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addMeetingroom(MeetingRoom meetingroom) {
		FMResource fmresource = new FMResource();
		String status = fmresource.addMeetingroom(meetingroom);
		if (status.equals("ADDED")) {
			return "FMFunctionalities.jsp";
		}

		return "Error.jsp";

	}

	@POST
	@Path("Addresource")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addResource(ResourceUsage resource) {
		FMResource fmresource = new FMResource();
		String status = fmresource.addResource(resource);
		if (status.equals("ADDED")) {
			return "FMFunctionalities.jsp";
		}

		return "Error.jsp";

	}

	@Path("monthbookings")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public ArrayList<MeetingRequestBean> viewbookings(MeetingRequestBean meetingrequest) {
		FMResource fmresource = new FMResource();
		ArrayList<MeetingRequestBean> status = fmresource.monthBookings(meetingrequest);
		return status;
	}

	@Path("bookings")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public ArrayList<MeetingRequestBean> bookings(MeetingRequestBean meetingrequest) {
		FMResource fmresource = new FMResource();
		ArrayList<MeetingRequestBean> status = fmresource.Bookings(meetingrequest);
		return status;
	}

	@Path("DayRequests")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int dayRequests(MeetingRequestBean meetingrequestbean) {
		FMResource fmresource = new FMResource();
		int status = fmresource.dayRequests(meetingrequestbean);
		return status;

	}
	
	@POST
	@Path("mostusedresource")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Long mostUsedResource(MeetingRequestBean meetingrequestbean) {
		FMResource fmresource = new FMResource();
		Long status = fmresource.mostusedResource(meetingrequestbean);
		return status;
	}
	

}
