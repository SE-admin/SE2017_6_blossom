/**
 * @title : DeleteList.java
 * @author : 황은선 (201511077@sangmyung.kr)
 * @version : 1.1.1.
 * @since : 2017 - 05 - 30
 * @brief : 리스트 삭제 코드
 * ------------------------------
 * @history
   author		version		date		brief
        황은선  	    1.0.0.      2017-05-30    초안 작성
        황은선       		1.1.0.      2017-05-31    기능 완성 
        임현			1.1.1.		2017-06-02	UTF-8 Type 수정
 * ------------------------------
 */

package se.smu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import se.smu.ListDB;

public class DeleteList {
   // 기본 변수 선언
      Scanner in = new Scanner(System.in);
      static String DeleteListName;
      static String ListName;

      //
      public DeleteList() {
         DeleteListName = in.next();
      }

      public static void main(String[] args) {
         
         new DeleteList();
         
         try {
            // 기본 변수 선언
            Connection conn = null;
            String sql;
            Statement st = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

            // DB연동
            Class.forName("com.mysql.jdbc.Driver"); // 1.0.3. 버전에서 DB연동 시도
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?=UTC&useSSL=false", "root", "0000");

            // 사용할 DB설정, 리스트정보 불러오기
            st = conn.createStatement();
            sql = "USE ListDB";
            st.execute(sql);
            rs = st.executeQuery("Select ListName from Listinfo");
            
            // 입력받은 ListName과 ListDB의 정보중 일치하는 것이 있으면 삭제
            while (rs.next()) {
               ListName=rs.getString("ListName");
               if (ListName.equals(DeleteListName))
               {
                  sql="DELETE FROM Listinfo where ListName="+"\'"+DeleteListName+"\'";
                  st.execute(sql);
               }
            }
            
            // 실행창 닫기
            rs.close();
            st.close();

         } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
         }

      }
}