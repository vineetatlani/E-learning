package com.davviips.ELearning.dao;

import com.davviips.ELearning.Entity.User;
import com.davviips.ELearning.helper.CrmUser;

public interface UserDao {
	
	public User getUser(String username);
	
	public void save(User user);
	
	
}
