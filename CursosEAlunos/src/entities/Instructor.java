package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Instructor {

		private String name;
		private Set<Course> courses;
		private Set<Student> students;
		
		public Instructor(String name) {
			this.name = name;
			courses = new HashSet<>();
			students = new HashSet<>();
		}
		
		public String getName() {
			return name;
		}
		
		public void addCourse(Course course) {
			courses.add(course);
		}
		
		public void addStudent(Student student) {
			students.add(student);
		}
		
		public int getStudentQtd() {
			return students.size();
		}
		
		public int getCoursesQtd() {
			return courses.size();
		}

		// show list courses names
		// show list students names
		// ...
		
		@Override
		public int hashCode() {
			return Objects.hash(name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Instructor other = (Instructor) obj;
			return Objects.equals(name, other.name);
		}
}
