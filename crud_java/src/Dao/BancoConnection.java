package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoConnection {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pessoa";
	
	//"jdbc:mysql://localhost/pessoa?useTimezone=true&serverTimezone=UTC ";
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "Teste#3214";
	
	
	
	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		}catch(ClassNotFoundException | SQLException ex) {
			System.err.println("Erro: " + ex);
			return null;
		}
		
	}
		
		
	public static void closeConnection (Connection con) {
			
			if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException ex) {
	                System.err.println("Erro: " + ex);
	            }
				
			}
			
		}
		
	
	/*public static Connection createConnection() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		
		return connection;
	}
	
	public static void main(String[] args) {
		
		Connection con = CreateConnectionToMysql();
		
		if (con != null) {
			System.out.println("Conexão obtida");
			con.close();
		}
		
		
	}*/

}
