package com.felight.services.dto;

public class Users {
	private static String fullName;
	private static String email;
	private static String number;
	private static String dob;
	private static String gender;
	private static String address;
	private static String password;
	private static int activationCode;
	private static int activationKey;
	
	public Users(String fullName, String email, String number, String dob, String gender, String address,
			String password, int activationCode, int activationKey) {
		//super();
		this.fullName = fullName;
		this.email = email;
		this.number = number;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.password = password;
		this.activationCode = activationCode;
		this.activationKey = activationKey;
	}
	public Users() {
		//this(fullName, email, number, dob, gender, address, password, activationCode, activationKey);
	}
	public static String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public static String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public static String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public static String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public static String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static int getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(int activationCode) {
		this.activationCode = activationCode;
	}
	public static int getActivationKey() {
		return activationKey;
	}
	public void setActivationKey(int activationKey) {
		this.activationKey = activationKey;
	}
}
