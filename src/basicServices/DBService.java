package basicServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBService
{
	private final static String DRIVER="com.mysql.jdbc.Driver";
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public DBService(String url,String user, String password) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {       
//        String url="jdbc:mysql://localhost:3306/"+dataSourceName;
        Class.forName(DRIVER).newInstance();
//        System.setProperty(DRIVER, "");
        connection=DriverManager.getConnection(url, user, password);
        statement=connection.createStatement();
    }
    
    public ArrayList<Object[]> getData(String sqlExpression) throws SQLException
    {
        resultSet=statement.executeQuery(sqlExpression);
        int numOfCols=resultSet.getMetaData().getColumnCount();
        ArrayList<Object[]> data=new ArrayList<>();
        
        Object[] l;
        
        while(resultSet.next())
        {
            l=new Object[numOfCols];
            for(int i=0; i<numOfCols; i++)
                l[i]=(resultSet.getObject(i+1));
            data.add(l);
        }
        return data;
    }
    
    public ArrayList<Object[]> getData(String sqlExpression,String[] columns) throws SQLException
    {
        resultSet=statement.executeQuery(sqlExpression);
        int numOfCols=columns.length;
        ArrayList<Object[]> data=new ArrayList<>();
        
        Object[] l;
        
        while(resultSet.next())
        {
            l=new Object[numOfCols];
            for(int i=0; i<numOfCols; i++)
                l[i]=(resultSet.getObject(columns[i]));
            data.add(l);
        }
        return data;
    }
    
    public void action(String sqlExpression) throws SQLException
    {
        statement.executeUpdate(sqlExpression);
    }
    public void close() throws SQLException{
    	statement.close();
    	connection.close();
    }
}
