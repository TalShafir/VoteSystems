package ballotManager;

import java.sql.SQLException;
import java.util.ArrayList;

import basicClasses.Address;
import basicClasses.Ballot;
import basicServices.DBService;

public class BallotManagerDB {
	private DBService dbService;
	public BallotManagerDB(String url, String user, String password){
		try {
			dbService = new DBService(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//new errorWindow("Incorrect Username and/or Password");
		} catch (SQLException e) {
			//new errorWindow("SQL error");
			e.printStackTrace();
		}
	}
	public void updateBallot(int code){
		String Expression = "UPDATE ballot SET Validate = true WHERE code="+code;
		try {
			dbService.action(Expression);
		} catch (SQLException e) {
			//new errorWindow("SQL error");
			e.printStackTrace();
		}
	}
	public Ballot getBallotData(int code){
		String Expression = "SELECT * FROM ballot WHERE code = "+code;
		ArrayList<Object[]> information = null;
		try {
			information = dbService.getData(Expression);
		} catch (SQLException e) {
			//new errorWindow("SQL error");
			e.printStackTrace();
		}
		if(information.size() > 1){
			//new errorWindow("SQL data duplication");
			return null;
		}
		Object[] inf = information.get(0);
		return new Ballot((int)inf[0],(Address)inf[1]);
	}
	
}
