package com.davviips.ELearning.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.davviips.ELearning.Entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Role role) {
		Session session = entityManager.unwrap(Session.class);
		
		session.save(role);
	}

}
