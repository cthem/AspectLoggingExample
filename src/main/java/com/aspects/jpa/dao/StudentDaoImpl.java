package com.aspects.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.aspects.jpa.entities.Student;

public class StudentDaoImpl extends AbstractDao implements StudentDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void createStudent(Student student) {
		createEntity(em, student);
	}

	@Override
	public void updateStudent(Student student) {
		updateEntity(em, student);
	}

	@Override
	public void deleteStudent(Student student) {
		student = em.merge(student);
		removeEntity(em, student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		return (List<Student>) getResultsFromNamedQuery(em, "Student.findAll");
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

}
