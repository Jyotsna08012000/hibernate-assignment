package One_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Main {
	
	 public static void main(String[] args) {
   	  SessionFactory sf =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
   	  Session session= sf.openSession();
         Transaction tx = session.beginTransaction();
         
         
         Student s1= new Student();
         s1.setStudentId(1);
         s1.setStudentname("Subhum");
         
         Address a1 = new Address();
         a1.setAddressId(1);
         a1.setCity("sambalpur");
         a1.setState("Odisha");
         a1.setStreet("MD Street");
         a1.setZipCode(365498);
         
         Address a2 = new Address();
         a1.setAddressId(2);
         a1.setCity("Bargarh");
         a1.setState("Odisha");
         a1.setStreet("MSD Street");
         a1.setZipCode(365678);
         
         s1.setAddress(a1);
         a1.setStudent(s1);
       
         
         session.save(s1);
         session.save(a1);
         session.update(a2);
         session.get(Student.class, 1);
         session.delete(a1);
        
         
         tx.commit();
         session.close();
         sf.close();
         
	
	 }
}
