package com.gabrielcr.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielcr.dsmovie.entities.Movie;

public interface movierepository extends JpaRepository<Movie, Long> {

}
