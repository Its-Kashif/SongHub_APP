package com.songhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.songhub.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

	Playlist findByName(String name);

}
