package com.MeetingRoom.MRBS.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "resource")
public class ResourceUsage {

	@Id
	private String Resourcenumber;
	@NotNull
	private String Resourcename;

	public String getResourcenumber() {
		return Resourcenumber;
	}

	public void setResourcenumber(String resourcenumber) {
		Resourcenumber = resourcenumber;
	}

	public String getResourcename() {
		return Resourcename;
	}

	public void setResourcename(String resourcename) {
		Resourcename = resourcename;
	}

}
