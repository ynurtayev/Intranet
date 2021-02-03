import java.io.IOException;
import java.util.HashMap;

public class ORManagerMenu {

	public static void orManagerMenu(ORManager orManager) throws IOException {

		System.out.println("Choose one option: \n" + "1. Manage info\n" + "2. Manage courses\n" + "3. Register a student\n" + 
				"4. Send message\n" + "5. Add news\n" + "6. Delete news\n" + "7. View news\n" + "8. Log out\n");
		int option = Integer.parseInt(Menu.br.readLine());

		if (option == 1) { 				//manage info
			System.out.println("1. View Student's info\n" + "2. View Teacher's info\n" + "3. View Course's info\n" + "4. Back to Menu\n");
			int choice = Integer.parseInt(Menu.br.readLine());

			if (choice == 1) {			//view student's info
				System.out.println("What is the id of Student?");
				String id = Menu.br.readLine();
				System.out.println(orManager.findStudent(id));
				orManagerMenu(orManager);
				return;
			}
			
			else if (choice == 2) {		//view teacher's info
				System.out.println("What is the id of Teacher?");
				String id = Menu.br.readLine();
				System.out.println(orManager.findTeacher(id));
				orManagerMenu(orManager);
				return;
			}
			else if (choice == 3) {		//view course's info
				System.out.println("What is the id of Course?");
				String id = Menu.br.readLine();
				System.out.println(orManager.findCourse(id));
				orManagerMenu(orManager);
				return;
			}
			else if (choice == 4) {		//back to menu
				orManagerMenu(orManager);
			}
			else {
				System.out.println("Invalid option");
				orManagerMenu(orManager);
				return;
			}
		}
		else if (option == 2) {			//manage courses
			System.out.println("1. Add course\n" + "2. Delete course\n" + "3. View course info\n" + "4. Back to Menu\n");
			int choice = Integer.parseInt(Menu.br.readLine());
			
			if (choice == 1) {			//add course
				ObjectsFactory of = new ObjectsFactory(); 
				Course course = of.createCourse();
				if (orManager.addCourse(course))
					System.out.println("You succesfully added the course " + course.name);
				else 
					System.out.println("Invalid data or this Course is already exists");
				orManagerMenu(orManager);
				return;
			}

			else if (choice == 2) {		//delete course
				System.out.println(Menu.getData().getCourses());
				System.out.println("What is the id of Course that you want to delete?");
				String id = Menu.br.readLine();
				if (orManager.deleteCourse(id)) 
					System.out.println("You succesfully deleted the course " + id);
				else 
					System.out.println("This course doesn't exist");
				orManagerMenu(orManager);
				return;
			}

			else if (choice == 3) {		//view Course info
				System.out.println("What is the id of Course?");
				String id = Menu.br.readLine();
				System.out.println(orManager.findCourse(id));
				orManagerMenu(orManager);
				return;
			}
			else if (choice == 4) {		//back to menu
				orManagerMenu(orManager);
				return;
			}
			else {
				System.out.println("Invalid option");
				orManagerMenu(orManager);
				return;
			}
		}
		else if (option == 3) {			//register a student
			System.out.println("What is the id of Student?");
			String idStudent = Menu.br.readLine();
			System.out.println("What is the id of Course?");
			String idCourse = Menu.br.readLine();
			if (orManager.registerForCourse(idStudent, idCourse)) 
				System.out.println("You registered Student " + idStudent + " to a Course " + idCourse);
			else 
				System.out.println("Invalid data or Student " + idStudent + " is already registered to a Course " + idCourse);
			orManagerMenu(orManager);
			return;
		}

		else if (option == 4) {			//send a message
			ObjectsFactory of = new ObjectsFactory();	
			Message message = of.createMessage();
			System.out.println("Who is this Message for? Write only username, please");
			String username = Menu.br.readLine();
			if (orManager.sendMessage(username, message))
				System.out.println("You sent the message to " + username);
			else
				System.out.println("Invalid data");
			orManagerMenu(orManager);
			return;
		}
		
		else if (option == 5) {			//add news
			ObjectsFactory of = new ObjectsFactory();
			News news = of.createNews();
			orManager.addNews(news);
			System.out.println("You succesfully added the news");
			orManagerMenu(orManager);
		}
		else if (option == 6) {			//delete news
			System.out.println("What is the title of News?");
			String title = Menu.br.readLine();
			News news = null;
			for (News ns : Menu.getData().getNews()) {
				if (title.equals(ns.getTitle())){
					news = ns;
				}
			}
			if (orManager.deleteNews(news)) 
				System.out.println("You succesfully deleted these news");
			else 
				System.out.println("Non-existing news");
			orManagerMenu(orManager);
			return;
		}
		
		else if (option == 7) {
			System.out.println(orManager.viewNews());
			orManagerMenu(orManager);
			return;
		}
		
		else if (option == 8) {			//log out
			Menu.logOut(orManager);
			return;
		}
		
		else {				
			System.out.println("Invalid option");
			orManagerMenu(orManager);
			return;
		}
	}
}
