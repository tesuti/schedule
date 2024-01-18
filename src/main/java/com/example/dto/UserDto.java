package com.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	@NotBlank(message = "メールドレスを入力してください")
	private String email;
    
	@NotBlank(message = "パスワードを入力してください")
    @Size(min = 4, max = 12, message = "パスワードは4文字以上12文字以下で登録してください")
	private String password;
	private String role;
	@NotBlank(message = "名前をを入力してください")
	private String fullname;
	
	public UserDto(String email, String password, String role, String fullname) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
	
	
	

}
