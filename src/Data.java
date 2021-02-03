import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
	private static final Data INSTANCE = new Data();

	private ArrayList<User> users;
	private ArrayList<Order> orders;
	private ArrayList<News> news;
	private ArrayList<Course> courses;
	private ArrayList<String> usersActions;


	private Data() {
		users = new ArrayList<User>();
		orders = new ArrayList<Order>();
		news = new ArrayList<News>();
		courses = new ArrayList<Course>();
		usersActions = new ArrayList<String>();
	}

	public static Data getInstance() {
		return INSTANCE;
	}

	public ArrayList<User> getUsers(){
		return users;
	}
	public ArrayList<Order> getOrders(){
		return orders;
	}
	public ArrayList<News> getNews(){
		return news;
	}
	public ArrayList<Course> getCourses(){
		return courses;
	}
	public ArrayList<String> getUsersActions(){
		return usersActions;
	}
	
	public ArrayList<Student> getStudents(){
		ArrayList<Student> a = new ArrayList<Student>();
		for (User u : users) {
			if (u.getClass().getName().equals("Student"))
				a.add((Student)u);
		}
		return a;
	}

	public String viewOrders() {
		String s = "";
		for (Order o : orders) {
			s += o.toString();
		}
		return s;
	}

	public String viewOrders(OrderStatus orderStatus) {
		String s = "";
		for (Order o : orders) {
			if (orderStatus == o.getOrderStatus()) {
				s += o.toString();
			}
		}
		return s;
	}

	public String toString() {
		return this.users.toString() + " " + this.courses.toString() + " " + this.orders.toString() + " " + this.news.toString() + "\n";
	}
}