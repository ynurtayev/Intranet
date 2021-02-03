import java.io.IOException;

public class AdminMenu {
	
	public static void adminMenu(Admin admin) throws IOException {
		
		System.out.println("Choose one option:\n 1. Add user\n 2. Delete user\n 3. View list of users\n 4. View users' actions\n 5. View news\n 6. Log out\n");
		
		int option = Integer.parseInt(Menu.br.readLine());
		
		if (option == 1) {				//add user
			UserFactory uf = new UserFactory();
			User u = uf.createUser();
			Menu.getData().getUsers().add(u);
			System.out.println("You added the user " + u.getUsername());
			adminMenu(admin);
			return;
		}
		
		else if (option == 2) {			//delete user
			System.out.println("What is the username of User?");
			String username = Menu.br.readLine();
			
			if (admin.deleteUser(username)) 
				System.out.println("You deleted the user " + username);
			else 
				System.out.println("Invalid username");
			
			adminMenu(admin);
			return;
		}
		
		else if (option == 3) {			//view users
			System.out.println(admin.getUsers());
			adminMenu(admin);
			return;
		}
		
		else if (option == 4) {			//view users' actions
			System.out.println(admin.viewUsersActions());
			adminMenu(admin);
			return;
		}
		
		else if (option == 5) {
			System.out.println(admin.viewNews());
			adminMenu(admin);
			return;
		}
		
		else if (option == 6) {			//log out
			Menu.logOut(admin);
		}
		
		else {
			System.out.println("Invalid option");
			adminMenu(admin);
		}
	}
}
