package com.esh.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.esh.beans.Student;

@Service
public class StudentServiceImpl implements StudentService{

	private Map<String, Student> studentById = new HashMap<>();

	public Student createStudent(Student student) {
		String id = UUID.randomUUID().toString();
		student.setId(id);
		studentById.put(id, student);
		return student;
	}
	
	public Student updateStudent(String id, Student updatedStudent) {
		Student student = studentById.get(id);
		student.setFirstName(updatedStudent.getFirstName());
		student.setLastName(updatedStudent.getLastName());
		return student;
	}

	public Student getStudent(String id) {
		return studentById.get(id);
	}

	@Override
	public void removeStudent(String id) {
		studentById.remove(id);
	}

}
