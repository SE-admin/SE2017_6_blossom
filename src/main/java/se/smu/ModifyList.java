/**
 * @title : ModifyList.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 05 - 31
 * @brief : 리스트 수정 코드
 * ------------------------------
 * @history
    author      version      date      brief
        황은선      		1.0.0.      2017-05-30   초안 작성
 * ------------------------------
 */

package se.smu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import se.smu.ListDB;

public class ModifyList {
	// 기본 변수 선언
	Scanner in = new Scanner(System.in);
	static String ModiListName;
	static String ModiDeadLine;
	static String ModiFinishDay;
	static String ModiFinish;
	static String ModiImportance;
	static String ListName;
	static String DeadLine;
	static String FinishDay;
	static String Finish;
	static String Importance;

	// 수정된 List정보 입력
	public ModifyList() {
		ModiListName = in.next();
		ModiDeadLine = in.next();
		ModiFinishDay = in.next();
		ModiFinish = in.next();
		ModiImportance = in.next();

	}

	public static void main(String[] args) {

		new ModifyList();

		try {
			// 기본 변수 선언
			Connection conn = null;
			String sql;
			Statement st = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			// DB연동
			Class.forName("com.mysql.jdbc.Driver"); // 1.0.3. 버전에서 DB연동 시도
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?=UTC&useSSL=false", "root", "0000");

			// 사용할 DB설정, 리스트정보 불러오기
			st = conn.createStatement();
			sql = "USE ListDB";
			st.execute(sql);
			rs = st.executeQuery("Select * from Listinfo");

			// 입력받은 ListName과 ListDB의 정보중 일치하는 것이 있으면 삭제
			while (rs.next()) {
				ListName = rs.getString("ListName");
				DeadLine = rs.getString("DeadLine");
				FinishDay = rs.getString("FinishDay");
				Finish = rs.getString("Finish");
				Importance = rs.getString("Importance");

				if ((ModiListName.equals(ListName)) || (ModiDeadLine.equals(DeadLine))
						|| (ModiFinishDay.equals(FinishDay)) || (ModiFinish.equals(Finish))
						|| (ModiImportance.equals(Importance))) {
					sql = "UPDATE Listinfo SET ListName=" + "\'"+ModiListName+"\'" + "where ListName=" + "\'" +ListName+ "\'";
					st.execute(sql);
					sql = "UPDATE Listinfo SET DeadLine=" + "\'"+ModiDeadLine+"\'" + "where DeadLine=" + "\'" +DeadLine+ "\'";
					st.execute(sql);
					sql = "UPDATE Listinfo SET FinishDay=" + "\'"+ModiFinishDay+"\'" + "where FinishDay=" + "\'" +FinishDay+ "\'";
					st.execute(sql);
					sql = "UPDATE Listinfo SET Finish=" + "\'"+ModiFinish+"\'" + "where Finish=" + "\'" +Finish+ "\'";
					st.execute(sql);
					sql = "UPDATE Listinfo SET Importance=" + "\'"+ModiImportance+"\'" + "where Importance=" + "\'" +Importance+ "\'";
					st.execute(sql);
				}
			}

			// 실행창 닫기
			rs.close();
			st.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}