package com.davviips.ELearning.helper;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Syllabus {
	
	/*List<String> sections;
	List<List<String>> videoNames;*/
	HashMap<String, List<String>> sections;
	
	
	public Syllabus() {
		
	}
	
	
	
	public Syllabus(HashMap<String, List<String>> sections) {
		super();
		this.sections = sections;
	}



	public HashMap<String, List<String>> getSections() {
		return sections;
	}

	public void setSections(HashMap<String, List<String>> sections) {
		this.sections = sections;
	}

	public static Syllabus getSyllabusObject(String jsonSyllabus) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.readValue(jsonSyllabus, Syllabus.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
	}
	
	public static String getJsonSyllabus(Syllabus syllabus) {
		String jsonSyllabus = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonSyllabus = mapper.writeValueAsString(syllabus);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonSyllabus;
	}

	@Override
	public String toString() {
		return "Syllabus [sections=" + sections + "]";
	}
	
	
	
}
