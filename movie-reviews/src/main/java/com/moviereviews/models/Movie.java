package com.moviereviews.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "movie")
public class Movie {


	@Id
	@ApiModelProperty(hidden = true) 
	private String id;
	public String title;
	public String director;
	public String year;
	public String genre;
	
	
	public String getId() {
		return id.toString();
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}



	public Movie(String id,String title, String director, String year, String genre) {
		this.id=id;
		this.title = title;
		this.director = director;
		this.year = year;
		this.genre = genre;
	}

	@Override
	public String toString() 
	{
		return "Movie [id=" + getId() + ", title=" + title + ", director=" + director + ", year=" + year + ", genre=" + genre + "]";
	}





}
