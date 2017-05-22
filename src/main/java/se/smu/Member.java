/**
 * @title : Member.java
 * @author : 임현 (201511054@sangmyung.kr)
 * @version : 1.0.0.
 * @since : 2017 - 05 - 22
 * @brief : 맴버 클래스 구현
 * ------------------------------
 * @history : 
 	author		version		date			brief
 	임현			1.0.0.		2017-05-22		초안 작성
 * ------------------------------
 */

package se.smu;

public class Member { // 뱀버 클래스
	String sID; // 아이디
	private String sPassword; // 비밀번호
	String sEmail; // 이메일

	public Member(String sID, String sPassword, String sEmail) {
		this.sID = sID;
		this.sPassword = sPassword;
		this.sEmail = sEmail;
	}
}
