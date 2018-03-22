package com.aspect.jpa.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.aspect.jpa.dao.JpaDao;
import com.aspect.jpa.dao.SchoolDao;
import com.aspect.jpa.entities.School;


@Stateless
@LocalBean
public class SchoolBean {
	
	@Inject
	@JpaDao
	@Named("SchoolDaoImpl")
	SchoolDao schoolDao;
	
    public SchoolBean() {
    }

    
    public void insertSchool(School school) {
    	schoolDao.createSchool(school);
    }
    
    public void updateSchool(School school) {
    	schoolDao.updateSchool(school);
    }
    
    public void deleteSchool(School school) {
    	schoolDao.deleteSchool(school);
    }
    
    public List<School> getSchools(){
    	return schoolDao.findAll();
    }
    
    public List<School> findSchoolsByUser(Long userId){
    	return schoolDao.findSchoolByStudentId(userId);
    }

}