package com.moviereviews.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "review")
public class Review {

	@Id
	@ApiModelProperty(hidden=true)
	
    private String reviewId;
    private String author;
    private String content;
    private int rating;
    private String movieId;
    
	public String getReviewId() {
		return reviewId.toString();
	}
	public void setReviewId(String id) {
		this.reviewId = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMovieId() {
		return movieId.toString();
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	

	@Override
	public String toString() 
	{
		return "Review [id=" + getReviewId() + ", content=" + content + ", rating=" + rating + ", author=" + author +  "]";
	}
}
