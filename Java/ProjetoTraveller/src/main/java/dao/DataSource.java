package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

public class DataSource {
	
	private Connection connection;
	
	private String url;
	private String hostname;
	private String username;
	private String password;
	private String database;
	private int port;
	
	public DataSource() {
		try {
			
				DriverManager.registerDriver(new OracleDriver());
				
				hostname = "localhost";
				port = 1521;
				username = "TRAVELLER";
				password = "123";
				database = "XEPDB1";
				url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
				
				connection = DriverManager.getConnection(url, username, password);
				
				if(connection == null) {
					System.out.println("Erro ao conectar com o BD");
				} else {
					System.out.println("Conexão feita com sucesso!");
				}
			}
		catch(Exception ex){
			System.out.println("Falha na conexão com o BD: " + ex.getMessage());
		}		
	}	
	public Connection getConnection() {
		return this.connection;
	}
}
