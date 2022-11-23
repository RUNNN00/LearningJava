package entities;

import java.util.Objects;

public class Course {

	private String name;
	private int studentCount;
	private Instructor instructor;
	
	public Course() {}
	
	public Course(String name, Instructor instructor) {
		this.name = name;
		this.instructor = instructor;
		instructor.addCourse(this);
		studentCount = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStudentCount() {
		return studentCount;
	}
	
	public void addStudent(Student student) {
		studentCount++;
		instructor.addStudent(student);
		student.addCourse(this);
	}
	
	public Instructor getInstructor() {
		return instructor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(instructor, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(instructor, other.instructor) && Objects.equals(name, other.name);
	}
}
