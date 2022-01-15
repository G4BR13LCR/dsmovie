package com.gabrielcr.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielcr.dsmovie.entities.Score;
import com.gabrielcr.dsmovie.entities.ScorePK;


public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
