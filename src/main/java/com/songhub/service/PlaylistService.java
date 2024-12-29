package com.songhub.service;

import java.util.List;

import com.songhub.entity.Playlist;

public interface PlaylistService {

	void savePlaylist(Playlist playlist);

	List<Playlist> getAllPlaylist();

}
