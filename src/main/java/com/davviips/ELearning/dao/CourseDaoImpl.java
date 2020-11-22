package com.davviips.ELearning.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.davviips.ELearning.Entity.Course;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Course> getCourses() {
		
		Session session = entityManager.unwrap(Session.class);
		
		List<Course> course = session.createQuery("from Course").getResultList();
		
		return course;
	}

}
