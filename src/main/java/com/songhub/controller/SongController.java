package com.songhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhub.entity.Song;
import com.songhub.service.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;

	
	@PostMapping(value="/postsong")
	public String postSong(@ModelAttribute Song song) {
		System.out.println(song);
		songService.postSong(song);
		return "addsong";
	}
	
	@GetMapping(value="/viewsongs")
		public String getSongs(Model model){
			List<Song> songslist=songService.getAllSongs();
			model.addAttribute("songs", songslist);
			System.out.println(songslist);
			return "viewsongs";
		}
		
	@GetMapping(value="/playsongs")
	public String getSongsforUser(Model model){
		boolean premium=false;
		if(premium==true) {
		List<Song> songslist=songService.getAllSongs();
		model.addAttribute("songs", songslist);
		return "viewsongs";
		}
		else {
			return "pay";
		}
	}

	
}
