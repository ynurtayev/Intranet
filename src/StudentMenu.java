import java.io.IOException;

public class StudentMenu {
	
	public static void studentMenu(Student student) throws NumberFormatException, IOException {
		
		System.out.println("Choose one: \n" + "1. Register for a course\n" + "2. View Transcript\n" + "3. View my courses\n" + 
											"4. View Course Statistics\n" + "5. My infromation\n" + "6. View news\n" + "7. Log out\n");
		int option = Integer.parseInt(Menu.br.readLine());
		
		if (option == 1) {				//register for a course
			System.out.println(Menu.getData().getCourses());
			System.out.println("Choose the course id: \n");
			String id = Menu.br.readLine();
			System.out.println(student.registerForCourse(id));
			studentMenu(student);
			return;
		}
		
		else if (option == 2) { 		//view transcript
			System.out.println(student.viewTranscript());
			studentMenu(student);
			return;
		}
		
		else if (option == 3) {			//view my courses
			System.out.println(student.viewMyCourses());
			studentMenu(student);
			return;
		}
		
		else if (option == 4) {
			CourseStatistics cs = new CourseStatistics();
			System.out.println("What's id of Course?");
			String id = Menu.br.readLine();
			Course course = null;
			for (Course c : Menu.getData().getCourses()) {
				if ((c.id).equals(id)) {
					course = c;
				}
			}
			if (course != null )
				System.out.println(cs.showReport(course));
			else
				System.out.println("There aren't any courses");
			studentMenu(student);
			return;
		}
		
		else if (option == 5) {			//view my info
			System.out.println(student.toString());
			studentMenu(student);
			return;
		}
		
		else if (option == 6) {
			System.out.println(student.viewNews());
			studentMenu(student);
			return;
		}
		
		else if (option == 7) {			//log out
			Menu.logOut(student);
			return;
		}
			
		else {
			System.out.println("Invalid option");
			studentMenu(student);
			return;
		}
	}
}
