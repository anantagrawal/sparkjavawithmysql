package sparkjavacrud.sparkjava.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	Connection connection = null;
	
	public Connection getConnnection() {
		try {
		 String connectionURL = "jdbc:mysql://localhost:3306/product";
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 connection = DriverManager.getConnection(connectionURL, "root", "Anant23!!!");
		} catch (Exception e) {
			
		}
		return connection;
	}
	
	public void closeConnection(){
		if(connection != null){
			try{
				connection.close();
			}
			catch(Exception e){
				
			}
		}
	}
}
