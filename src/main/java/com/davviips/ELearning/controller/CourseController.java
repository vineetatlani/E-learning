package com.davviips.ELearning.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davviips.ELearning.Entity.Course;
import com.davviips.ELearning.Entity.User;
import com.davviips.ELearning.dao.CourseDao;
import com.davviips.ELearning.dao.UserDao;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private UserDao userDao;
	
	
	@GetMapping("/list")
	public String listCourses(Principal principal,  Model model) {
		
		List<Course> courses = courseDao.getCourses();
		
		model.addAttribute("courses", courses);
		
		return "list-courses";
	}
	
	
	
}
