package com.project.first.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.first.entity.StudentEntity;
import com.project.first.repository.StudentRepository;

@Service
public class StudentService {
@Autowired
	private StudentRepository sr;

	  public Optional<StudentEntity> findByName(String name){
		return sr.findByname(name);
		
	  }
	  public void insertStudent(StudentEntity se) {
		sr.save(se);
	
	  }
	   public List<StudentEntity> getAllStudents() {
	        return sr.findAll();
	   }
	

	   public Optional<StudentEntity> getById(Long id) {
	        return sr.findById(id);
	   }
	  
	  
		
		public StudentEntity save(StudentEntity se) {
			return sr.save(se);
		}
		public void delete(StudentEntity se){

			sr.delete(se);

		}
		

}
