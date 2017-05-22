package se.smu.Interface;

/**
 * @title : 로그인문제해결.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 04 - 28
 * @brief : 로그인문제해결 인터페이스 구축
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

public class 로그인문제해결 extends JFrame {
	JButton jb1;
	JTextField jt1;
	JTextArea jta;

	로그인문제해결() {
		setTitle("로그인문제해결");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.setLocation(50, 60);
		jp1.setSize(300, 100);
		JButton jb1 = new JButton("입력");
		jp1.add(jb1);
		add(jp1);

		jp2.setLocation(10, 10);
		jp2.setSize(90, 80);
		jp2.add(new JLabel("이메일"));
		add(jp2);

		jp3.setLocation(150, 10);
		jp3.setSize(200, 30);
		jp3.setLayout(new GridLayout(1, 1));
		JTextField jt = new JTextField();
		jp3.add(jt);
		add(jp3);

		setSize(400, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new 로그인문제해결();
	}
}