package co.lynth.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class Genre implements Serializable{
	
	private int id;
    private String description;
        
 
	public Genre(int id, String description){
    	
    	this.id = id;
    	this.description = description;
    	
    	
    }
    public Genre(){
    	
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
