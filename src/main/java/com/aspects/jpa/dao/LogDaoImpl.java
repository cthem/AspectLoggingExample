package com.aspects.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.aspects.jpa.entities.Log;

public class LogDaoImpl extends AbstractDao implements LogDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void createLog(Log log) {
		createEntity(em, log);
	}

	@Override
	public void updateLog(Log log) {
		updateEntity(em, log);
	}

	@Override
	public void deleteLog(Log log) {
		log = em.merge(log);
		removeEntity(em, log);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> findAll() {
		return (List<Log>) getResultsFromNamedQuery(em, "Log.findAll");
	}

}
