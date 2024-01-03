package com.example;

import com.example.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "people")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@ManyToOne // 多対一の関連性
	@JoinColumn(name = "user_id") // 外部キーのカラム名
	  private User user;
	  
	@Column(length = 50, nullable = false)
	@NotBlank
	private String title;

	@Column(nullable = false)
	@NotBlank
	public String start;

	@Column(nullable = false)
	@NotBlank
	public String end1;

	@Column(length = 250, nullable = false)
	@NotBlank
	private String body;

	
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
		return backgroundColor;
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
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}