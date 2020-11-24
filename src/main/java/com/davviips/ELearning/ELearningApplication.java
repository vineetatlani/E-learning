package com.davviips.ELearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.davviips.ELearning.helper.Syllabus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ELearningApplication {
	
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ELearningApplication.class, args);
		/*System.out.println("Hello World!");
		Syllabus syllabus = new Syllabus();
		
		
		HashMap<String, List<String>> sections = new HashMap<String, List<String>>();
		
		sections.put("Introduction", Arrays.asList(new String[] {"Introduction Video.mp4"}));
		sections.put("History of C++", Arrays.asList(new String[] {"Language C","How was C++ build"}));
		sections.put("OOPS Concept", Arrays.asList(new String[] {"Polymorphism", "Inheritance", "Abstraction","Encapsulation"}));
		
		syllabus.setSections(sections);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonSyllabus = mapper.writeValueAsString(syllabus);
			System.out.println(jsonSyllabus);
			
			Syllabus jsonSy = mapper.readValue(jsonSyllabus, Syllabus.class);
			
			System.out.println(jsonSy);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
