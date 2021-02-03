import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Menu {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Date date = new Date();
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	Student student;
	Teacher teacher;
	ORManager orManager;
	Admin admin;
	TechSupportGuy techSupportGuy;
	private static Data data;
	/** constructs instance of Menu without arguments */
	public Menu() {}
	/** returns an instance of Data */
	public static Data getData() {
		return data;
	}
	/** creates instance of Data, deserializes object from File, calls Main Menu, then serializes it again*/
	public void start() throws IOException, ClassNotFoundException {
		
		data = Data.getInstance();
		data = deserialize(data);
		mainMenu();
		serialize(data);
	}
	/** reads Object from File ands saves it ti Data */
	public Data deserialize(Data data) throws IOException, ClassNotFoundException, EOFException {
		try {
			FileInputStream fis = new FileInputStream("data.out");
			ObjectInputStream ois = new ObjectInputStream(fis);
			data = (Data) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			data = Data.getInstance();
		}
		return data;
	}
	/** writes Data to File */
	public void serialize(Data data) throws IOException {
		FileOutputStream fos = new FileOutputStream("data.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(data);
		oos.close();
		fos.close();
	}


	/** shows two options: login and register;
	 * 	calls method login, if User chose first option, 
	 * 	creates an User's object and calls method register, if chose second option */
	public void mainMenu() throws IOException, ClassNotFoundException {
		System.out.println("Welcome to KBTU's uninet!\n 1. Login \n 2. Register");
		try {
			int s = Integer.parseInt(br.readLine());
			if (s == 1) {
				System.out.println("Enter your username: ");
				String username = br.readLine();

				System.out.println("Enter your password: ");
				String password = br.readLine();
				login(username, password);
			}
			else if (s == 2) {
				UserFactory uf = new UserFactory();
				User user = uf.createUser();
				register(user);
			}
			else {
				System.out.println("Invalid option");
				mainMenu();
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Number format error!");
		}
	}
	/** if User with same username and password exists, shows an appropriate Menu, then saves User's action f*/
	public static void login(String username, String password) throws IOException {
		for (User u : data.getUsers()) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				data.getUsersActions().add(formatter.format(date) + ": User " + username + " logged in.\n");
				String className = u.getClass().getName();
				if (className.equals("Student")) {
					StudentMenu.studentMenu((Student)u);
					return;
				}
				else if (className.equals("Teacher")) {
					TeacherMenu.teacherMenu((Teacher)u);
					return;
				}
				else if (className.equals("ORManager")) {
					ORManagerMenu.orManagerMenu((ORManager)u);
					return;
				}
				else if (className.equals("Admin")) {
					AdminMenu.adminMenu((Admin)u);
					return;
				}
				else if (className.equals("TechSupportGuy")) {
					TechSupportGuyMenu.techSupportGuyMenu((TechSupportGuy)u);
					return;
				}
			}
		}
		System.out.println("Invalid login or password");
		return;
	}
	/** adds User to User's list, saves the User's action, then calls login method */
	public static void register(User user) throws FileNotFoundException, IOException, ClassNotFoundException {
		data.getUsers().add(user);
		System.out.println("You registered succesfully!");
		data.getUsersActions().add(formatter.format(date) + ": User " + user.getUsername() + " registered.\n");
		login(user.getUsername(), user.getPassword());
		return;
	}
	/** save User's action and log out */
	public static void logOut(User user) throws FileNotFoundException, IOException {
		System.out.println("You're logged out");
		data.getUsersActions().add(formatter.format(date) + "User " + user.getUsername() + " logged out.\n");
		return;
	}

}