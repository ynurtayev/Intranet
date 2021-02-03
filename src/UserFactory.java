import java.io.IOException;

public class UserFactory {
	String name;
	String surname;
	String id;
	String username;
	String password;
	YearOfStudy yearOfStudy;
	Faculty faculty;
	Degree degree;
	TeacherTitle teacherTitle;

	public UserFactory() {}

	public void getUserData() throws IOException {
		System.out.println("Enter your name:");
		name = Menu.br.readLine();
		System.out.println("Enter your surname:");
		surname = Menu.br.readLine();
		System.out.println("Enter your id number: ");
		id = Menu.br.readLine();
		System.out.println("Create username: ");
		username = Menu.br.readLine();
		for (User u : Menu.getData().getUsers()) {
			if (u.getUsername().equals(username)) {
				System.out.println("The user with this username already exists! Please create another username: ");
				getUserData();
				return;
			}
		}
		System.out.println("Create password:");
		password = Menu.br.readLine();

	}

	public User createUser() throws IOException {
		getUserData();
		User user = null;
		System.out.println("Who are you?\n 1. Student\n 2. Teacher\n 3. OR Manager\n 4. Admin\n 5. Tech Support");
		int n = Integer.parseInt(Menu.br.readLine());
		if (n == 1) user = createStudent();
		else if (n == 2) user = createTeacher();
		else if (n == 3) user = createORManager();
		else if (n == 4) user = createAdmin();
		else if (n == 5) user = createTechSupportGuy();
		else {
			System.out.println("Invalid option\n");
			getUserData();
		}
		return user;
	}

	public Student createStudent() throws NumberFormatException, IOException {
		getStudentData();
		Student student = new Student(id, name, surname, username, password, faculty, yearOfStudy, degree);
		return student;
	}

	public void getStudentData() throws IOException {
		faculty = getFaculty();
		System.out.println("Year of study?");
		yearOfStudy = getYearOfStudy();
		degree = getDegree();

	}

	public Teacher createTeacher() throws NumberFormatException, IOException {
		getTeacherData();
		Teacher teacher = new Teacher(id, name, surname, username, password, teacherTitle, faculty);
		return teacher;
	}

	public void getTeacherData() throws NumberFormatException, IOException {
		getFaculty();
		getTitle();
	}

	public ORManager createORManager() {
		ORManager orManager = new ORManager(id, name, surname, username, password);
		return orManager;
	}

	public Admin createAdmin() {
		Admin admin = new Admin(id, name, surname, username, password);
		return admin;
	}

	public TechSupportGuy createTechSupportGuy() {
		TechSupportGuy tsg = new TechSupportGuy(id, name, surname, username, password);
		return tsg;
	}


	public Faculty getFaculty() throws NumberFormatException, IOException {
		System.out.println("What's your faculty?\n" + "1. FIT\n" + "2.BS\n" + "3.MCM\n" + "4.KMA\n" + "5.SCE\n" + 
				"6.FEOGI\n" + "7.FGE\n" + "8. ISE");
		Faculty faculty = null;
		int f = Integer.parseInt(Menu.br.readLine());
		if (f == 1) faculty = Faculty.FIT;
		else if (f == 2) faculty = Faculty.BS;
		else if (f == 3) faculty = Faculty.MCM;
		else if (f == 4) faculty = Faculty.KMA;
		else if (f == 5) faculty = Faculty.SCE;
		else if (f == 6) faculty = Faculty.FEOGI;
		else if (f == 7) faculty = Faculty.FGE;
		else if (f == 8) faculty = Faculty.ISE;
		else {
			System.out.println("Invalid option");
			getFaculty();
		}
		return faculty;
	}

	public Degree getDegree() throws IOException {
		System.out.println("What is your degree?\n" + "1. Bachelor\n" + "2. Master\n" + "3. Doctor");
		Degree degree = null;
		int d = Integer.parseInt(Menu.br.readLine());
		if (d == 1) degree = Degree.BACHELOR;
		else if (d == 2) degree = Degree.MASTER;
		else if (d == 3) degree = Degree.DOCTOR;
		else {
			System.out.println("Invalid option");
			getDegree();
		}
		return degree;
	}

	public YearOfStudy getYearOfStudy() throws NumberFormatException, IOException {
		System.out.println("For Students of which year?\n 1. First\n 2. Second\n 3. Third\n 4. Fourth");
		int year = Integer.parseInt(Menu.br.readLine());
		if (year == 1) return YearOfStudy.FIRST;
		else if (year == 2) return YearOfStudy.SECOND;
		else if (year == 3) return YearOfStudy.THIRD;
		else if (year == 4) return YearOfStudy.FOURTH;
		return getYearOfStudy();

	}

	public TeacherTitle getTitle() throws NumberFormatException, IOException {
		System.out.println("What's your position?\n" + "1. Lector\n" + "2. Tutor\n" + "3. Senior Lector\n" + "4. Professor\n");
		TeacherTitle title = null;
		int t = Integer.parseInt(Menu.br.readLine());
		if (t == 1) teacherTitle = TeacherTitle.LECTOR;
		else if (t == 2) teacherTitle = TeacherTitle.TUTOR;
		else if (t == 3) teacherTitle = TeacherTitle.SENIOR_LECTOR;
		else if (t == 4) teacherTitle = TeacherTitle.PROFESSOR;
		else {
			System.out.println("Invalid option");
			getTitle();
		}
		return teacherTitle;
	}




}
