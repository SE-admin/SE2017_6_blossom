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
 	임현			1.0.1.		2017-05-23		헝가리안 표기법 제거
 * ------------------------------
 */

package se.smu;

public class Member { // 뱀버 클래스
	String ID; // 아이디
	private String Password; // 비밀번호
	String Email; // 이메일

	public Member(String ID, String Password, String Email) {
		this.ID = ID;
		this.Password = Password;
		this.Email = Email;
	}
}