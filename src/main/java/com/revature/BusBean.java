package com.revature;

public class BusBean {
	private String BusRegNo;
	private String BusType;
	private int TotalSeats;
	private String TotalBerths;
	public BusBean() {
	
	}
	public String getBusRegNo() {
		return BusRegNo;
	}
	public void setBusRegNo(String busRegNo) {
		BusRegNo = busRegNo;
	}
	public String getBusType() {
		return BusType;
	}
	public void setBusType(String busType) {
		BusType = busType;
	}
	public int getTotalSeats() {
		return TotalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		TotalSeats = totalSeats;
	}
	public String getTotalBerths() {
		return TotalBerths;
	}
	public void setTotalBerths(String totalBerths) {
		TotalBerths = totalBerths;
	}
	
	
}
