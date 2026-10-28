package com.alpha.springschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public void register(@RequestBody Student s) {
		System.out.println("REG STUDENT");
		ss.regStudent(s);
	}
}
