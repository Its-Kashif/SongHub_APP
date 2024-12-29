package com.songhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController {
	
	@GetMapping("/registernav")
	public String registerNav() {
		return "Registration";
	}
	
	@GetMapping("/loginnav")
	public String loginNav() {
		return "login";
	}
	@GetMapping(value="/addsong")
	public String addSong() {
		return "addsong";
	}
	
	@GetMapping(value="/logout")
	public static String logout(HttpSession session){
		session.invalidate();
		System.out.println("User  has been sucessfully logged out");
		return "login";
	}

}
