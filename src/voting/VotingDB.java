package voting;

import java.sql.SQLException;
import java.util.ArrayList;

import basicClasses.Vote;
import basicServices.DBService;

public class VotingDB {
	private DBService dbService;
	
	public VotingDB(String url,String user,String password) {
		try {
			dbService=new DBService(url, user, password);
		} catch (Exception e) {
//			new errorWindow();
		}
	}
	
	public void writeVote(Vote vote){
		try {
			dbService.action("INSERT INTO vote ");
		} catch (SQLException e) {
//			new errorWindow("Error the vote wan't saved");
		}
	}
	
	public Vote getVote(int code){
		ArrayList<Object[]> res=null;
		try {
			res=dbService.getData("SELECT * FROM votes WHERE code="+code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] resO=res.get(0);
		return new Vote((int)resO[0],(int)resO[1],(int)resO[2]);
	}
	
}
