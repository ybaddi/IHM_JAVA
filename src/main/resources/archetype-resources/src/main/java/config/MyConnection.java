package main.java.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	// url
	private static String url = "jdbc:mysql://192.168.57.4:3306/";

	// user
	private static String user = "root";
	// password
	private static String password = "baddiroot";

	// database name
	private static String database_name ="estsb";

	// connexion
	private static Connection connexion = null;
	
	private MyConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection(url+database_name,user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnexion() {
		if(connexion == null) {
			new MyConnection();
		}
		return connexion;
	}

	
	public static void desconnect() {
		if(connexion != null) {
			try {
			connexion.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
