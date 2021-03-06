package com.moviereviews.controllers;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviereviews.models.Movie;
import com.moviereviews.models.Review;
import com.moviereviews.repositories.ReviewRepository;


@RestController
@RequestMapping("/api")
public class ReviewController {

	@Autowired
	ReviewRepository reviewRepo;
	
	@PostMapping(value="/moviereviews/addReview")
	public ResponseEntity<HttpStatus> addMovie(@RequestBody Review review)
	{
		try
		{
			if (review == null) {
				throw new IllegalArgumentException("Review not provided");
			}

			review.setReviewId(ObjectId.get().toString());
			System.out.println(review);
			reviewRepo.save(review);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping(value="/moviereviews/reviews",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Review>> getAllReviews() {
		try {
			List<Review> reviews = new ArrayList<Review>();


			this.reviewRepo.findAll().forEach(reviews::add);

			if (reviews.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(reviews, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	
}
