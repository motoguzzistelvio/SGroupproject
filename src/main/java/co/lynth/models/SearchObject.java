package co.lynth.models;

import java.io.Serializable;
import java.sql.Date;

public class SearchObject implements Serializable {
	
	private String name;
	private String serialNumber;
	private String genre;
	private String actors;
	private Date releaseDate;
	
	public SearchObject(){
		
	}
	
	public SearchObject(String name,
						String serialNumber,
						String genre,
						String actors,
						Date releaseDate){
		
		this.name = name;
		this.serialNumber = serialNumber;
		this.genre = genre;
		this.actors = actors;
		this.releaseDate = releaseDate;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
	
	
}
