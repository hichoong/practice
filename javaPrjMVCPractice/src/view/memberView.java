package view;

import member.MemberController;
import util.InUtil;

public class memberView {

		
			public void showMenu() {
				System.out.println("===== 회원 =====");
				System.out.println("[1] 회원가입");   
				System.out.println("[2] 로그인");    
				System.out.println("[3] 마이페이지");  
				System.out.println("[4] 회원탈퇴");   
				
			int choice = InUtil.scanInt();
			switch(choice) {
			case 1 : new MemberController().join(); break;
			case 2 : new MemberController().login(); break;
			case 3 : new MemberController().edit(); break;
			case 4 : new MemberController().quit(); break;
			
			
			
			}
		
	}

}
