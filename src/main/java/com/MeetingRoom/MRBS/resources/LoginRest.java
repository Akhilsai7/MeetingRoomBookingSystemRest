package com.MeetingRoom.MRBS.resources;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.MeetingRoom.MRBS.bean.LoginBean;
import com.MeetingRoom.MRBS.Controller.*;

@Path("LoginRest")
public class LoginRest {

	@POST
	@Path("/Login")
	@Produces(MediaType.APPLICATION_JSON)
	public LoginBean Login(LoginBean login) {

		LoginBean login2;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		login2 = em.find(LoginBean.class, login.getUsername());
		em.getTransaction().commit();
		System.out.println(login2);
		return login2;

	}

}
