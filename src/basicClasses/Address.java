package basicClasses;

import java.io.Serializable;

public class Address implements Serializable {
	
	private int Code;
	private String city;
	private String street;
	private int zip;
	private int HouseNumber;
	private int ApartmentNumber;
	public Address(int code, String city, String street, int zip,
			int houseNumber, int apartmentNumber) {
		Code = code;
		this.city = city;
		this.street = street;
		this.zip = zip;
		HouseNumber = houseNumber;
		ApartmentNumber = apartmentNumber;
	}
	public int getCode() {
		return Code;
	}
	public String getCity() {
		return city;
	}
	public String getStreet() {
		return street;
	}
	public int getZip() {
		return zip;
	}
	public int getHouseNumber() {
		return HouseNumber;
	}
	public int getApartmentNumber() {
		return ApartmentNumber;
	}

	

	
}