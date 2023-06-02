package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Connection.DBConnection;
import Model.Students;



public class StudentDao {

	Session session = null;
	Transaction tx = null;
	List<Students> list = null;
	
	public void insertStudent(Students s) {
		
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
		System.out.println("data inserted");
	}
	
	public Students StudentLogin(Students s) {
		Students s1 = null;
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("from Students s where s.email=:email and s.password=:password");
		q.setParameter("email", s.getEmail());
		q.setParameter("password", s.getPassword());
		list = q.list();
		s1 = list.get(0);
		tx.commit();
		session.close();
		return s1;
	}
	public List<Students> getStudentById(int id){
		
		List<Students> list = new ArrayList<Students>();
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("from Students s where s.id=:id");
		q.setParameter("id", id);
		list = q.list();
		return list;
	}
	

	public void EditStudent(Students s) {
		session = new DBConnection().getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("update Students s set s.fname=?1,s.lname=?2,s.mobile=?3,s.gender=?4,s.email=?5,s.password=?6,s.image=?7 where s.id=?8");
		q.setParameter(1, s.getFname());
		q.setParameter(2, s.getLname());
		q.setParameter(3, s.getMobile());
		q.setParameter(4, s.getGender());
		q.setParameter(5, s.getEmail());
		q.setParameter(6, s.getPassword());
		q.setParameter(7, s.getImage());
		q.setParameter(8, s.getId());
		q.executeUpdate();
		tx.commit();
		session.close();
		System.out.println("data update");
		
	}
	
}
	
	

	
	