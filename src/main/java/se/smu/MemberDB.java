/**
 * @title : MemberDB.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.0.2.
 * @since : 2017 - 05 - 29
 * @brief : 회원정보 DB
 * ------------------------------
 * @history
 	author		version		date		brief
 	황은선		1.0.0.		2017-05-29	초안 작성
 	황은선	    1.0.1.		2017-05-29	주석 수정 및 코드 공백 정리
 	임현			1.0.2.		2017-05-30	history 주석 수정
 * ------------------------------
 */

package se.smu;

import java.sql.*;
import java.util.Scanner;
import se.smu.Join;

public class MemberDB {
	void MemberTable(String ID, String Passward, String Email) {
		try {
			// 기본 변수 선언
			Scanner in = new Scanner(System.in);
			Connection conn = null;
			String sql;
			Statement st = null;
			PreparedStatement pst = null;

			// DB연동
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false", "root", "0000"); // JDBC
																													// 연결

			// DB생성,TABLE생성
			st = conn.createStatement();
			sql = "CREATE DATABASE MemberDB";
			st.execute(sql);
			sql = "USE MemberDB";
			st.execute(sql);
			sql = "CREATE TABLE MemberInfo (ID char(30), Passward char(40), Email char(60))";
			st.execute(sql);

			// 입력받은 회원정보를 DB에 삽입
			sql = "INSERT INTO MemberInfo(ID,Passward,Email) values(?,?,?)";
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery("select ID, Passward, Email from MemberInfo");

			pst.setString(1, ID);
			pst.setString(2, Passward);
			pst.setString(3, Email);
			pst.executeUpdate();

			// 실행창 닫기
			rs.close();
			pst.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MemberDB();
	}
}
