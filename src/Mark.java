import java.io.Serializable;

public class Mark implements Serializable{
	private double score;
	
	public Mark() {
		score = 0;
	}
	public Mark(double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	public String convertToLetter() {
		if (score >= 95 && score <= 100) return "A";
		else if (score >= 90 && score < 95) return "A-";
		else if (score >= 85 && score < 90) return "B+";
		else if (score >= 80 && score < 85) return "B";
		else if (score >= 75 && score < 80) return "B-";
		else if (score >= 70 && score < 75) return "C+";
		else if (score >= 65 && score < 70) return "C";
		else if (score >= 60 && score < 65) return "C-";
		else if (score >= 55 && score < 60) return "D+";
		else if (score >= 50 && score < 55) return "D";
		else return "F";
	}
	
	public String convertToText() {
		if (score >= 90 && score <= 100) return "Excellent";
		else if (score >= 75 && score < 90) return "Good";
		else if (score >= 50 && score < 75) return "Satisfactory";
		else return "Poor";
	}
	
	public double convertToGpa() {
		if (score >= 95 && score <= 100) return 4.00;
		else if (score >= 90 && score < 95) return 3.67;
		else if (score >= 85 && score < 90) return 3.33;
		else if (score >= 80 && score < 85) return 3.00;
		else if (score >= 75 && score < 80) return 2.67;
		else if (score >= 70 && score < 75) return 2.33;
		else if (score >= 65 && score < 70) return 2.00;
		else if (score >= 60 && score < 65) return 1.67;
		else if (score >= 55 && score < 60) return 1.33;
		else if (score >= 50 && score < 55) return 1.00;
		else return 0;
	}
	
	public String toString() {
		return "Score: " + score + " | Letter score: " + this.convertToLetter() + " | Digital score: " + this.convertToGpa() + " | Traditional score: " + this.convertToText();
	}
}
