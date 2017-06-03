/**
 * @title : ListDB.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.0.3.
 * @since : 2017 - 05 - 29
 * @brief : 리스트 정보 DB
 * ------------------------------
 * @history
 	author		version		date		brief
 	황은선		1.0.0.		2017-05-29	초안 작성
 	황은선	    1.0.1.		2017-05-29	주석 수정 및 코드 공백 정리
 	임현			1.0.2.		2017-05-30	history 주석 수정
 	임현			1.0.3.		2017-05-31	DB 연동
 	황은선		1.0.4.		2017-06-03	DB 중복 생성 수정
 * ------------------------------
 */

package se.smu;

import java.sql.*;
import java.util.Scanner;
import se.smu.InsertCourInfo;

public class ListDB {
	void ListTable(String ListName, String DeadLine, String FinishDay, String Finish, String Importance) {
		try {
			// 기본 변수 선언
			int Create_Flag = 0;
			String database;
			Scanner in = new Scanner(System.in);
			Connection conn = null;
			String sql;
			Statement st = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			// DB연동
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&useSSL=false",
					"root", "0000"); // JDBC 연결

			st = conn.createStatement();
			rs = st.executeQuery("SHOW DATABASES");

			while (rs.next()) {
				database = rs.getString("Database");
				if (database.equals("listdb"))
					Create_Flag = 1;
			}

			if (Create_Flag == 0) // 해당 DB가 없을 경우 DB생성, TABLE생성
			{
				sql = "CREATE DATABASE ListDB";
				st.execute(sql);
				sql = "USE ListDB";
				st.execute(sql);
				sql = "CREATE TABLE ListInfo (ListName char(40), DeadLine char(20), FinishDay char(20), Finish char(5), Importance char(10))";
				st.execute(sql);

			} else {// 해당 DB가 존재할 경우
				sql = "USE ListDB";
				st.execute(sql);
				// 입력받은 리스트정보를 DB에 삽입
				sql = "INSERT INTO ListInfo(ListName, DeadLine, FinishDay, Finish, Importance) values(?,?,?,?,?)";
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery("select ListName, DeadLine, FinishDay, Finish, Importance from ListInfo");
			}

			pst.setString(1, ListName);
			pst.setString(2, DeadLine);
			pst.setString(3, FinishDay);
			pst.setString(4, Finish);
			pst.setString(5, Importance);
			pst.executeUpdate();

			// 실행창 닫기
			rs.close();
			pst.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ListDB();

	}
}