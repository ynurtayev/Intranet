
public abstract class Employee extends User {
	public Employee() {
		super();
	}
	
	public Employee(String id, String name, String surname, String username, String password) {
		super(id, name, surname, username, password);
	}
	
	public void sendOrder(Order order) {
		Data.getInstance().getOrders().add(order);
	}
	
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;
		return true;
	}
	
	public String toString() {
		return super.toString() + "\n";
	}
	
	public int hashcode() {
		return super.hashCode();
	}
}
