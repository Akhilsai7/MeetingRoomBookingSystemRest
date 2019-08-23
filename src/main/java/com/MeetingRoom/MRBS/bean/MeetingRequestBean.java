package com.MeetingRoom.MRBS.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Meeting_Request")
public class MeetingRequestBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	@NotNull
	private String startdate;
	@NotNull
	private String enddate;
	@NotNull
	private String starttime;
	@NotNull
	private String endtime;
	@NotNull

	private String user;
	@NotNull

	private String MR_no;

	private String resource;
	@NotNull
	private String status;

	private String timestamp;
	
	private String time;
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMR_no() {
		return MR_no;
	}

	public void setMR_no(String mR_no) {
		MR_no = mR_no;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "MeetingRequestBean [ID=" + ID + ", startdate=" + startdate + ", enddate=" + enddate + ", starttime="
				+ starttime + ", endtime=" + endtime + ", user=" + user + ", MR_no=" + MR_no + ", resource=" + resource
				+ ", status=" + status + ", timestamp=" + timestamp + "]";
	}

}
