package com.alpha.springschool.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.springschool.entity.Student;
import com.alpha.springschool.repository.StudentRepository;
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sr;
	public Student regStudent(Student s) {
		System.out.println("inside the service layer");
		System.out.println(s);
		s.setName("Mr."+s.getName());
		Student savedStudent=sr.save(s);
		return savedStudent;
	}
	public Student findStudent(int id) {
		Optional<Student> studopt =sr.findById(id);
		if(studopt.isPresent()) {
			System.out.println(studopt);
			Student foundStud=studopt.get();
			System.out.println(foundStud);
			return foundStud;
		}
		return null;
	}
	public  void serviceUpdate(int id, long newmob) {
		System.out.println("this is the service layer update method");
		Optional<Student> studopt =sr.findById(id);
		if(studopt.isPresent()) {
			Student s=studopt.get();
			s.setMobno(newmob);
			sr.save(s);
		}
		
	}
	public void deleteStudent(int id) {
		Optional<Student> studopt =sr.findById(id);
		if(studopt.isPresent()) {
			sr.deleteById(id);
			System.out.println("found and deleted");
		}else {
			System.out.println("not found");
		}
		
	}

}
