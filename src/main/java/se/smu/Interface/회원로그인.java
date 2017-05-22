package se.smu.Interface;

/**
 * @title : 회원로그인.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 04 - 27
 * @brief : 회원로그인 인터페이스 구축
 * ------------------------------
 * @history : 
 	author		version		date
 	임현			1.0.0.		2017-04-27
 * ------------------------------
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class 회원로그인 extends JFrame {
	JButton jb1, jb2, jb3, jb4;
	JTextField jt;
	JPasswordField jpw;
	JTextArea jta;

	회원로그인() {
		setTitle("회원 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.setLocation(10, 120);
		jp1.setSize(300, 100);
		jp1.setLayout(new GridLayout(2,2));
		JButton jb1 = new JButton("로그인");
		JButton jb2 = new JButton("회원가입");
		JButton jb3 = new JButton("로그인 문제 해결");
		JButton jb4 = new JButton("탈퇴한 계정 복구");
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		add(jp1);

		jp2.setLocation(10, 10);
		jp2.setSize(90, 80);
		jp2.setLayout(new GridLayout(2, 1));
		jp2.add(new JLabel("아이디"));
		jp2.add(new JLabel("비밀번호"));
		add(jp2);

		jp3.setLocation(70, 10);
		jp3.setSize(200, 90);
		jp3.setLayout(new GridLayout(2, 1));
		JTextField jt = new JTextField();
		JPasswordField jpw = new JPasswordField();
		jp3.add(jt);
		jp3.add(jpw);
		add(jp3);

		setSize(350, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new 회원로그인();
	}
}