package OneToMany;

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
	         
	        Cart cart = new Cart();
	 		cart.setName("MyCart");
	 	   Items item1 = new Items("I1", 10, 1, cart);
	 		Items item2 = new Items("I2", 20, 2, cart);
	 		Set<Items> itemsSet = new HashSet<Items>();
	 		itemsSet.add(item1); itemsSet.add(item2);
	 		cart.setItems(itemsSet);
	 		cart.setTotal(10*1 + 20*2);
	 		
	 		
	 		  Items item3 = new Items("I3", 19, 3 , cart);
		 		Items item4 = new Items("I4", 29, 4, cart);
		 		Set<Items> itemsSet1 = new HashSet<Items>();
		 		itemsSet1.add(item3); itemsSet1.add(item4);
		 		cart.setItems(itemsSet1);
		 		cart.setTotal(19*3 + 29*4);
	 		
	 		session.save(cart);
			session.save(item1);
			session.save(item2);
			
			
			session.update(item3);
			
			
			session.get(Cart.class, 5);
			
			session.delete(cart);
			 session.delete(item1);
			 session.delete(item2);
			
			
			tx.commit();
			session.close();
			sf.close();
	         
	         
	         
	         

	 }
}
