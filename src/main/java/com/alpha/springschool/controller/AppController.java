package com.alpha.springschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.springschool.dto.ResponseStructure;
import com.alpha.springschool.entity.Student;
import com.alpha.springschool.service.StudentService;

@RestController
public class AppController {
	@GetMapping("/demo/name/{name}/age/{age}/page/{pageno}")
	public void demo(@PathVariable String name,@PathVariable int age,@PathVariable int pageno) {
		System.out.println("this is demo servies");
		System.out.println(name);
		System.out.println(age);
		System.out.println(pageno);
		
	}
	@GetMapping("/test")
	public void test(@RequestParam String name,@RequestParam int age){
		System.out.println("this is test servies");
		System.out.println(name+" "+age);
	}
	
	@PostMapping("/sample")
	public void sample(@RequestHeader String name,@RequestHeader int age) {
		System.out.println("this is the sample servies");
		System.out.println("name: "+name);
		System.out.println("age: "+age);
	}
	
	@Autowired
	private StudentService ss;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<Student>> register(@RequestBody Student s) {
		System.out.println("REG STUDENT");
		return ss.regStudent(s);
	}
	
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<Student>> findbyid(@RequestParam int id) {
		return ss.findStudent(id);
	}
	
	@PatchMapping("/updateStudent")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id,@RequestParam long newmob) {
		System.out.println("this is the update api controller");
		return ss.serviceUpdate(id,newmob);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@RequestParam int id) {
		System.out.println("id="+id);
		return ss.deleteStudent(id);
	}
}
