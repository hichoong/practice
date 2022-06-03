package view;

import member.MemberController;
import util.InputUtil;

public class MemberView {
	//회원 관련 메뉴 
	public void showMenu() {
		System.out.println("===== 회원 =====");
		System.out.println("1. 회원가입");   //로그인 X 
		System.out.println("2. 로그인");    //로그인 X
		System.out.println("3. 마이페이지");  //로그인 O
		System.out.println("4. 회원탈퇴");   //로그인 O
		
	int menu = InputUtil.scanInt();
	switch(menu) {
	case 1 : new MemberController().join(); break;
	case 2 : new MemberController().login(); break;
	case 3 : new MemberController().edit(); break;
	case 4 : new MemberController().quit(); break;
	
	
	
	}
	}

}
