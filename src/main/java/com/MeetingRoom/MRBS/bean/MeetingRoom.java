package com.MeetingRoom.MRBS.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Meetingroom")
public class MeetingRoom {

	
	@Id
	private String Meetingroomnumber;
	@NotNull
	private String Meetingroomname;
	public String getMeetingroomnumber() {
		return Meetingroomnumber;
	}
	public void setMeetingroomnumber(String meetingroomnumber) {
		Meetingroomnumber = meetingroomnumber;
	}
	public String getMeetingroomname() {
		return Meetingroomname;
	}
	public void setMeetingroomname(String meetingroomname) {
		Meetingroomname = meetingroomname;
	}

}
