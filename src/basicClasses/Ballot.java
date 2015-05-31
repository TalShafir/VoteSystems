package basicClasses;

import java.io.Serializable;

public class Ballot implements Serializable {
	private int code;
	private Address address;

	public Ballot(int code, Address address) {
		this.code = code;
		this.address = address;
	}

	public int getCode() {
		return code;
	}

	public Address getAddress() {
		return address;
	}
}
