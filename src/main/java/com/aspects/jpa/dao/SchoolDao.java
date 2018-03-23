package com.aspects.jpa.dao;

import java.util.List;

import com.aspects.jpa.entities.School;

public interface SchoolDao {
	void createSchool(School school);
	void updateSchool(School school);
	void deleteSchool(School school);
	List<School> findAll();
	List<School> findSchoolByStudentId(Long studentId);
}
