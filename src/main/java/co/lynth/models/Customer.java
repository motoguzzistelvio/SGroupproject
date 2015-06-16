package co.lynth.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class Customer implements Serializable{
	
	private int id;
    private String firstname;
    private String surname;
    private String idnumber; 
    private Timestamp createDate;
    
    public Customer(){
    	
    }
    
    public Customer(int id,
    				String firstname,
    				String surname,
    				String idnumber,
    				Timestamp createDate){
    	
    	this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.idnumber = idnumber;
		this.createDate = createDate;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	
}
