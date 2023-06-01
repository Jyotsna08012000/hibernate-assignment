package ManyToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	

	 public static void main(String[] args) {
		 
	   	  SessionFactory sf =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	   	  Session session= sf.openSession();
	         Transaction tx = session.beginTransaction();
	      
	         
	     Subscription sub =new Subscription();
	     Subscription sub1 =new Subscription();
	     sub.setSubscriptionId(1);
	     sub1.setSubscriptionId(2);
	     sub.setSubscriptionName("my channel");
	     sub1.setSubscriptionName("my new channel");
	     Reader red = new Reader(1,"liza@gmail.com","liza","meher");
	     Reader red1 = new Reader(2,"roja@gmail.com","roja","meher");
	     Reader red3 = new Reader(3,"roja08@gmail.com","roja08","meher");
	     Set<Reader> redset =new HashSet<Reader>();
	     redset.add(red);
	     redset.add(red1);
	     redset.add(red3);
	     sub.setReaders(redset);
	     sub1.setReaders(redset);
	    
	     
	     session.save(sub);
	     session.save(sub1);
		 session.save(red);
		 session.save(red1);
		 
		 session.update(red3);
		 
		 session.get(Subscription.class, 1);
		 session.get(Subscription.class, 2);
		 session.get(Reader.class, 1);
		 session.get(Reader.class, 2);
		 
		 session.delete(sub);
		 session.delete(red);
		 session.delete(red1);
		 
		    tx.commit();
			session.close();
			sf.close();
		 
			
 }
}
