package com.reactive.beans;

public class EmployeeSummary {

	
	private int id;
	private String name;
	private double salary;
	private int addressId;
	private String address;
	private String pincode;
	private String error;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return String
				.format("EmployeeSummary [id=%s, name=%s, salary=%s, addressId=%s, address=%s, pincode=%s, error=%s]",
						id, name, salary, addressId, address, pincode, error);
	}
	

	
}
