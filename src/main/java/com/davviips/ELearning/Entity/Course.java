package com.davviips.ELearning.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.davviips.ELearning.helper.Syllabus;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "syllabus")
	private String jsonSyllabus;

	@Transient
	private Syllabus syllabus;

	@Column(name = "duration")
	private Integer duration;
	
	@Column(name = "created_at")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Date createdAt;
	
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_username")
	private User instructorUserName;
	
	
	public Course() {
		
	}
	

	public Course(Integer id, String name, Integer price, Integer duration, Date createdAt, User instructorUserName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.duration = duration;
		this.createdAt = createdAt;
		this.instructorUserName = instructorUserName;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getJsonSyllabus() {
		return jsonSyllabus;
	}


	public void setJsonSyllabus(String jsonSyllabus) {
		
		this.jsonSyllabus = jsonSyllabus;
	}
	
	public Syllabus getSyllabus() {
		return syllabus;
	}


	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getInstructorUserName() {
		return instructorUserName;
	}

	public void setInstructorUserName(User instructorUserName) {
		this.instructorUserName = instructorUserName;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", price=" + price + ", jsonSyllabus=" + jsonSyllabus
				+ ", syllabus=" + syllabus + ", duration=" + duration + ", createdAt=" + createdAt
				+ ", instructorUserName=" + instructorUserName + "]";
	}
		
	
}
