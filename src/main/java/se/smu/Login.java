/**
 * @title : Login.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.0.4.
 * @since : 2017 - 05 - 29
 * @brief : 로그인 코드
 * ------------------------------
 * @history
 	author		version		date		brief
 	황은선		1.0.0.		2017-05-29	초안 작성
 	황은선	    1.0.1.		2017-05-29	주석 수정 및 코드 공백 정리
 	임현			1.0.2.		2017-05-30	history 주석 수정
 	임현			1.0.3.		2017-05-30	DB연동 시도
 	임현			1.0.4.		2017-05-31	Passward 오타 수정
 * ------------------------------
 */

package se.smu;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import se.smu.MemberDB;

public class Login {
	// 기본 변수 선언
	Scanner in = new Scanner(System.in);
	static String InputID;
	static String InputPassword;
	static Boolean pass = false;

	// 로그인 할 ID와 Password 입력받기
	public Login() {
		InputID = in.next();
		InputPassword = in.next();
	}

	public static void main(String[] args) {
		try {
			// 기본 변수 선언
			Connection conn = null;
			String sql;
			Statement st = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			// DB연동
			Class.forName("com.mysql.cj.jdbc.Driver"); // 1.0.3. 버전에서 DB연동 시도
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?severTimezone=UTC&useSSL=false", "root", "0000");

			// 사용할 DB설정, 회원정보에서 ID와 Password불러오기
			st = conn.createStatement();
			sql = "USE MemberDB";
			st.execute(sql);
			rs = st.executeQuery("select ID,Password from MemberInfo");

			// Login객체 생성
			Login login = new Login();

			// 입력받은 회원정보와 MemberDB의 회원정보가 일치하는지 대조
			while (rs.next()) {
				if ((InputID == rs.getString("ID")) && (InputPassword == rs.getString("Password")))
					pass = true;
			}
			System.out.println(pass);

			// 실행창 닫기
			rs.close();
			st.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}