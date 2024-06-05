package com.project.first.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
// @NamedQuery(name="StudentEntity.findByLastName", query="select s from StudentEntity s where s.studentfname=?1")

@Table(name = "student_entity")

public class StudentEntity {
	
	private int id;
	private String name;

	public StudentEntity() {
	}

	public StudentEntity(int id, String name) {
		this.id = id;
		this.name = name;
	}


	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY )
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + "]";
	}
	
}
