package co.lynth.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class VideoItem implements Serializable {
	
	private int id;
	private String serialNumber;
	private int videoId;
	private int customerId;
	private Timestamp createDate;
	
	public VideoItem(int id, 
					 String serialNumber,
					 int videoId,
					 int customerId,
					 Timestamp createDate){
		
		this.id = id;
		this.serialNumber = serialNumber;
		this.videoId = videoId;
		this.customerId = customerId;
		this.createDate = createDate;
		
	}
	public VideoItem(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	

}
