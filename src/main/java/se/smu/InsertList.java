/**
 * @title : InsertList.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.1.1.
 * @since : 2017 - 05 - 29
 * @brief : 리스트 추가 코드
 * ------------------------------
 * @history
 	author		version		date		brief
 	황은선		1.0.0.		2017-05-29	초안 작성
 	황은선	    1.0.1.		2017-05-29	주석 수정 및 코드 공백 정리
 	임현			1.0.2.		2017-05-30	history 주석 수정
 	임현			1.1.0.		2017-06-02	코드 사용 일시 중지
 	임현			1.1.1.		2017-06-03	오타 수정
 * ------------------------------
 */

// 현재는 TodoList에 UI와 병합하는 코드 사용 중지

/*
package se.smu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import se.smu.ListDB;

public class InsertList {
	// 기본 변수 선언
	Scanner in = new Scanner(System.in);
	static String ListName;
	static String DeadLine;
	static String Importance;
	static String FinishDay;
	static String Finish;

	// 리스트 정보 입력받기
	public InsertList() {
		ListName = in.next();
		DeadLine = in.next();
		FinishDay = in.next();
		Finish = in.next();
		Importance = in.next();
	}

	public static void main(String[] args) {
		new InsertList();
		ListDB listdb = new ListDB();
		listdb.ListTable(ListName, DeadLine, FinishDay, Finish, Importance);
	}
}
*/