
package com.moviereviews.repositories;
import java.util.*;
import com.moviereviews.models.Movie;
import org.springframework.stereotype.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
	
	
	List<Movie> findAll();
}
