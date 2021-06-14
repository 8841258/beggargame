package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
		public Connection conn;
		
		protected DAO() {
			String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
			
			try {
				conn = DriverManager.getConnection(url);
				System.out.println("게임에 연결되었습니다.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

		
		
	}
	
	

