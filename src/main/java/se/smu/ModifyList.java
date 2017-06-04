/**
 * @title : ModifyList.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.2.2.
 * @since : 2017 - 05 - 31
 * @brief : 리스트 수정 코드
 * ------------------------------
 * @history
   author		version		date		brief
        황은선      		1.0.0.      2017-05-30    초안 작성
        황은선			1.1.0.		2017-05-31    기능 완성
        임현			1.1.1.		2017-06-02	UTF-8 Type 수정
        임현			1.2.0.		2017-06-02	매개변수 추가
        임현			1.2.1.		2017-06-04	데이터베이스 연동 수정
        임현			1.2.2.		2017-06-04	데이터베이스 연동 수정
 * ------------------------------
 */

package se.smu;

import se.smu.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class ModifyList {
	// 기본 변수 선언
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
	public ModifyList(String ModiListName, String ModiDeadLine, String ModiFinishDay, String ModiFinish, String ModiImportance) {
		this.ModiListName = ModiListName;
		this.ModiDeadLine = ModiDeadLine;
		this.ModiFinishDay = ModiFinishDay;
		this.ModiFinish = ModiFinish;
		this.ModiImportance = ModiImportance;
		
		try {
			// 기본 변수 선언
			Connection conn = null;
			String sql;
			Statement st = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			// DB연동
			Class.forName(DataBaseConn.forName);
			conn = DriverManager.getConnection(DataBaseConn.URL, DataBaseConn.ID, DataBaseConn.PASSWORD);

			// 사용할 DB설정, 리스트정보 불러오기
			st = conn.createStatement();
			sql = "USE ListDB";
			st.execute(sql);
			rs = st.executeQuery("Select * from Listinfo");

			// 입력받은 ListName과 ListDB의 정보중 일치하는 것이 있으면 삭제
			while (rs.next()) {
				ModiListName = rs.getString("ListName");
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

	public static void main(String[] args) {
		new ModifyList(ModiListName, ModiDeadLine, ModiFinishDay, ModiFinish, ModiImportance);
	}
}