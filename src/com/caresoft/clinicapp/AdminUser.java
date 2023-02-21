package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPPACompliantUser, HIPPACompliantAdmin {
	private String role;
	private ArrayList<String> securityIncidents;
	
//	constructor
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}
	
//	role getter
	public String getRole() {
		return role;
	}
	
//	role setter
	public void setRole(String role) {
		this.role = role;
	}
	
//	securityIncidents getter
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	
//	securityIncidents setter
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
// newIncident method - success
	public void newIncident(String notes) {
		String report = String.format(
				"Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
				new Date(), this.id, notes
				);
		securityIncidents.add(report);
	}
	
// newIncident method - false
	public void authIncident() {
		String report = String.format(
				"Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
				new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
				);
		securityIncidents.add(report);
	}

//	implement assignPin method
	@Override
	public boolean assignPin(int pin) {
		if (pin >= 6) {
			this.pin = pin;
			return true;
		} else {
			return false;
		}
	}

//	implement accessAuthorized(Integer) method
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID == this.id) {
			return true;
		} else {
			this.authIncident();
			return false;
		}
	}
	
// implement the ArrayList reportSecurityIncidents() method
	@Override
	public ArrayList<String> reportSecurityIncidents(){
		return this.securityIncidents;
	}
}
