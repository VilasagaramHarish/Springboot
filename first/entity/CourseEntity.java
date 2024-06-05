package com.project.first.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity

@NamedQuery(name = "CourseEntity.findByName", query = "SELECT s FROM CourseEntity s WHERE s.name = :name")


@Table(name="couse")
public class CourseEntity {
	private int id;
	private String name;
	private String location;
	private double fee;
	
	
	public CourseEntity() {
		super();
	}


	public CourseEntity(int id, String name, String location, double fee) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.fee = fee;
	}

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name" , nullable= false )
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name="location", nullable=false)
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name="fee",nullable=false)
	public double getFee() {
		return fee;
	}


	public void setFee(double fee) {
		this.fee = fee;
	}
	
	
	
	
	
	
}
