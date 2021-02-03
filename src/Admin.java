import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

public class Admin extends Employee implements CanManageUsers{
	public Admin() {}
	 public Admin(String id, String name, String surname, String username, String password) {
		  super(id, name, surname, username, password);
	}
	
	//Can Manage Courses
	public void addUser(User user) {
		Menu.getData().getUsers().add(user);
	}
		 
	public boolean deleteUser(String username) {
		for (User u : Menu.getData().getUsers()) {
			if (u.getUsername().equals(username)) {
				Menu.getData().getUsers().remove(u);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<User> getUsers() {
		return Menu.getData().getUsers();
	}
		 
	public ArrayList<String> viewUsersActions() {
		  return Menu.getData().getUsersActions();
	}
	
	
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;
		else return true;
	}
	public int hashcode() {
		return super.hashCode();
	}
	
}
