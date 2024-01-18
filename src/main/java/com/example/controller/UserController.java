package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.UserDto;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@RequestMapping("/")
@Controller
public class UserController {
	@Autowired
	UserRepository repository;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	//新規作成画面を表示
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	//ユーザーを保存
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") @Validated UserDto userDto,BindingResult result, Model model,Principal principal) {
		
		
		
		if (!result.hasErrors()) {
			userService.save(userDto);
			model.addAttribute("message", "ユーザーを作成しました");
			return "register";
		}
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
//	ユーザーネームを表示
	@RequestMapping("/")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "index";
	}
	

	
}
