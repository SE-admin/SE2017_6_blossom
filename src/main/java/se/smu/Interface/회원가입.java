package se.smu.Interface;

/**
 * @title : 회원가입.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 04 - 28
 * @brief : 회원가입 인터페이스 구축
 * ------------------------------
 * @history : 
 	author		version		date
 	임현			1.0.0.		2017-04-28
 * ------------------------------
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class 회원가입 extends JFrame {
	JButton jb1;
	JTextField jt1, jt2;
	JPasswordField jpw;
	JTextArea jta;

	회원가입() {
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
		JPasswordField jpw = new JPasswordField();
		jp3.add(jt1);
		jp3.add(jt2);
		jp3.add(jpw);
		add(jp3);

		setSize(400, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new 회원가입();
	}
}