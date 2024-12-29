package com.songhub.service;

import java.util.List;

import com.songhub.entity.Song;

public interface SongService {

	void postSong(Song song);

	List<Song> getAllSongs();

	void updateSong(Song song);

}
