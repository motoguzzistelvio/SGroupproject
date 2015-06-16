package co.lynth.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Video implements Serializable {
	private int id;
	private String name;
	private List<Genre> genres; 
	private int genreId;
	private int minutes;
	private String actors;
	private Date releaseDate;
	
	public Video(int id,
				 String name,
				 int genreId,
				 int minutes,
				 String actors,
				 Date releaseDate){
		
		this.id = id;
		this.name = name;
		this.genreId = genreId;
		this.minutes = minutes;
		this.actors = actors;
		this.releaseDate = releaseDate;
	}
	
	public Video(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
}
