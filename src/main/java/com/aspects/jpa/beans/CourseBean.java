package com.aspects.jpa.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.aspects.jpa.dao.CourseDao;
import com.aspects.jpa.dao.JpaDao;
import com.aspects.jpa.entities.Course;


@Stateless
@LocalBean
public class CourseBean {

	
	@Inject
	@JpaDao
	@Named("CourseDaoImpl")
	CourseDao courseDao;
	
    public CourseBean() {
    }

    
    public void insertStudent(Course course) {
    	courseDao.createCourse(course);
    }
    
    public void updateStudent(Course course) {
    	courseDao.updateCourse(course);
    }
    
    public void deleteStudent(Course course) {
    	courseDao.deleteCourse(course);
    }
    
    public List<Course> getCourses(){
    	return courseDao.findAll();
    }

}