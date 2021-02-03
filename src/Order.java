import java.io.Serializable;

public class Order implements Serializable{
	private int id;
	private String title;
	private String content;
	private OrderStatus orderStatus;
	
	public Order() {}
	public Order(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
		orderStatus = OrderStatus.PENDING;
	}
	public Order(int id, String title, String content, OrderStatus orderStatus) {
		this(id, title, content);
		this.orderStatus = orderStatus;
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String toString() {
		return "Order no: " + id + " " + title + "\n" + content + "\n";
	}
}
