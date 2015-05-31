package ballotManager;

import java.sql.SQLException;

import basicServices.DBService;

public class BallotManagerClient {

	
	public static void main(String[] args) {
		DBService db=null;
		try {
			db=new DBService("jdbc:mysql://localhost:3306/votedb", "root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
