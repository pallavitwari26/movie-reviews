
package com.moviereviews.repositories;
import java.util.*;
import com.moviereviews.models.Movie;
import org.springframework.stereotype.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
	
	
	List<Movie> findAll();
	
	
	List<Movie> findByTitle(@Param("title") String title);
}
