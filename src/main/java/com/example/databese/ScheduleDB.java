package com.example.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ScheduleDB {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column
	  @NotNull
	  private long id;
	  
//	  @Id
//	  @GeneratedValue(strategy = GenerationType.AUTO)
//	  @Column(name = user_id)
//	  @NotNull
//	  private long user_id;
	  
	  @Column(length = 50, nullable = false)
	  @NotBlank
	  private String title;
	  
	  @Column(length = 200, nullable = true)
	  private String body;//内容
	  
//	  private Date start;
//	  
//	  private Date end;
//	  
//	  @Column(nullable = true)
//	  private String backgroundcolor;
	  
	  
	public long getId() {
		return id;
	}
	  
	public void setId(long id) {
			this.id = id;
		}
	
//	public long getUser_Id() {
//		return user_id;
//		  }
//	  
//	public void setUser_Id(long user_id) {
//		this.user_id = user_id;
//	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
