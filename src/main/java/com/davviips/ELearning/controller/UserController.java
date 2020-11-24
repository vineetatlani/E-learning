package com.davviips.ELearning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davviips.ELearning.helper.CrmUser;
import com.davviips.ELearning.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		
		model.addAttribute("crmUser", new CrmUser());
		
		return "user-registration-form";
	}
	
	@PostMapping("/register") 
	public String processForm(@Valid @ModelAttribute CrmUser crmUser, BindingResult bindingResult,
			Model model){
		for(ObjectError error : bindingResult.getAllErrors()) {
			System.out.println(error);
		}
		if(bindingResult.hasErrors())
		{
			return "user-registration-form";
		}
		System.out.println(crmUser);
		if(userService.exists(crmUser.getUserName()))
		{
			System.out.println("Already Exists");
			model.addAttribute("alreadyExists", "Username Already exists");
			return "user-registration-form";
		}
		
		userService.save(crmUser);
		
		System.out.println("User Registered");
		return "redirect:/home";
	}
	
	@Bean
    public MessageSource messageSource () {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("resources/messages");
        return messageSource;
    }
	
}
