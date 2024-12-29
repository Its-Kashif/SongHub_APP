package com.songhub.service.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhub.entity.Song;
import com.songhub.repository.SongRepository;
import com.songhub.service.SongService;

@Service
public class SongServiceImple implements SongService {
	 
	@Autowired
	SongRepository songRepo;

	@Override
	public void postSong(Song song) {
		System.out.println(song);
		Song existSong=songRepo.findByName(song.getName());
		if(existSong != null) {
			System.out.println("Duplicate Song Entry");
		}
		else {
			songRepo.save(song);
		}
		
	}

	@Override
	public List<Song> getAllSongs() {
		
		return songRepo.findAll();
	}

	@Override
	public void updateSong(Song song) {
		
		songRepo.save(song);
		
	}

	


}
