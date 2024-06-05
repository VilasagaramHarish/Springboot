package com.project.first.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.first.MyExceptions.Notfound;
import com.project.first.entity.StudentEntity;
import com.project.first.service.StudentService;

@RestController
@RequestMapping("/Db")

public class FirstController {
	
	
	
	@Autowired
	private StudentService ss;

	
	@GetMapping("/Get")
	public String disp() {
		return "Harish";
	}
	
	
	
	
	
	
	@PostMapping("/insert")
	public void insert (@Valid @RequestBody StudentEntity se) {
		ss.insertStudent(se);
	}

	
	
	

	
	 @GetMapping("/getAll")
	    public List<StudentEntity> getAll() {
	        return ss.getAllStudents();
	    }
	

	
	
	@GetMapping("name/{name}")
	public ResponseEntity getByName(@PathVariable (value="name") String name) throws Notfound{
		StudentEntity se =ss.findByName(name).orElseThrow(() -> new  Notfound("Student not found with name: " + name));
		return ResponseEntity.ok().body(se);
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<StudentEntity> getById(@PathVariable (value = "id" )Long id) throws Notfound {
		StudentEntity se = ss.getById(id).orElseThrow(() -> new  Notfound("Student not found with id: " + id));
		return ResponseEntity.ok().body(se);
	   
	}
	
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public Map deleteRow(@PathVariable (value= "id") Long id, @Valid @RequestBody StudentEntity sd) throws Notfound {
		StudentEntity se = ss.getById(id).orElseThrow(()->new Notfound("Student NOt FOund with id"+id));
		
		
		ss.delete(se);
		Map response = new HashMap<>();

		response.put("deleted", Boolean.TRUE);

		return response;
		
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity updateName(@PathVariable (value = "id" )Long id,@Valid @RequestBody StudentEntity sd) throws Notfound {
		StudentEntity se = ss.getById(id).orElseThrow(() -> new Notfound("Student not found with id: " + id));

		se.setName(sd.getName());
		
		final StudentEntity updatedStudent = ss.save(se);

		return ResponseEntity.ok(updatedStudent);		
	}
	
	
}