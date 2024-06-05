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
import com.project.first.entity.CourseEntity;
import com.project.first.entity.StudentEntity;
import com.project.first.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseRestController {
	@Autowired
	private CourseService cs;
	
	@PostMapping("/insert")
	public void insert( @Valid @RequestBody CourseEntity ce) {
		cs.insert(ce);
	}
	
	@GetMapping("/{name}")
    public ResponseEntity findCoursesByName(@PathVariable (value="name") String name) throws Notfound{
       CourseEntity ce = cs.findCourseByName(name).orElseThrow(() -> new  Notfound("Course not found with name: " + name));
		return ResponseEntity.ok().body(ce);
        
    }
	
	
	


	@GetMapping("/getAll")
	public List<CourseEntity > gelAll(){
		return cs.getAllStudent();
	}
	
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<CourseEntity> getById(@PathVariable (value = "id" )Long id) throws Notfound {
		CourseEntity ce = cs.getById(id).orElseThrow(() -> new  Notfound("Course not found with id: " + id));
		return ResponseEntity.ok().body(ce);
	   
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public Map deleteRow(@PathVariable (value= "id") Long id, @Valid @RequestBody CourseEntity sd) throws Notfound {
		CourseEntity ce = cs.getById(id).orElseThrow(()->new Notfound("Course NOt FOund with id"+id));
		
		
		cs.delete(ce);
		Map response = new HashMap<>();

		response.put("deleted", Boolean.TRUE);

		return response;
		
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity updateName(@PathVariable (value = "id" )Long id,@Valid @RequestBody CourseEntity cd) throws Notfound {
		CourseEntity ce = cs.getById(id).orElseThrow(() -> new  Notfound("Course not found with id: " + id));

		ce.setName(cd.getName());
		
		final CourseEntity updatedCourse = cs.save(ce);

		return ResponseEntity.ok(updatedCourse);		
	}
}

	

	
 
