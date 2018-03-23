package com.aspects.jpa.dao;

import java.util.List;

import com.aspects.jpa.entities.Log;

public interface LogDao {

	void createLog(Log log);

	void updateLog(Log log);

	void deleteLog(Log log);

	List<Log> findAll();

}
