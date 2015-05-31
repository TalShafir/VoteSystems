package basicClasses;

import java.io.Serializable;

public class Citizen implements Serializable {
	
	public static enum Gender{
		Male,Female,Unknown
		}
	
	private int id;
	private String FirstName;
	private String LastName;
	private Address address;
	private Gender gender;
	private int destBallotCode;
	private boolean canVote;
	
	public Citizen(int id, String firstName, String lastName, Address address,
			Gender gender, int destBallotCode, boolean canVote) {
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.address = address;
		this.gender = gender;
		this.destBallotCode = destBallotCode;
		this.canVote = canVote;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getDestBallotCode() {
		return destBallotCode;
	}

	public void setDestBallotCode(int destBallotCode) {
		this.destBallotCode = destBallotCode;
	}

	public boolean isCanVote() {
		return canVote;
	}

	public void setCanVote(boolean canVote) {
		this.canVote = canVote;
	}

	public int getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}
	
	
	
	
}