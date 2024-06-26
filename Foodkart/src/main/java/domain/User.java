package main.java.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private Gender gender;
	private String phoneNo;
	private String pincode;
	private List<Order> orderHistory;
	
	public User(String name, Gender gender, String phoneNo, String pincode) {
		super();
		this.name = name;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.pincode = pincode;
		this.orderHistory=new ArrayList();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public List<Order> getOrderHistory() {
		return orderHistory;
	}
	public void setOrderHistory(List<Order> orderHistory) {
		this.orderHistory = orderHistory;
	}
	
	
}
