package com.moviereviews.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviereviews.models.Movie;
import com.moviereviews.repositories.MovieRepository;

@RestController
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
	MovieRepository movieRepository;
	
	
	@GetMapping("/moviereviews/movies")
	  public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) String title) {
		try {
		    List<Movie> movies = new ArrayList<Movie>();

		   
		    	movieRepository.findAll().forEach(movies::add);
		    
		    if (movies.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(movies, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }


}
