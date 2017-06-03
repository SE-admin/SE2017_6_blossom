/**
 * @title : DataBaseConn.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.0.1.
 * @since : 2017 - 06 - 04
 * @brief : 데이터 베이스 연동 String
 * ------------------------------
 * @history
 	author		version		date		brief
 	임현			1.0.0.		2017-06-04	초안 작성
 	임현			1.0.1.		2017-06-04	주석 오타 수정 및 주석 추가
 * ------------------------------
 */

package se.smu;

public class DataBaseConn {
	// Class.forName(DataBaseConn.forName);
	public static String forName = "com.mysql.cj.jdbc.Driver";
	
	// conn = DriverManager.getConnection(DataBaseConn.getConn, "root", "0000");
	public static String getConn = "jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&useSSL=false";
}
