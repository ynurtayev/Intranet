import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable, Comparable<User>, Cloneable {
	private String id;
	private String name;
	private String surname;
	private String password;
	private String username;
	
	public User() {};
	public User(String username) {
		this.username = username;
		this.password = "KBTU123";
	}
	public User(String id, String name, String surname, String username, String password) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String viewNews() {
		String s = "";
		for (News news : Menu.getData().getNews()) {
			s += news.toString() + "\n";
		}
		return s;
	}
	
	public int compareTo(User user) {
		return (this.username).compareTo(user.getUsername());
	}
	
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;
		User u = (User) o;
		return id.equals(u.getId()) && name.equals(u.getName()) && surname.equals(u.getSurname()) && 
				username.equals(u.getUsername()) && password.equals(u.getPassword());
	}
	
	public int hashCode() {
		return Objects.hash(id, name, surname, username, password);
	}
	
	public String toString() {
		return "ID: " + id + "\n" + "Name: " + name + "\n" + "Surname: " + surname + "\n" + "Username: " + username; 
	}
}
