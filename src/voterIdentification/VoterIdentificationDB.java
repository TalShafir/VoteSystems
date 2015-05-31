package voterIdentification;

import java.sql.SQLException;
import java.util.ArrayList;

import basicClasses.Address;
import basicClasses.Ballot;
import basicClasses.Citizen;
import basicClasses.Citizen.Gender;
import basicServices.DBService;

public class VoterIdentificationDB {
	private DBService dbService;
	public VoterIdentificationDB(String url,String user, String password){
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
	public Citizen getCitizen(int ID){
		String Expression = "SELECT * FROM citizen WHERE ID = "+ID;
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
		return new Citizen((int)inf[0],(String)inf[1],(String)inf[2],(Address)inf[3],(Gender)inf[4],(int)inf[5],(boolean)inf[6]);
	}
	public void editCitizen(int ID){
		String Expression = "UPDATE citizen SET canVote = 0 WHERE ID="+ID;
		try {
			dbService.action(Expression);
		} catch (SQLException e) {
			//new errorWindow("SQL error");
			e.printStackTrace();
		}
	}
	
}
