package com.moviereviews.controllers;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.moviereviews.models.Movie;
import com.moviereviews.repositories.MovieRepository;

@RestController
@RequestMapping("/api")
public class MovieController {

	@Autowired
	MovieRepository movieRepository;



	@GetMapping(value="/moviereviews/movies",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Movie>> getAllMovies() {
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



	@RequestMapping(value = "/{title}", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> get(@PathVariable("title") String title) {
		List<Movie> lstMovies= new ArrayList<Movie>();
		lstMovies=movieRepository.findByTitle(title);
		if (null == lstMovies) {
			return new ResponseEntity<List<Movie>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(lstMovies, HttpStatus.OK);
	}


	@PostMapping(value="/moviereviews/addMovie")
	public ResponseEntity<HttpStatus> addMovie(@RequestBody Movie movie)
	{
		try
		{
			if (movie == null) {
				throw new IllegalArgumentException("Movie not provided");
			}

			movie.setId(ObjectId.get());
			System.out.println(movie);
			movieRepository.save(movie);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	 @RequestMapping(value = "/moviereviews/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") String id) {
	        this.movieRepository.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

}
