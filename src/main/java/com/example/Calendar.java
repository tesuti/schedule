package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "calendar")
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(length = 50, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String start;
	
	@Column(nullable = false)
	private String end1;
	
	@Column(nullable = false)
	private String body;
	
	@Column(nullable = false)
	private String backgroundColor;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	 public String getStart() {
		return start;
	}
	public void setStart(String start) {
		 this.start = start;
	}

	 public String getEnd() {
		return end1;
	}
	public void setEnd(String end1) {
		 this.end1 = end1;
	}

	public String getBackgroundColor() {
		 return body;
	}
	public void setBackgroundColor(String backgroundColor) {
		 this.backgroundColor = backgroundColor;
	}
	
	public String getBody() {
		 return body;
	}
	public void setBody(String body) {
		 this.body = body;
	}
}
