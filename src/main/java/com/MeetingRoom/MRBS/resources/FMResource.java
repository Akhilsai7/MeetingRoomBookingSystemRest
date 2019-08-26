package com.MeetingRoom.MRBS.resources;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.MeetingRoom.MRBS.bean.LoginBean;
import com.MeetingRoom.MRBS.bean.MeetingRequestBean;
import com.MeetingRoom.MRBS.bean.MeetingRoom;
import com.MeetingRoom.MRBS.bean.ResourceUsage;

public class FMResource {

	
	
	public static String adduser(LoginBean login) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(login);

		System.out.println("Done");
		manager.getTransaction().commit();
		manager.close();
		return "ADDED";
	}
	
	public String deleteuser(LoginBean loginbean) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager manager = emf.createEntityManager();
		LoginBean log = manager.find(LoginBean.class, loginbean.getUsername());
		manager.getTransaction().begin();
		manager.remove(log);
		manager.getTransaction().commit();
		manager.close();
		return "DELETED";
	}

	public String accept(MeetingRequestBean meetingrequestbean) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		int id = meetingrequestbean.getID();
		Query query = entityManager.createQuery(
				"update MeetingRequestBean r set r.status='ACCEPTED' where r.status='NEW' and r.ID =" + id);
		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		return "ACCEPTED";
	}

	public String addMeetingroom(MeetingRoom meetingroom) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(meetingroom);
		manager.getTransaction().commit();
		manager.close();
		return "ADDED";

	}

	public String addResource(ResourceUsage resource) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(resource);
		manager.getTransaction().commit();
		manager.close();
		return "ADDED";
	}

	public String reject(MeetingRequestBean meetingrequestbean) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MRBS");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		int id = meetingrequestbean.getID();
		Query query = entityManager.createQuery(
				"update MeetingRequestBean r set r.status='REJECTED' where r.status='NEW' and r.ID =" + id);
		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		return "REJECTED";
	}

	public ArrayList<MeetingRequestBean> monthBookings(MeetingRequestBean meetingrequest) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MRBS");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select s from MeetingRequestBean s");
		@SuppressWarnings("unchecked")
		ArrayList<MeetingRequestBean> Arraylist = (ArrayList<MeetingRequestBean>) query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return Arraylist;

	}

	public ArrayList<MeetingRequestBean> Bookings(MeetingRequestBean meetingrequest) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MRBS");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select s from MeetingRequestBean s where s.status='NEW'");
		@SuppressWarnings("unchecked")
		ArrayList<MeetingRequestBean> Arraylist = (ArrayList<MeetingRequestBean>) query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return Arraylist;

	}

	public int dayRequests(MeetingRequestBean meetingrequestbean) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MRBS");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		String date = meetingrequestbean.getTimestamp();
		System.out.println(date);
		Query query = entityManager.createQuery("select s from MeetingRequestBean s where s.timestamp='" + date + "'");
		@SuppressWarnings("unchecked")
		ArrayList<MeetingRequestBean> Arraylist = (ArrayList<MeetingRequestBean>) query.getResultList();
		int result = Arraylist.size();
		entityManager.getTransaction().commit();
		return result;

	}

	public Long mostusedResource(MeetingRequestBean meetingrequestbean) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MRBS");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select count(resource) from MeetingRequestBean m where m.resource=: res").setParameter("res", meetingrequestbean.getResource());
		Long result = (Long) query.getSingleResult();
		entityManager.getTransaction().commit();
		System.out.println(result);
		entityManager.close();
		return result;
	}
}
