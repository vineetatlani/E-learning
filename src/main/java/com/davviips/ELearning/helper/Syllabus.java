package com.davviips.ELearning.helper;

import java.util.HashMap;
import java.util.List;

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



	@Override
	public String toString() {
		return "Syllabus [sections=" + sections + "]";
	}
	
	/*public Syllabus(List<String> sections, List<List<String>> videoNames) {
		super();
		this.sections = sections;
		this.videoNames = videoNames;
	}
	public List<String> getSections() {
		return sections;
	}
	public void setSections(List<String> sections) {
		this.sections = sections;
	}
	public List<List<String>> getVideoNames() {
		return videoNames;
	}
	public void setVideoNames(List<List<String>> videoNames) {
		this.videoNames = videoNames;
	}

	@Override
	public String toString() {
		return "Syllabus [sections=" + sections + ", videoNames=" + videoNames + "]";
	}*/
	
	
}
