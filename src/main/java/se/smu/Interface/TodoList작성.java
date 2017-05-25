package se.smu.Interface;

/**
 * @title : TodoList작성.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 04 - 27
 * @brief : TodoList작성 인터페이스 구축
 * ------------------------------
 * @history : 
 	author		version		date
 	임현			1.0.0.		2017-04-27
 * ------------------------------
 */

//import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoList작성 extends JFrame {
	JButton jb1;
	JTextField jt1, jt2, jt3;
	JTextArea jta;
	JComboBox jcb;
	JCheckBox jck1, jck2;

	TodoList작성() {
		setTitle("To do List 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.setLocation(10, 200);
		jp1.setSize(300, 100);
		JButton jb1 = new JButton("입력");
		jp1.add(jb1);
		add(jp1);

		jp2.setLocation(10, 10);
		jp2.setSize(90, 180);
		jp2.setLayout(new GridLayout(6, 1));
		jp2.add(new JLabel("과목 명"));
		jp2.add(new JLabel("To do 항목 명"));
		jp2.add(new JLabel("마감기한"));
		jp2.add(new JLabel("실제 마감일"));
		jp2.add(new JLabel("완료 여부"));
		jp2.add(new JLabel("중요 여부"));
		add(jp2);

		jp3.setLocation(150, 10);
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

		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TodoList작성();
	}
}