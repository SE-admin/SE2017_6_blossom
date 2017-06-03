/**
 * @title : Main.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 06 - 04
 * @brief : 데이터 베이스 연동 String
 * ------------------------------
 * @history
 	author		version		date		brief
 	임현			1.0.0.		2017-06-03	초안 작성
 * ------------------------------
 */

package se.smu;

public class DataBaseConn {
	public static String forName = "com.mysql.cj.jdbc.Driver";
	public static String getConn = "jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&useSSL=false";
}
