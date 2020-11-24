package com.davviips.ELearning.service;

import com.davviips.ELearning.Entity.User;
import com.davviips.ELearning.helper.CrmUser;

public interface UserService {
	
	public User getUser(String username);
	
	public void save(User user);
	
	public void save(CrmUser crmUser);
	
	public boolean exists(String username);
}
