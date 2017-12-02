package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import my.example.generated_classes.Student;

@Component
public class StudentRepository {

	public Student retrieveStudentInfo(String name) {
		Assert.notNull(name, "Provide a name");

		List<Student> students = new ArrayList<>();

		Student s1 = new Student();
		s1.setName("Apple");
		s1.setAge(50);
		students.add(s1);

		Student s2 = new Student();
		s2.setName("Noodle");
		s2.setAge(23);
		students.add(s2);

		Student result = null;
		for (Student st : students) {
			if (st.getName().equalsIgnoreCase(name)) {
				result = st;
				break;
			}
		}
		return result;
	}

}
