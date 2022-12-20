package application;

import java.util.Scanner;

import entities.Course;
import entities.Instructor;
import entities.Student;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Instructor instructor = new Instructor("Alex");
		
		for (int i = 65; i <= 67; i++) {
			Course course = new Course(" " + (char)i,	instructor);
			System.out.println("How many student for course " + course.getName() + "?");
			int n = scanner.nextInt();
			for (int j = 0; j < n; j++) {
				int code = scanner.nextInt();
				Student student = new Student(code);
				course.addStudent(student);
			}
		}
		
		System.out.println("Total students: " + instructor.getStudentQtd());

		scanner.close();
	}
}
