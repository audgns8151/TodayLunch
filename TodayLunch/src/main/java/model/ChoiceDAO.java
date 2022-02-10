package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class ChoiceDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;
	ChoiceDTO dto=null;

	int cnt = 0;

	public void DBconn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_e_1_0115";
			String dbpw = "smhrd1";
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String dbid = "hr";
//			String dbpw = "hr";
			

			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void DBclose() {

		try {

			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//메뉴이미지와 설명 보여주기 메소드
	
		public ArrayList<ChoiceDTO> showMessage(String input_btn) {
			
			ArrayList<ChoiceDTO> list = new ArrayList<ChoiceDTO>();
			try {
				DBconn();
				
				
				String sql = "select * from t_food where f_type = ?";
				
				psmt = conn.prepareStatement(sql);
			
				psmt.setString(1, input_btn);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					
					String type = rs.getString(1);
					String image = rs.getString(2);
					String explain = rs.getString(3);
				ChoiceDTO dto = new ChoiceDTO(type, image, explain); //String type, String image, String explain
					list.add(dto);
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBclose();
			}return list;
		}
			
		
		
}
