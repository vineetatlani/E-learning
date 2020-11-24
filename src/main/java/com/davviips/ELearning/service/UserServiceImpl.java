package com.davviips.ELearning.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.davviips.ELearning.Entity.Role;
import com.davviips.ELearning.Entity.User;
import com.davviips.ELearning.dao.RoleDao;
import com.davviips.ELearning.dao.UserDao;
import com.davviips.ELearning.helper.CrmUser;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public User getUser(String username) {
		return userDao.getUser(username);
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		
		user.setUsername(crmUser.getUserName());
		user.setEmail(crmUser.getEmail());
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setPhoneNumber(crmUser.getPhoneNumber());
		user.setPassword("{noop}" + crmUser.getPassword());
		//user.setPassword("{bcrypt}"+passwordEncoder.encode(crmUser.getPassword()));
		
		Role role = new Role(user, "ROLE_STUDENT");
		
		java.util.List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		userDao.save(user);
		roleDao.save(role);
	}

	@Override
	@Transactional
	public boolean exists(String username) {
		
		User user = userDao.getUser(username);
		if(user == null)
			return false;
		return true;
	}

}
