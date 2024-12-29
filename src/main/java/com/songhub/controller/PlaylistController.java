package com.songhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.songhub.entity.Playlist;
import com.songhub.entity.Song;
import com.songhub.service.PlaylistService;
import com.songhub.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistService;
	@Autowired
	SongService songService;
	
	
	@GetMapping(value="/createplaylists")
	public String createPlaylist(Model model) {
		List<Song>songlist=songService.getAllSongs();
		System.out.println(songlist);
		model.addAttribute("songs", songlist);
		return "createplaylist";
	}
	
	@PostMapping(value="/saveplaylist")
	public String savePlaylist(@ModelAttribute Playlist playlist) {
		playlistService.savePlaylist(playlist);
		
		//updating the song_playlist table
		List<Song> songs = playlist.getSongs();
		System.out.println(songs);
		for(Song song:songs) {
			System.out.println("iteration started");
			song.getPlaylist().add(playlist);
//			System.out.println(song);
//			
			songService.updateSong(song);
			System.out.println("iteation ended");
		}
		return "adminhome";
	}
	
	@GetMapping(value="/viewplaylist")
	public String viewPlaylist(Model model) {
		List<Playlist> playlist=playlistService.getAllPlaylist();
		model.addAttribute("playlist", playlist);
		System.out.println(playlist);
		return "viewplaylist";
	}
	
//	@GetMapping(value="/playlist")
//	public String playlist(Model model, @ModelAttribute String playlistName) {
//		List<Song> songlist=songService.getSongs(playlistName);
//	}
}
