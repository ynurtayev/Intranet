import java.util.ArrayList;

public class CourseStatistics {

	public CourseStatistics() {}

	public double getAverage(Course course) {
		boolean ok = false;
		double total = 0;
		int cnt = 0;
		double min = course.min;
		course.min = 110;
		ArrayList<Student> a = Menu.getData().getStudents();
		for (Student s : a) {
			if (s.getScores().containsKey(course) && s.getScores().get(course) != null) {
				ok = true;
				double score = s.getScores().get(course).getScore();
				total += score;
				cnt++;
				course.max = Math.max(score, course.max);
				course.min = Math.min(score, course.min);
			}
		}
		if (ok == false) course.min = min;
		if (course.min == 110) course.min = 0;
		if (cnt != 0) return total/cnt;
		return 0;
	}

	public double getHighest(Course course) {
		return course.max;
	}

	public double getLowest(Course course) {
		return course.min;
	}

	public String showReport(Course course) {
		return "Course name: " + course.name + "\nAverage score: " + getAverage(course) + "\nHighest score: " + getHighest(course) + 
				"\nLowest score: " + getLowest(course) + "\n";
	}
}
