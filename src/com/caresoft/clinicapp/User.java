package com.caresoft.clinicapp;

public class User {
	protected Integer id;
	protected int pin;

//	constructor that takes an ID
	public User(Integer id) {
		this.id = id;
	}
	
//	id getter
	public Integer getId() {
		return id;
	}
	
// id setter
	public void setId(Integer id) {
		this.id = id;
	}
	
// pin getter
	public int getPin() {
		return pin;
	}
	
// pin setter
	public void setPin(int pin) {
		this.pin = pin;
	}
}
