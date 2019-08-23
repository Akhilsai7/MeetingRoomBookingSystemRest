package com.MeetingRoom.MRBS.resources;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.MeetingRoom.MRBS.bean.MeetingRequestBean;

public class UserResource {

	public String requestMeetingRoom(MeetingRequestBean meetingbean) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(meetingbean);
		manager.getTransaction().commit();
		manager.close();
		return "ADDED";

	}

	public String cancelMeetingRoom(MeetingRequestBean meetingbean) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MRBS");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		int id = meetingbean.getID();
		Query query = entityManager.createQuery(
				"update MeetingRequestBean r set r.status='CANCELLED' where r.status='NEW' and r.ID =" + id);
		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		return "CANCELLED";

	}

	public ArrayList<String> getmeetingroom() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		ArrayList<String> sources = (ArrayList<String>) entityManager
				.createQuery("select distinct t.Meetingroomname from MeetingRoom t").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return sources;
	}

	public ArrayList<String> getResource() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		ArrayList<String> source = (ArrayList<String>) entityManager
				.createQuery("select distinct t.Resourcename from ResourceUsage t").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return source;
	}

}
