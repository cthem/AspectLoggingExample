package com.aspects.jpa.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.aspects.jpa.dao.JpaDao;
import com.aspects.jpa.dao.LogDao;
import com.aspects.jpa.entities.Log;


@Stateless
@LocalBean
public class LogBean {

	
	@Inject
	@JpaDao
	@Named("LogDaoImpl")
	LogDao logDao;
	
    public LogBean() {
    }

    
    public void insertLog(Log log) {
    	logDao.createLog(log);
    }
    
    public void updateLog(Log log) {
    	logDao.updateLog(log);
    }
    
    public void deleteLog(Log log) {
    	logDao.deleteLog(log);
    }
    
    public List<Log> getLogs(){
    	return logDao.findAll();
    }

}