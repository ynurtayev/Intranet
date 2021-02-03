import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable{
	String id;
	String name;
	String description;
	int credits;
	YearOfStudy yearOfStudy;
	ArrayList<Course> prerequisites = new ArrayList<Course>();
	private ArrayList<CourseFile> courseFiles = new ArrayList<CourseFile>();
	double max;
	double min;

	public Course () {}
	public Course(String id, String name, String description, int credits, YearOfStudy yearOfStudy) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.credits = credits;
		this.yearOfStudy = yearOfStudy;
		max = 0;
		min = 110;
	}

	public ArrayList<Student> getStudentsList() {
		ArrayList<Student> studentsList = new ArrayList<Student>();
		for (User user : Menu.getData().getUsers()) {
			if (user.getClass().getName().equals("Student")) {
				Student s = (Student) user;
				if (s.getScores().containsKey(this))
					studentsList.add(s);
			}
		}
		return studentsList;
	}


	public String getTeachersList(){
		String s = "";
		for (User user : Menu.getData().getUsers()) {
			if (user.getClass().getName().equals("Teacher")) {
				Teacher t = (Teacher) user;
				if (t.getCourses().contains(this))
					s += t.getName() + " " + t.getSurname() + ", ";
			}
		}
		return s;
	}

	public ArrayList<CourseFile> getCourseFiles() {
		return courseFiles;
	}

	public void addPrerequisite(String id) {
		for (Course c : Menu.getData().getCourses()) {
			if (c.id.equals(id)) {
				this.prerequisites.add(c);
			}
		}
		return;
	}

	public String toString() {
		return "ID: " + id + "\n" + "Name: " + name + "\n" + "Description: " + description + "\n" + "Credits: " + 
				credits + "\n" + "Year: " + yearOfStudy + "\n" + "Teachers: " + getTeachersList() + "\n" + "Prerequisites: " + prerequisites;
	}
}
