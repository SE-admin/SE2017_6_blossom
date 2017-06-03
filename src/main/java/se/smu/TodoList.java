/**
 * @title : TodoList.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.4.0.
 * @since : 2017 - 05 - 31
 * @brief : To do List
 * ------------------------------
 * @history
 	author		version		date		brief
 	임현			1.0.0.		2017-06-01	초안 작성 (InsertList 구현)
 	임현			1.0.1.		2017-06-02	Checkbox false 추가
 	임현			1.1.0.		2017-06-02	DeleteList 연동
 	임현			1.2.0.		2017-06-03	ModifyList 연동
 	임현			1.3.0.		2017-06-03	InsertCourInfo 연동
 	임현			1.3.1.		2017-06-03	ShowTable 함수 추가
 	황은선		1.4.0.		2017-06-04	ShowTable 함수 완성
 * ------------------------------
 */

package se.smu;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import se.smu.*;
import javax.swing.table.DefaultTableModel;

public class TodoList extends JFrame {
	/**
	 * @title : ShowTable
	 * @author : 황은선
	 * @brief : Table을 갱신해주는 함수
	 */
	public void ShowTable () {
		// 기본 변수 선언
		String row[]={"과목명", "To do List", "마감 기한", "실제 마감일", "완료 여부", "중요여부"};
		Connection conn = null;
		String sql;
		String str=null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DefaultTableModel model = new DefaultTableModel(row, 0);		
		model.addRow(row);//테이블에 행 추가

		try{
			// DB연동
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&useSSL=false", "root", "0000");

			// 사용할 DB설정, 리스트 정보 불러오기
			st = conn.createStatement();
			sql = "USE ListDB";
			st.execute(sql);
			rs = st.executeQuery("select * from Listinfo");
			
			while(rs.next())
			{
				for(int i=1;i<6;i++)
				{
					row[i]=rs.getString(i);
				}
				model.addRow(row);				
			}
			rs.close();
			st.close();
		}
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		
		JTable jtb = new JTable(model);
		jtb.setLocation(10, 10);
		jtb.setSize(700, 400);
		JScrollPane js = new JScrollPane(jtb);
		js.setSize(700, 400);
		add(js);
	}
	
	
	// 변수 선언
	JButton jb1, jb2, jb3, jb4;
	JTextField jt1, jt2, jt3;
	JTable jtb;
	JComboBox jcb;
	JCheckBox jck1, jck2;
	
	static String ListName;
	static String DeadLine;
	static String FinishDay;
	static String Finish;
	static String Importance;
	
	String ModiListName;
	String ModiDeadLine;
	String ModiFinishDay;
	String ModiFinish;
	String ModiImportance;
	
	String DeleteListName;
	
	String strFinish;
	String strImport;
	
	TodoList() {
		setTitle("To do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.setLocation(740, 50);
		jp1.setSize(400, 30);
		jp1.setLayout(new GridLayout(1, 4));
		JButton jb1 = new JButton("추가");
		JButton jb2 = new JButton("삭제");
		JButton jb3 = new JButton("변경");
		JButton jb4 = new JButton("과목 추가");
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
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
		
		ShowTable();

		setSize(1200, 400);
		setVisible(true);
		
		jb1.addActionListener(new ActionListener() { // InsertList.java 참고
			public void actionPerformed(ActionEvent e) {
				ListName = jt1.getText();
				DeadLine = jt2.getText();
				FinishDay = jt3.getText();
				if (jck1.isSelected()) 	strFinish = "true"; // 데이터베이스에 boolean값이 가능할 경우 할 필요 없음
				else strFinish = "false";
				if (jck2.isSelected()) 	strImport = "true";
				else strImport = "false";
				
				
				Finish = strFinish;
				Importance = strImport;
				
				ListDB listdb = new ListDB();
				listdb.ListTable(ListName, DeadLine, FinishDay, Finish, Importance);
				
				ShowTable();
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteListName = jt1.getText(); // java.sql.SQLException: Operation not allowed after ResultSet closed 오류
				new DeleteList(DeleteListName);
				
				ShowTable();
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModiListName = jt1.getText();
				ModiDeadLine = jt2.getText();
				ModiFinishDay = jt3.getText();
				if (jck1.isSelected()) 	ModiFinish = "true"; // 데이터베이스에 boolean값이 가능할 경우 할 필요 없음
				else ModiFinish = "false";
				if (jck2.isSelected()) 	ModiImportance = "true";
				else ModiImportance = "false";
				
				// java.sql.SQLException: Operation not allowed after ResultSet closed 오류
				new ModifyList(ModiListName, ModiDeadLine, ModiFinishDay, ModiFinish, ModiImportance);		
				
				ShowTable();
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertCourInfo();
			}
		});
	}
	
	public static void main(String[] args) {
		new TodoList();
	}
}