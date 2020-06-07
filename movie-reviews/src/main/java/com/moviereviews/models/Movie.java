package com.moviereviews.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
public class Movie {


	@Id
	private String id;

	public String title;
	public String getName() {
		return title;
	}


	private String getId() {
		return id;
	}

	public void setName(String title) {
		this.title = title;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String director;
	public int year;
	public String genre;


	public Movie(String title, String director, int year, String genre) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.genre = genre;
	}

	@Override
	public String toString() 
	{
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", year=" + year + ", genre=" + genre + "]";
	}

}
