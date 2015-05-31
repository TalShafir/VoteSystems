package basicClasses;

import java.io.Serializable;

public class Vote implements Serializable {
	
	private int index;
	private int ballotCode;
	private int partyCode;
	

	public Vote(int code,int ballotCode, int partyCode) {
		this.index = code;
		this.partyCode = partyCode;
		this.ballotCode=ballotCode;
	}

	public int getCode() {
		return index;
	}

	public void setCode(int code) {
		this.index = code;
	}

	public int getPartyCode() {
		return partyCode;
	}

	public int getIndex() {
		return index;
	}

	public int getBallotCode() {
		return ballotCode;
	}

}
