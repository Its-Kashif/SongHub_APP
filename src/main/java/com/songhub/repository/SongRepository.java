package com.songhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.songhub.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{

	Song findByName(String name);

}
