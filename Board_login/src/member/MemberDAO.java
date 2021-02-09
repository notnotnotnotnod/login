package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import member.DBConnection;



public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDAO() {
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertMember(HttpServletRequest request) {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {			
			conn = DBConnection.getConnection();
			request.setCharacterEncoding("UTF-8");
			
			String userid = request.getParameter("id");
			String userpassword = request.getParameter("password");
			String username = request.getParameter("name");
			String usergender = request.getParameter("gender");
			String useremail = request.getParameter("mail");
			
			String query = "insert into member values('"+userid+"','"+userpassword+"','"+username+"','"+usergender+"','"+useremail+"') ";
			System.out.println("query = " + query);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입에러");
		}finally {
			try{
				if ( stmt != null ){ stmt.close(); stmt=null; }
				if ( conn != null ){ conn.close(); conn=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}		
	}
	
	public static int loginCheck(String id, String password) {
		String dbPW = "";
		int x = -1;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		//String query = "select userpassword from member where userid=? and userpassword=?";
		System.out.println("id="+id);
		System.out.println("password="+password);
		
		try {
			conn = DBConnection.getConnection();
			String query = "select userpassword from member";
			
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);

			if(rs.next()) {
				dbPW = rs.getString(1);
				
				if (dbPW.equals(password)) 
					x = 1;
				else 				 
					x = 0;			
				} else {
					x = -1;
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("rs.next = x값"+x);
		return x;
	}
	
}
