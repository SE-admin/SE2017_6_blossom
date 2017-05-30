/**
 * @title : Join.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.0.2.
 * @since : 2017 - 05 - 29
 * @brief : 회원가입 코드
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
import se.smu.MemberDB;

public class Join {
	// 기본 변수 선언
	Scanner in = new Scanner(System.in);
	static String ID;
	static String Passward;
	static String Email;

	// 회원정보 입력받기
	public Join() {
		ID = in.next();
		Passward = in.next();
		Email = in.next();
	}

	public static void main(String[] args) {
		new Join();
		MemberDB memberdb = new MemberDB();
		memberdb.MemberTable(ID, Passward, Email);
	}
}