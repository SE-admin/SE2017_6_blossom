/**
 * @title : InsertCourInfo.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.0.2.
 * @since : 2017 - 05 - 29
 * @brief : 과목정보 입력 코드
 * ------------------------------
 * @history
 	author		version		date		brief
 	황은선		1.0.0.		2017-05-29	초안 작성
 	황은선	    1.0.1.		2017-05-29	주석 수정 및 코드 공백 정리
 	임현			1.0.2.		2017-05-30	history 주석 수정
 * ------------------------------
 */

package se.smu;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import se.smu.CourDB;

public class InsertCourInfo {
	// 기본 변수 선언
	Scanner in = new Scanner(System.in);
	static String CourName;
	static String CourProf;
	static String CourDay;
	static String CourTime;
	static String CourYear;
	static String CourSeme;

	// 과목정보 입력받기
	public InsertCourInfo() {
		CourName = in.next();
		CourProf = in.next();
		CourDay = in.next();
		CourTime = in.next();
		CourYear = in.next();
		CourSeme = in.next();
	}

	public static void main(String[] args) {
		new InsertCourInfo();
		CourDB courdb = new CourDB();
		courdb.CourTable(CourName, CourProf, CourDay, CourTime, CourYear, CourSeme);
	}
}