package member;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() throws Exception {
		
		Connection conn = null;
		
		try {
			
			String user = "ezen";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
