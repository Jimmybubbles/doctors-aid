package com.clinic.doctorsaid.model;

public class Patient {
	
	public int id;
	public String name;
	public String medicalHistory;
	
	public Patient(int id, String name, String medicalHistory) {
		this.id = id;
		this.name = name;
		this.medicalHistory = medicalHistory;
	}
	
}
