
public class ORManager extends Employee implements CanManageCourses, CanViewInfo {

	public ORManager() {
		super();
	}
	
	public ORManager(String id, String name, String surname, String username, String password) {
		super(id, name, surname, username, password);
	}

	// can manage courses
	public boolean addCourse(Course course) {
		if (course.equals(null) || Menu.getData().getCourses().contains(course))
			return false;
		else {
			Menu.getData().getCourses().add(course);
			return true;
		}
	}
	public boolean deleteCourse(String id) {
		for (Course c : Menu.getData().getCourses()) {
			if (c.id.equals(id)) {
				Menu.getData().getCourses().remove(c);
				return true;
			}
		}
		return false;
	}

	//can view info
	public Student findStudent(String id) {
		Student student = null;
		for (User u : Menu.getData().getUsers()) {
			if (u.getClass().getName().equals("Student")) {
				if (((Student)u).getId().equals(id)) {
					student  = (Student)u;
				}
			}
		}
		return student;
	}
	public Teacher findTeacher(String id) {
		Teacher teacher = null;
		for (User u : Menu.getData().getUsers()) {
			if (u.getClass().getName().equals("Teacher")) {
				if (((Teacher)u).getId().equals(id)) {
					teacher = (Teacher)u;
				}
			}
		}
		return teacher;
	}
	public Course findCourse(String id) {
		Course course = null;
		for (Course c : Menu.getData().getCourses()) {
			if ((c.id).equals(id)) {
				course = c;
				return course;
			}
		}
		return course;
	}
	
	public boolean registerForCourse(String studentId, String courseId) {
		Student student = findStudent(studentId);
		Course course = findCourse(courseId);
		if (student != null && course != null) {
			if (!student.getScores().containsKey(course) && student.getYearOfStudy().equals(course.yearOfStudy)) {{
				int a = course.credits;
				if (student.countCredits + a <= 20) {
					student.countCredits += a;
					student.getScores().put(course, null);
					return true;
				}
			}
			}
		}
		return false;
	}

	public boolean sendMessage(String username, Message message) {
		Teacher teacher = findTeacher(username);
		if (teacher != null) {
			teacher.getMessages().add(message);
			return true;
		}
		return false;
	}

	public void addNews(News news) {
		Menu.getData().getNews().add(news);
	}

	public boolean deleteNews(News news) {
		if (Menu.getData().getNews().contains(news)) {
			Menu.getData().getNews().remove(news);
			return true;
		}
		return false;
	}


	public boolean equals(Object o) {
		if (!super.equals(o)) return false;
		else return true;
	}

	public String toString() {
		return super.toString();
	}

	public int hashcode() {
		return super.hashCode();
	}
}
