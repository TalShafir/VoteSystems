package ballotManager;

import basicClasses.Ballot;

public interface BallotManager {
	
	public void ballotConstruction(int code);
	public boolean isBallotExists(int code);
	public Ballot ballotInfo(int code);
}
