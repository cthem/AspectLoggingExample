package com.aspects.jpa.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.aspects.jpa.dao.JpaDao;
import com.aspects.jpa.dao.StudentDao;
import com.aspects.jpa.entities.Student;


@Stateless
@LocalBean
public class StudentBean {

	
	@Inject
	@JpaDao
	@Named("StudentDaoImpl")
	StudentDao studentDao;
	
    public StudentBean() {
    }

    
    public void insertStudent(Student student) {
    	studentDao.createStudent(student);
    }
    
    public void updateStudent(Student student) {
    	studentDao.updateStudent(student);
    }
    
    public void deleteStudent(Student student) {
    	studentDao.deleteStudent(student);
    }
    
    public List<Student> getStudents(){
    	return studentDao.findAll();
    }

}