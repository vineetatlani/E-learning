package com.davviips.ELearning.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.davviips.ELearning.Entity.User;

@Repository
public class UserDaoimpl implements UserDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public User getUser(String username) {
		
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(User.class, username);
	}

}
