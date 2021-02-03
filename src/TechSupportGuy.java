import java.util.ArrayList;
import java.util.Vector;

public class TechSupportGuy extends Employee {
	
	public TechSupportGuy(String id, String name, String surname, String username, String password) {
		  super(id, name, surname, username, password);
		}
	
	public boolean acceptOrder(Order order) {
		if (Menu.getData().getOrders().contains(order)) {
			order.setOrderStatus(OrderStatus.ACCEPTED);
			return true;
		}
		else return false;
	}
	
	public boolean declineOrder(Order order) {
		if (Menu.getData().getOrders().contains(order)) {
			order.setOrderStatus(OrderStatus.REJECTED);
			Menu.getData().getOrders().remove(order);
			return true;
		}
		else return false;
	}
	
	public ArrayList<Order> viewNewOrders() {
		return Menu.getData().getOrders();
	}
	
	public boolean equals(Object object) {
		return super.equals(object);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}

