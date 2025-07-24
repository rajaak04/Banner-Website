package com.example.DTO;

import jakarta.persistence.Transient;

public class PostDTO {

	private long id;
	String username;
   String filename;
	public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
	byte[] poster_image;
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	String Contenttype;
	@Transient
	String base64;

	public long getId() {
		return id;
	}
	public String getContenttype() {
		return Contenttype;
	}
	public void setContenttype(String contenttype) {
		Contenttype = contenttype;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getPoster_image() {
		return poster_image;
	}
	public void setPoster_image(byte[] poster_image) {
		this.poster_image = poster_image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	String description;

	    // Getters and Setters
	}
