package se.smu.Interface;

/**
 * @title : TodoList표시.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 04 - 28
 * @brief : TodoList표시 인터페이스 구축
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

public class TodoList표시 extends JFrame {
	JButton jb1, jb2, jb3;
	JTextField jt1, jt2, jt3;
	JTable jtb;
	JComboBox jcb;
	JCheckBox jck1, jck2;

	TodoList표시() {
		setTitle("To do List 표시");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.setLocation(740, 50);
		jp1.setSize(400, 30);
		jp1.setLayout(new GridLayout(1, 3));
		JButton jb1 = new JButton("추가");
		JButton jb2 = new JButton("삭제");
		JButton jb3 = new JButton("변경");
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		add(jp1);
		
		jp2.setLocation(740, 150);
		jp2.setSize(90, 180);
		jp2.setLayout(new GridLayout(6, 1));
		jp2.add(new JLabel("과목 명"));
		jp2.add(new JLabel("To do 항목 명"));
		jp2.add(new JLabel("마감기한"));
		jp2.add(new JLabel("실제 마감일"));
		jp2.add(new JLabel("완료 여부"));
		jp2.add(new JLabel("중요 여부"));
		add(jp2);

		jp3.setLocation(860, 150);
		jp3.setSize(200, 180);
		jp3.setLayout(new GridLayout(6, 1));
		JComboBox jcb = new JComboBox();
		jcb.addItem("소프트웨어공학"); // 과목 추가 요망
		JCheckBox jck1 = new JCheckBox(" 완료");
		JCheckBox jck2 = new JCheckBox(" 중요");
		JTextField jt1 = new JTextField();
		JTextField jt2 = new JTextField();
		JTextField jt3 = new JTextField();
		jp3.add(jcb);
		jp3.add(jt1);
		jp3.add(jt2);
		jp3.add(jt3);
		jp3.add(jck1);
		jp3.add(jck2);
		add(jp3);
		
		String row[] = 
			{"과목명", "To do List", "마감 기한", "실제 마감일", "완료 여부", "중요여부"};
		String column[][] = 
			{
					{"소프트웨어공학", "요구사항명세서 작성", "2017-04-28", "2017-04-28", "X", "O"},
					{"인공지능", "재정상담시스템 구현", "2017-05-01", "2017-05-02", "X", ""}
			};
		JTable jtb = new JTable(column, row);
		jtb.setLocation(10, 10);
		jtb.setSize(700, 400);
		JScrollPane js = new JScrollPane(jtb);
		js.setSize(700, 400);
		add(js);

		setSize(1200, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TodoList표시();
	}
}