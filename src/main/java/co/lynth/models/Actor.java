package co.lynth.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class Actor implements Serializable {
	
	private int id;
	private String name;
	private int videoId;
	private Timestamp createDate;
	
	public Actor(int id,
			String name,
			int videoId,
			 Timestamp createDate){
		
		this.id = id;
		this.name = name;
		this.videoId = videoId;
		this.createDate = createDate;
		
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

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
			 
		

}
