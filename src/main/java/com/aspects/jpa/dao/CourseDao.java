package com.aspects.jpa.dao;

import java.util.List;

import com.aspects.jpa.entities.Course;

public interface CourseDao {

	void createCourse(Course course);
	void updateCourse(Course course);
	void deleteCourse(Course course);
	List<Course> findAll();
}
