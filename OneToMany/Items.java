package OneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String itemId;
	private double itemTotal;
	private int quantity;
	@ManyToOne
	private Cart cart;
	
public Items(){}
	
	public Items(String itemId, double total, int qty, Cart c){
		this.itemId=itemId;
		this.itemTotal=total;
		this.quantity=qty;
		this.cart=c;
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public double getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", itemId=" + itemId + ", itemTotal=" + itemTotal + ", quantity=" + quantity
				+ ", cart=" + cart + "]";
	}
	
	

}
