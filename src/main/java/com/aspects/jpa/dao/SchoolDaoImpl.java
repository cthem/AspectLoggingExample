package com.aspects.jpa.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.aspects.jpa.entities.School;

@JpaDao
@Dependent
@Named("SchoolDaoImpl")
public class SchoolDaoImpl extends AbstractDao implements SchoolDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void createSchool(School school) {
		createEntity(em, school);
	}

	@Override
	public void updateSchool(School school) {
		updateEntity(em, school);
	}

	@Override
	public void deleteSchool(School school) {
    	school = em.merge(school);
		removeEntity(em, school);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<School> findAll() {
		return (List<School>) getResultsFromNamedQuery(em, "School.findAll");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<School> findSchoolByStudentId(Long studentId) {
		return (List<School>) em.createNamedQuery("School.findByStudent")
				.setParameter("studentId", studentId).getResultList();
	}

}
