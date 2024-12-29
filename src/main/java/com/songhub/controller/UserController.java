package com.songhub.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.songhub.entity.Song;
//import com.songhub.entity.Song;
import com.songhub.entity.User;
import com.songhub.service.SongService;
import com.songhub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SongService songService;
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute User user) {
		System.out.println("User data recieved from frontend");
		userService.saveUser(user);
		System.out.println("User data has been saved in database");
		return "login";
		
	}
	
	
	@PostMapping("/validate")
	public String validate(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		System.out.println(email);
		boolean validCredential=(userService.validateCredential(email, password));
		System.out.println(validCredential);
		if(validCredential) {
			session.setAttribute("email", email);
			System.out.println(email+" logged in");
			if(userService.getRole(email).equals("admin"))
				return "adminhome";
						
			else {
				boolean userStatus = userService.isPremium(email);
				model.addAttribute("isPremium", userStatus);
				System.out.println(email+" is customer user");
				if(userStatus) {
					System.out.println("paid user");
				}
				else {
					System.out.println("not a paid user");
				}
				List<Song> allSongs=songService.getAllSongs();
				model.addAttribute("songs", allSongs);

				return "customerhome";
			}
		}
		else {

			return "login";
		}
	}

}
