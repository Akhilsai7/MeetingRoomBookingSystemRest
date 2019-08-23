package com.MeetingRoom.MRBS.resources;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.MeetingRoom.MRBS.bean.LoginBean;
import com.MeetingRoom.MRBS.bean.MeetingRequestBean;

@Path("UserFunctionalitiesRest")
public class UserFunctionalitiesRest {

	@POST
	@Path("RequestmeetingRoom")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String requestmeetingRoom(MeetingRequestBean meetingbean) {
		UserResource userresource = new UserResource();
		String status = userresource.requestMeetingRoom(meetingbean);
		if (status.equals("ADDED")) {
			return "UserFunctionalities.jsp";
		} else if (status.equals("NOTADDED")) {
			return "Error.jsp";
		}
		return "Error.jsp";

	}

	@POST
	@Path("cancelmeetingRoom")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String cancelmeetingRoom(MeetingRequestBean meetingbean) {
		UserResource userresource = new UserResource();
		String status = userresource.cancelMeetingRoom(meetingbean);
		if (status.equals("CANCELLED")) {
			return "CancelMeetingRoom.jsp";
		} else if (status.equals("CANNOTCANCEL")) {
			return "Error.jsp";
		}
		return "Error.jsp";

	}

}
