package se.smu.Interface;

/**
 * @title : 수강과목등록.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 04 - 27
 * @brief : 수강과목등록 인터페이스 구축
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

public class 수강과목등록 extends JFrame {
	JButton jb1;
	JTextField jt1, jt2, jt3, jt4;
	JTextArea jta;

	수강과목등록() {
		setTitle("수강과목등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.setLocation(10, 120);
		jp1.setSize(300, 100);
		JButton jb1 = new JButton("입력");
		jp1.add(jb1);
		add(jp1);

		jp2.setLocation(10, 10);
		jp2.setSize(90, 80);
		jp2.setLayout(new GridLayout(4, 1));
		jp2.add(new JLabel("과목 명"));
		jp2.add(new JLabel("담당 교수"));
		jp2.add(new JLabel("강의 요일/시간"));
		jp2.add(new JLabel("수강 년도/학기"));
		add(jp2);

		jp3.setLocation(150, 10);
		jp3.setSize(200, 90);
		jp3.setLayout(new GridLayout(4, 1));
		JTextField jt1 = new JTextField();
		JTextField jt2 = new JTextField();
		JTextField jt3 = new JTextField();
		JTextField jt4 = new JTextField();
		jp3.add(jt1);
		jp3.add(jt2);
		jp3.add(jt3);
		jp3.add(jt4);
		add(jp3);

		setSize(400, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new 수강과목등록();
	}
}