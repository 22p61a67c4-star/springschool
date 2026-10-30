package com.alpha.springschool.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alpha.springschool.dto.ResponseStructure;
import com.alpha.springschool.entity.Student;
import com.alpha.springschool.exception.StudentNotFoundException;
import com.alpha.springschool.repository.StudentRepository;
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sr;
	public ResponseEntity<ResponseStructure<Student>> regStudent(Student s) {
		ResponseStructure<Student> rs=new ResponseStructure<Student>();
		if(sr.findById(s.getId()).isEmpty()) {
		s.setName("Mr."+s.getName());
		Student savedStudent=sr.save(s);
		rs.setMessage("Student Saved");
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setData(savedStudent);
		return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.CREATED);
		}
		rs.setMessage("Student already present with id :"+s.getId());
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setData(null);
		return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Student>> findStudent(int id) {
		Student student =sr.findById(id).orElseThrow(()-> new StudentNotFoundException());
		ResponseStructure<Student> rs=new ResponseStructure<Student>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("Student found");
		rs.setData(student);
		return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.FOUND);
	}
	public  ResponseEntity<ResponseStructure<Student>> serviceUpdate(int id, long newmob) {
		Student student =sr.findById(id).orElseThrow(()-> new StudentNotFoundException());
		ResponseStructure<Student> rs=new ResponseStructure<Student>();
		student.setMobno(newmob);
		sr.save(student);
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setData(student);
		rs.setMessage("updated mobile number");
		return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
		Student student =sr.findById(id).orElseThrow(()-> new StudentNotFoundException());
		sr.delete(student);
		ResponseStructure<Student> rs=new ResponseStructure<Student>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("deleted the student with id:"+student.getId());
		rs.setData(student);
		return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.OK);
		
	}

}
