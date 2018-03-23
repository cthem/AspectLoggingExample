package com.aspects.jpa.logging;

import javax.persistence.EntityManager;

import com.aspects.jpa.dao.StudentDao;
import com.aspects.jpa.entities.Log;
import com.aspects.jpa.entities.Student;

public aspect LogAspect {
	public void log(String username, EntityManager em) {
		Log logging = new Log();
		logging.setUser(username);
		logging.setDescription("Changed something");
		logging.setClassName(Student.class.getSimpleName());
	}
	
	pointcut write_logs(StudentDao studentDao, Student student) : call(void StudentDao.updateStudent(Student)) && this(studentDao) && args(student);
	
	after(StudentDao studentDao, Student student) : write_logs(studentDao, student) {
		log("me", studentDao.getEntityManager());
	}
}
