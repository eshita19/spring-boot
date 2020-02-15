package com.esh.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esh.UserServiceException;
import com.esh.beans.Student;
import com.esh.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentRestProvider {
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Student> get(@PathVariable String id,
			@RequestParam(value = "page", defaultValue = "1", required = false) String pageNo) throws Exception {
		Student student = studentService.getStudent(id);
		HttpStatus status = (null == student) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		//Added to check @ExceptionHandler
		if (id.equalsIgnoreCase("1")) {
			throw new Exception("1234 not valid id");
		}
		//Added to check specific exception handling
		if (id.equalsIgnoreCase("2")) {
			throw new NullPointerException();
		}
		//Custom exception
		if (id.equalsIgnoreCase("3")) {
			throw new UserServiceException("User service exception occured");
		}
			
		return new ResponseEntity<Student>(student, status);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Student> post(@Valid @RequestBody Student student) {
		student = studentService.createStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Student> put(@PathVariable String id, @Valid @RequestBody Student updatedStudent) {
		Student student = studentService.updateStudent(id, updatedStudent);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable String id) {
		studentService.removeStudent(id);
	}

}
