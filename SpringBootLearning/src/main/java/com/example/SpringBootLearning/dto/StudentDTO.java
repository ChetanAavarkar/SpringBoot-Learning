package com.example.SpringBootLearning.dto;

public class StudentDTO {

	private String name;
	private String city;
	
	public StudentDTO() {
	}
	
	public StudentDTO(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
