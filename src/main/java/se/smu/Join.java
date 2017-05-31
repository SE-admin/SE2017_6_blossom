/**
 * @title : Join.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.1.2.
 * @since : 2017 - 05 - 29
 * @brief : 회원가입 코드
 * ------------------------------
 * @history
 	author		version		date		brief
 	황은선		1.0.0.		2017-05-29	초안 작성
 	황은선	    1.0.1.		2017-05-29	주석 수정 및 코드 공백 정리
 	임현			1.0.2.		2017-05-30	history 주석 수정
 	임현			1.1.0.		2017-05-31	UI 연동
 	임현			1.1.1.		2017-05-31	UI, DB, 기능 연동 성공
 	임현			1.1.2.		2017-05-31	Passward 오타 수정
 * ------------------------------
 */

package se.smu;

import java.awt.*;
import java.awt.event.*; // 액션 리스너
import javax.swing.*;
import java.util.*;
import java.sql.*;
import se.smu.MemberDB;

public class Join extends JFrame{
	// 기본 변수 선언
	Scanner in = new Scanner(System.in);
	static String ID;
	static String Password;
	static String Email;
	
	// UI 변수 선언
	JButton jb1; // 입력 버튼
	JTextField jt1, jt2, jt3; // 아이디, 비밀번호, 이메일
	// JPasswordField jpw; // 비밀번호

	// 회원정보 입력받기
	public Join() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.setLocation(50, 120);
		jp1.setSize(300, 100);
		JButton jb1 = new JButton("입력");
		jp1.add(jb1);
		add(jp1);

		jp2.setLocation(10, 10);
		jp2.setSize(90, 80);
		jp2.setLayout(new GridLayout(3, 1));
		jp2.add(new JLabel("아이디"));
		jp2.add(new JLabel("이메일"));
		jp2.add(new JLabel("비밀번호"));
		add(jp2);

		jp3.setLocation(150, 10);
		jp3.setSize(200, 90);
		jp3.setLayout(new GridLayout(3, 1));
		JTextField jt1 = new JTextField();
		JTextField jt2 = new JTextField();
		JTextField jt3 = new JTextField();
		//JPasswordField jpw = new JPasswordField();
		jp3.add(jt1);
		jp3.add(jt2);
		jp3.add(jt3);
		// jp3.add(jpw);
		add(jp3);

		setSize(400, 200);
		setVisible(true);
		
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = jt1.getText();
				Email = jt2.getText();
				Password = jt3.getText();
				MemberDB memberdb = new MemberDB();
				memberdb.MemberTable(ID, Password, Email);
			}
		});
	}

	public static void main(String[] args) {
		new Join();
	}
}