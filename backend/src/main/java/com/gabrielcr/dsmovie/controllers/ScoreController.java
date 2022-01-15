package com.gabrielcr.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielcr.dsmovie.dto.MovieDTO;
import com.gabrielcr.dsmovie.dto.ScoreDTO;
import com.gabrielcr.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDTO SaveScore(@RequestBody ScoreDTO dto) {
		MovieDTO MovieDTO = service.saveScore(dto);
		return MovieDTO;
	}
}
