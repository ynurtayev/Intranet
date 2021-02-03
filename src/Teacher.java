import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

public class Teacher extends Employee implements CanManageCourses, CanViewInfo{
	private TeacherTitle teacherTitle;
	private Faculty faculty;
	private Vector<Course> courses = new Vector<Course>();
	private ArrayList<Message> messages = new ArrayList<Message>();
	/** constructs an instance of class Teacher without arguments */
	public Teacher() {}
	public Teacher(String id, String name, String surname, String username, String password, TeacherTitle teacherTitle, Faculty faculty) {
		super(id, name, surname, username, password);
		this.teacherTitle = teacherTitle;
		this.faculty = faculty;
	}
	/** returns Teacher's title */
	public TeacherTitle getTitle() {
		return teacherTitle;
	}
	/** sets a Teacher's title */
	public void setTitle(TeacherTitle tt) {
		this.teacherTitle = tt;
	}
	/** returns a Teacher's faculty */
	public Faculty getFaculty() {
		return faculty;
	}
	/** sets a Teacher's faculty */
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	/** returns the courses of Teacher */
	public Vector<Course> getCourses(){
		return courses;
	}
	/** returns the messages of Teacher */
	public ArrayList<Message> getMessages(){
		return messages;
	}

	/** returns true, if given Course exists and adds it to list of courses, 
	 * 	if this Course is already exists in Teacher's list, then returns false */
	public boolean addCourse(Course course) {
		if (Menu.getData().getCourses().contains(course) && !this.courses.contains(course)) {
			this.courses.add(course);
			return true;
		}
		return false;
	}
	/** if given Course exists, deletes it from list of courses and returns true, 
	 * 	otherwise, returns false */
	public boolean deleteCourse(String id) {
		for (Course c : this.courses) {
			if (c.id.equals(id)) {
				this.courses.remove(c);
				return true;
			}
		}
		return false;
	}
	/** adds a Course File of given Course and returns true if this course exists,
	 * 	returns false, if given Course doesn't exist */
	public boolean addCourseFile(Course course, CourseFile courseFile) {
		if (this.courses.contains(course) && !course.getCourseFiles().contains(courseFile)) {
			course.getCourseFiles().add(courseFile);
			return true;
		}
		return false;
	}
	/** returns ArrayList of Course files of the given course */
	public ArrayList<CourseFile> viewCourseFiles(String id) {
		Course course = findCourse(id);
		return course.getCourseFiles();
	}
	/** returns true, if given course and course file exists and deletes course file, 
	 * 	otherwise, return false */
	public boolean deleteCourseFile(Course course, CourseFile courseFile) {
		if (course.getCourseFiles().contains(courseFile)) {
			course.getCourseFiles().remove(courseFile);
			return true;
		} 
		else
			return false;
	}
	
	/** returns an information about Student with given id*/
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
	/** returns an information about Teacher with given id*/
	public Teacher findTeacher(String login) {
		Teacher teacher = null;
		for (User u : Menu.getData().getUsers()) {
			if (u.getClass().getName().equals("Teacher")) {
				if (((Teacher)u).getUsername().equals(login)) {
					teacher = (Teacher)u;
				}
			}
		}
		return teacher;
	}
	/** returns an information about Course with given id*/
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
	/** returns true, if given Course and Students exist and adds Mark to Student's scores, 
	 * otherwise, returns false */
	public boolean putMark(String courseId, String studentId, Mark mark) {
		Course course = findCourse(courseId);
		Student student = findStudent(studentId);
		if (course != null && student != null) {
			for (HashMap.Entry<Course, Mark> hm : student.getScores().entrySet()) {
				Course key = hm.getKey();
				if (key != null && key.equals(course)) {
					student.getScores().replace(key, mark);
					return true;
				}
				return false;
			}
		}
		return false;
	}
	/** adds a new Order to Order's list */
	public void sendOrder(Order order) {
		Menu.getData().getOrders().add(order);
	}
	/** returns list of Students who are registered to the Course */
	public ArrayList<Student> getStudentsList(Course course) {
		ArrayList<Student> studentsList = null;
		for (User user : Menu.getData().getUsers()) {
			if (user.getClass().getName() == "Student") {
				Student s = (Student) user;
				if (((Student)user).getScores().containsKey(course))
					studentsList.add(s);
			}
		}
		return studentsList;
	}
	/** returns list of Teacher's Messages*/
	public ArrayList<Message> viewMessages(){
		return this.messages;
	}

	/** if instance of student equals to the object in argument, returns true,
	 * 	else, returns false */
	public boolean equals(Object object) {
		if (!super.equals(object)) return false;
		Teacher teacher = (Teacher)object;
		return true;
	}
	/** returns hasCode number for student */
	public int hashCode() {
		return super.hashCode() + Objects.hash(teacherTitle, faculty, courses);
	}
	/** returns string representation of student */
	public String toString() {
		return super.toString() + "Teacher position: " + teacherTitle + "\n" + "Faculty: " + faculty + 
				"\n" + "List of courses: " + courses + "\n" + "\n";
	}


}
