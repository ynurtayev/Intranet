import java.util.HashMap;
import java.util.Objects;


public class Student extends User {
	private Faculty faculty;
	private double gpa;
	private YearOfStudy yearOfStudy;
	private Degree degree;
	private HashMap<Course, Mark> scores = new HashMap<Course, Mark>();
	int countCredits;
	/** constructs a student's instance without any arguments */
	public Student() {}
	/** constructs a student's instance with given arguments (id, name, surname, username, password, faculty, year of study, degree) */
	public Student(String id, String name, String surname, String username, String password, Faculty faculty, YearOfStudy yearOfStudy, Degree degree) {
		super(id, name, surname, username, password);
		this.degree = degree;
		this.faculty = faculty;
		this.yearOfStudy = yearOfStudy;
		this.countCredits = 0;
	}
	/** returns the faculty of student */
	public Faculty getFaculty(){
		return faculty;
	}
	/** sets the faculty of student */
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	/** returns the GPA of student */
	public double getGpa() {
		return gpa;
	}
	/** sets the GPA of student*/
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	/** return year of study */
	public YearOfStudy getYearOfStudy() {
		return yearOfStudy;
	}
	/** sets a year of study */
	public void setYearOfStudy(YearOfStudy yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	/** returns a degree of student */
	public Degree getDegree() {
		return degree;
	}
	/** sets a degree of student */
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	/** returns the marks of courses for student */
	public HashMap<Course, Mark> getScores(){
		return scores;
	}
	/** registers for a course with given id */
	public String registerForCourse(String id) {
		for (Course course : Menu.getData().getCourses()) {
			if (course.id.equals(id) && !scores.containsKey(course)) {
				if (course.yearOfStudy.equals(this.yearOfStudy)) {
					int a = course.credits;
					if (countCredits + a <= 20) {
						countCredits += a;
						this.scores.put(course, null);
						return "You registered succesfully!";
					}
					else return "The credits overflow";
				}
				else return "This course isn't available for you now";
			}
		}
		return "Invalid data";
	}
	/** returns the student's registered courses */
	public String viewMyCourses(){
		String s = "";
		for (HashMap.Entry<Course, Mark> hm : scores.entrySet()) {
            Course key = hm.getKey();
            if (key != null)
            	s += key.toString() + "\n";
		}
		return s;
	}
	/** returns transcript(courses, their scores and average GPA) */
	public String viewTranscript() {
		String s = "";
		for (HashMap.Entry<Course, Mark> hm : scores.entrySet()) {
            Course key = hm.getKey();
            Mark values = hm.getValue();
            if (values != null)
            	s += key.name + " " + values.toString() + "\n";
            else 
            	s += key.name + "\n";
		}
		return s + "Average GPA: " + viewGpa();
	}
	/** returns average GPA of student */
	public double viewGpa() {
		for (HashMap.Entry<Course, Mark> hm : scores.entrySet()) {
			Course key = hm.getKey();
			Mark values = hm.getValue();
			double totalGPA = 0;
			int cnt = 0;
			if (values != null) {
				totalGPA += values.convertToGpa();
				cnt++;
			}
			else continue;
			this.gpa = totalGPA/cnt;
		}
		return gpa;
	}
	/** if instance of student equals to object in argument, returns true,
	 * 	else, returns false */
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;
		Student s = (Student) o;
		return yearOfStudy == s.getYearOfStudy() && gpa == s.getGpa() && degree.equals(s.getDegree()) && 
				faculty.equals(s.getFaculty()) && scores.equals(s.getScores());
	}
	/** returns hasCode number for student */
	public int hashCode() {
		return super.hashCode() + Objects.hash(yearOfStudy, gpa, degree, faculty) + scores.hashCode();
	}
	/** returns clone of student's instance */
	public Object clone(Object o) throws CloneNotSupportedException {
		Student s = (Student)super.clone();
		s.scores = (HashMap<Course, Mark>)this.scores.clone();
		return s;
	}
	/** returns string representation of student */
	public String toString() {
		return super.toString() + "\n" + "Faculty: " + faculty + "\n" + "Degree: " + degree + "\n" + 
								"Year of study: " + yearOfStudy + "\n" + "GPA: " + gpa + "\n" + "\n";
	}
}
