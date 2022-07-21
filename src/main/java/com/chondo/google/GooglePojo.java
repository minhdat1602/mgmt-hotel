package com.chondo.google;

public class GooglePojo {
	private String id;
	private String email;
	private boolean verified_email;
	private String name;
	private String gender;
//	private String name;
	private String giveName;
//	private String family_name;
//	private String link;
	private String picture;

	public String getGiveName() {
		return giveName;
	}

	public void setGiveName(String giveName) {
		this.giveName = giveName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerified_email() {
		return verified_email;
	}

	public void setVerified_email(boolean verified_email) {
		this.verified_email = verified_email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
