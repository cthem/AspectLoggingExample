package com.aspects.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.aspects.jpa.entities.Student;

public interface StudentDao {
	void createStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(Student student);
	List<Student> findAll();
	EntityManager getEntityManager();
}
