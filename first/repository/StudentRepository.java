package com.project.first.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.first.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
	
	@Query(value="select * from student_entity where name = :name " ,nativeQuery=true)
	public Optional<StudentEntity> findByname(String name) ;
	
	
}