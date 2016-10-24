package com.mindtree.tables;

public class Employee {

	private String CustomerName;
	private String ContactName;
	private String Address;
	private String City;
	private String PostalCode;
	private String Country;



	/**
	 * 
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param customerName
	 * @param contactName
	 * @param address
	 * @param city
	 * @param postalCode
	 * @param country
	 */
	public Employee(String customerName, String contactName, String address, String city, String postalCode,
			String country) {
		CustomerName = customerName;
		ContactName = contactName;
		Address = address;
		City = city;
		PostalCode = postalCode;
		Country = country;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}


}

