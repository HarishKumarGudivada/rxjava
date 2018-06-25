package com.reactive.beans;
public class EmployeeInfo {
	
	public EmployeeInfo(){
		
	}
	
	
	public EmployeeInfo(int id,String name,double salary){
		this.id=id;
		this.name=name;
		//if(salary<=0) throw new RuntimeException("Some thing went wrong");
		this.salary=salary;
	}
	
	private int id;
	private String name;
	private double salary;
	private String error;
	
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
		return this.id+"--"+this.name+"--"+this.salary;
	}
	
}
