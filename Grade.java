// This class is the Grade class

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Grade {

	private double grade;
	private double maxGrade;
	private static DecimalFormat df = new DecimalFormat("0.00");
	// for rounding my grades to 2 decimal places
	
	public Grade() {
		grade = 0.0;
		maxGrade = 0.0;
		
		
	}
	
	// addGrade() accept a string as a parameter
	// and adds all the grade to the appropriate variables
	public void addGrade(String grade) {
		
		String [] gradeArr = grade.split(",");
		
		for(int i=0; i<gradeArr.length; i++) {
			// grade is a string of the format grade/maxGrade
			try {
				String[] arr = gradeArr[i].split("/");
				System.out.println(arr[0]);
				this.grade += Double.parseDouble(arr[0]);
				this.maxGrade += Double.parseDouble(arr[1]);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
	
	// toString() displays the overall grade of a student 
	public String toString() {
		return "Your overall grade is "+this.grade+ " over "+this.maxGrade+ 
				 ", which is "+ df.format(this.grade*100/(this.maxGrade)) + "%";
	}
	
	public String toGetA () {
		if(grade/maxGrade > 0.9) {
			return "Excellent! You crushed your exams! You already have an A";
		}
		return "You need "+ df.format(this.maxGrade*.9-grade) +" more points to get an A";
	}
	
	public String toGetB () {
		if(grade/maxGrade > 0.8) {
			return "Congrats! You already have an B";
		}
		return "You need at least "+ df.format(this.maxGrade*.8-grade) +" more points to get an B";
	}

	public String toGetC () {
		if(grade/maxGrade > 0.7) {
			return "Congrats! You have passed this class!";
		}
		return "You need "+ df.format(this.maxGrade*.7-grade) +" more points to pass this class";
	}

}
