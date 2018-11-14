package com.spring.tests.studentservices.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.tests.studentservices.model.Course;
import com.spring.tests.studentservices.model.Student;

@Component
public class StudentService {

	private static List<Student> students = new ArrayList<>();

	static {
		Course course1 = new Course("Course1", "Name 1", "Description 1", Arrays.asList("Step 1", "Step 2", "Step 3", "Step 4"));
		Course course2 = new Course("Course2", "Name 2", "Description 2", Arrays.asList("Step 1", "Step 2", "Step 3", "Step 4", "Step 5", "Step 6"));
		Course course3 = new Course("Course3", "Name 3", "Description 3", Arrays.asList("Step 1", "Step 2", "Step 3", "Step 4", "Step 5"));
		Course course4 = new Course("Course4", "Name 4", "Description 4", Arrays.asList("Step 1", "Step 2", "Step 3", "Step 4", "Step 5", "Step 6", "Step 7"));

		Student student1 = new Student("Student1", "Name Student 1", "Description Student 1", new ArrayList<>(Arrays.asList(course1, course2, course3, course4)));
		Student student2 = new Student("Student2", "Name Student 2", "Description Student 2", new ArrayList<>(Arrays.asList(course1, course2, course3, course4)));

		students.add(student1);
		students.add(student2);
	}

	public List<Student> retrieveAllStudents() {
		return students;
	}

	public Student retrieveStudent(String studentId) {
		for (Student student : students) {
			if (student.getId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	public List<Course> retrieveCourses(String studentId) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		return student.getCourses();
	}

	public Course retrieveCourse(String studentId, String courseId) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		for (Course course : student.getCourses()) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}

		return null;
	}

	public Course addCourse(String studentId, Course course) {
		SecureRandom random = new SecureRandom();
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		String randomId = new BigInteger(130, random).toString(32);
		course.setId(randomId);

		student.getCourses().add(course);

		return course;
	}
}