package com.user.model;

import java.io.Serializable;

import javassist.SerialVersionUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="User.findall",query="select u from User u")
public class User implements Serializable{
	private static final long SerialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String fname;
	private String lname;
	private String city;
	private String profession;
	public String getFname() {
		return fname;
	}
	public int getId() {
		return id;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public void setId(int id) {
		this.id=id;
	}

}
