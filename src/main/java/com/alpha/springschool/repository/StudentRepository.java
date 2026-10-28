package com.alpha.springschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.springschool.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
