package com.songhub.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhub.entity.Playlist;
import com.songhub.entity.Song;
import com.songhub.repository.PlaylistRepository;
import com.songhub.service.PlaylistService;

@Service
public class PlaylistServiceImple implements PlaylistService {
	
	@Autowired
	PlaylistRepository playlistRepo;

	@Override
	public void savePlaylist(Playlist playlist) {
		Playlist existingPlaylist=playlistRepo.findByName(playlist.getName());
		if(existingPlaylist==null) {
			
			playlistRepo.save(playlist);
			System.out.println("succesfull");
		}
		else {
			System.out.println("Playlist available with same name");
		}
		
	}

	@Override
	public List<Playlist> getAllPlaylist() {
		
		return playlistRepo.findAll();
	}

	

}
