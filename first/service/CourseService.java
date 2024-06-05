package com.project.first.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.first.entity.CourseEntity;
import com.project.first.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository cr;
	
	public void insert(CourseEntity ce) {
		cr.save(ce);
	}

	public List<CourseEntity> getAllStudent() {
		
		return cr.findAll();
	}

		  public Optional<CourseEntity> getById(Long id) {
	        return cr.findById(id);
	    }
	  
	  
		
		public CourseEntity save(CourseEntity ce) {
			return cr.save(ce);
		}
		public void delete(CourseEntity ce){

			cr.delete(ce);

			}

	
		public Optional<CourseEntity> findCourseByName(String name) {
	        return cr.findByName(name);
	    }

}
