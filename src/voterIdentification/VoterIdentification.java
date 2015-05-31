package voterIdentification;

public interface VoterIdentification {
	
	public boolean canVote(int id);
	public void updateCanVote(int id);
	public boolean identifyVoter(int id);
}
