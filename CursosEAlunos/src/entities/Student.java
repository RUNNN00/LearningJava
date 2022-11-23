package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {

		private int code;
		private Set<Course> courses;
		
		public Student() {}
		
		public Student(int code) {
			this.code = code;
			courses = new HashSet<>();
		}
		
		public int getCode() {
			return code;
		}
		
		public void addCourse(Course course) {
			courses.add(course);
		}
		
		public Course findCourse(String courseName) {
			for (Course c : courses) {
				if (c.getName() == courseName)
					return c;
			}
			return null;
		}
		
		@Override
		public String toString() {
			String str = "student " + code + "\n";
			for (Course c : courses) {
				str += c.getName() + "\n";
			}
			
			return str;
		}

		@Override
		public int hashCode() {
			return Objects.hash(code);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			return code == other.code;
		}
}
