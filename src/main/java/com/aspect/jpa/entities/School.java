package com.aspect.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the schools database table.
 * 
 */
@Entity
@Table(name = "schools")
@NamedQueries({ 
	@NamedQuery(name = "School.findAll", query = "SELECT s FROM School s"),
	@NamedQuery(name="School.findByStudent", query="SELECT s FROM School s WHERE s.student.id = :studentId"),
	@NamedQuery(name="School.findByName", query="SELECT s FROM School s WHERE s.name = :name"),
	@NamedQuery(name="School.findByAddress", query="SELECT s FROM School s WHERE s.address = :address")
})
public class School implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String address;

	private String name;

	// bi-directional one-to-one association to Student
	@OneToOne(mappedBy = "school")
	private Student student;

	public School() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}