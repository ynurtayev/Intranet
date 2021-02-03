import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherMenu {
	
	public static void teacherMenu(Teacher teacher) throws IOException {
		
		System.out.println("Choose one: \n" + "1. Manage courses\n" + "2. Put mark\n" + "3. Send Order\n" + "4. View news\n" + 
												"5. View messages\n" + "6. Log out\n");
		int option = Integer.parseInt(Menu.br.readLine());
		
		if (option == 1) {				//manage courses
			System.out.println("1. Add course\n" + "2. Delete course\n" + "3. View course info\n" + "4. View Students list\n" + "5. Add course file\n" + 
								"6. Delete course file\n" + "7. View Course File\n" + "8. View course statistics\n" + "9. Back to Menu\n");
			int choice = Integer.parseInt(Menu.br.readLine());
			
			if (choice == 1) {			//add course
				System.out.println(Menu.getData().getCourses());
				System.out.println("What is the id of Course?");
				String id = Menu.br.readLine();
				Course course = teacher.findCourse(id);
				if (teacher.addCourse(course)) 
					System.out.println("You succesfully added the course " + course.name);
				else 
					System.out.println("This course doesn't exist");
				teacherMenu(teacher);
				return;
			}
			
			else if (choice == 2) {		//delete course
				System.out.println(teacher.getCourses());
				System.out.println("What is the id of Course that you want to delete?");
				String id = Menu.br.readLine();
				if (teacher.deleteCourse(id)) 
					System.out.println("You succesfully deleted the course " + id);
				else 
					System.out.println("This course doesn't exist or you are already added this course");
				teacherMenu(teacher);
				return;
			}
			
			else if (choice == 3) {		//view course info
				System.out.println("What is the id of Course?");
				String id = Menu.br.readLine();
				System.out.println(teacher.findCourse(id));
				teacherMenu(teacher);
				return;
			}
			
			else if (choice == 4) {
				System.out.println("What is the id of Course?");
				String id = Menu.br.readLine();
				Course course = teacher.findCourse(id);
				List<Student> studentsList = course.getStudentsList();
				Collections.sort(studentsList, new StudentGpaComparator());
				System.out.println(studentsList);
				teacherMenu(teacher);
				return;
			}
			
			else if (choice == 5) {		//add course file
				System.out.println(teacher.getCourses());
				System.out.println("What is the id of Course in which you want to add File?");
				String id = Menu.br.readLine();
				Course course = teacher.findCourse(id);
				
				ObjectsFactory of = new ObjectsFactory();
				CourseFile courseFile = of.createCourseFile();
				if (teacher.addCourseFile(course, courseFile)) 
					System.out.println("You added the File " + courseFile.getTitle());
				else 
					System.out.println("Invalid data");
				teacherMenu(teacher);
				return;
			}
			
			else if (choice == 6) {		//delete course file
				CourseFile cf = null;
				System.out.println("What is the id of Course?");
				String id = Menu.br.readLine();
				Course course = teacher.findCourse(id);
				
				System.out.println(teacher.viewCourseFiles(id));
				System.out.println("What is the title of Course File that you want to delete?");
				String title = Menu.br.readLine();
				for (CourseFile f : course.getCourseFiles()) {
					if (f.getTitle().equals(title))
						cf = f;
				}
				if (teacher.deleteCourseFile(course, cf))
					System.out.println("You succesfully deleted the course file " + title);
				else
					System.out.println("Non-existing file");
				teacherMenu(teacher);
				return;
			}
			
			else if (choice == 7) {		//view course file
				System.out.println(teacher.getCourses());
				System.out.println("What is the id of Course?");
				String id = Menu.br.readLine();
				System.out.println(teacher.viewCourseFiles(id));
				teacherMenu(teacher);
				return;
			}
			
			else if (choice == 8) {
				CourseStatistics cs = new CourseStatistics();
				System.out.println("What's id of Course?");
				String id = Menu.br.readLine();
				Course course = teacher.findCourse(id);
				if (course != null)
					System.out.println(cs.showReport(course));
				else
					System.out.println("There aren't any existing courses");
				teacherMenu(teacher);
				return;
			}
			
			else if (choice == 9) {		//back to menu
				teacherMenu(teacher);
				return;
			}
			else {
				System.out.println("Invalid option");
				teacherMenu(teacher);
				return;
			}
		}
		
		else if (option == 2) {			//put mark
			System.out.println(teacher.getCourses());
			System.out.println("What is the id of Course?");
			String idCourse = Menu.br.readLine();
			System.out.println("What is the id of Student?");
			String idStudent = Menu.br.readLine();
			
			ObjectsFactory of = new ObjectsFactory();
			Mark mark = of.createMark();
			if (teacher.putMark(idCourse, idStudent, mark)) 
				System.out.println("You succesfully put " + mark.getScore() + " to " + idStudent + " for the course " + idCourse);
			else 
				System.out.println("Invalid data");
			teacherMenu(teacher);
			return;
		}
		else if (option == 3) {			//send order
			ObjectsFactory of = new ObjectsFactory();
			Order order = of.createOrder();
			teacher.sendOrder(order);
			System.out.println("You sent the order!");
			teacherMenu(teacher);
			return;
		}
		
		else if (option == 4) {
			System.out.println(teacher.viewNews());
			teacherMenu(teacher);
			return;
		}
		
		else if (option == 5) {
			System.out.println(teacher.viewMessages());
			teacherMenu(teacher);
			return;
		}
		
		else if (option == 6) {			
			Menu.logOut(teacher);
			return;
		}
		
		else {
			System.out.println("Invalid option");
			teacherMenu(teacher);
			return;
		}
	}
}
