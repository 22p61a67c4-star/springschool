package com.alpha.springschool.service;

import org.springframework.stereotype.Service;

import com.alpha.springschool.entity.Student;
@Service
public class StudentService {

	public void regStudent(Student s) {
		System.out.println("inside the service layer");
		System.out.println(s);
		
	}

}
