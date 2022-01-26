package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class MemberDAO {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;
	MemberDTO dto=null;

	int cnt = 0;

	public void DBconn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_e_1_0115";
			String dbpw = "smhrd1";
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

	
	
	//로그인 서비스
	public MemberDTO login(MemberDTO dto) {
		MemberDTO info = null;

		System.out.println(dto.getEmail());
		System.out.println(dto.getPw());

		try {
			DBconn();
			System.out.println("DB연결됨");

			String sql = "select*from test_member where email=? and pw=?";

			// SQL문 전달
			psmt = conn.prepareStatement(sql);
			// ?에 값 채우기
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());

			// 실행
			rs = psmt.executeQuery();

			// rs.next(): 커서를 내렸을때 값이 있는지 없는지 확인하는 메소드
			// 있으면 true 없으면 false
			if (rs.next()) {
				String email = rs.getString("email");
				String pw = rs.getString(2);
				String nickname = rs.getString(3);
				String dong = rs.getString(4);

				System.out.println(email + pw + nickname + dong);

				info = new MemberDTO(email, pw, nickname, dong);
				System.out.println(info.getEmail());

			}

		} catch (Exception e) {

		} finally {
			DBclose();
		}
		return info;
	}

	// 회원가입 메소드
	public int join(MemberDTO dto) {

		try {
			DBconn();

			String sql = "insert into test_member values(?,?,?,?)";

			// sql-> DB에 전달
			psmt = conn.prepareStatement(sql);

			// ?에 값 넣어주기

			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getNickname());
			psmt.setString(4, dto.getDong());

			// 실행
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();

		}
		return cnt;

	}

	

}
