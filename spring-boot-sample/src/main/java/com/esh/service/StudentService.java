package com.esh.service;

import com.esh.beans.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public Student updateStudent(String id, Student updatedStudent);
	public Student getStudent(String id);
	public void removeStudent(String id);
}
