package ManyToMany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Reader {
	@Id
	private int readerId; 
	private String email, firstName, lastName; 
	@ManyToMany
	private Set<Subscription> subscriptions;
	
	public Reader() {}
	
	
	public Reader(int readerId, String email, String firstName, String lastName) {
		this.readerId = readerId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		
	}

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", subscriptions=" + subscriptions + "]";
	}
	

}
