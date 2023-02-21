package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPPACompliantUser {
	private ArrayList<String> patientNotes;
	
// constructor
	public Physician(int id) {
		super(id);
	}
	
// patientNotes getter
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	
//patientNotes setter
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
	    String report = String.format(
	        "Datetime Submitted: %s \n", date);
	    report += String.format("Reported By ID: %s\n", this.id);
	    report += String.format("Patient Name: %s\n", patientName);
	    report += String.format("Notes: %s \n", notes);
	    this.patientNotes.add(report);
	}
	
//	implement assignPin method
	@Override
	public boolean assignPin(int pin) {
		if (pin == 4) {
			this.pin = pin;
			return true;
		} else {
			return false;
		}
	}

//	implement accessAuthorized(Integer) method
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID == id) {
			return true;
		} else {
			return false;
		}
	}
}