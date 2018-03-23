package com.aspects.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.aspects.jpa.entities.Course;

public class CourseDaoImpl extends AbstractDao implements CourseDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void createCourse(Course course) {
		createEntity(em, course);
	}

	@Override
	public void updateCourse(Course course) {
		updateEntity(em, course);
	}

	@Override
	public void deleteCourse(Course course) {
		course = em.merge(course);
		removeEntity(em, course);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findAll() {
		return (List<Course>) getResultsFromNamedQuery(em, "Course.findAll");
	}

}
