package com.gabrielcr.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielcr.dsmovie.dto.MovieDTO;
import com.gabrielcr.dsmovie.dto.ScoreDTO;
import com.gabrielcr.dsmovie.entities.Movie;
import com.gabrielcr.dsmovie.entities.Score;
import com.gabrielcr.dsmovie.entities.User;
import com.gabrielcr.dsmovie.repositories.ScoreRepository;
import com.gabrielcr.dsmovie.repositories.UserRepository;
import com.gabrielcr.dsmovie.repositories.movierepository;

@Service
public class ScoreService {

	@Autowired
	private movierepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user= userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMoveId()).get();
		
		Score score= new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);

	}
	
}