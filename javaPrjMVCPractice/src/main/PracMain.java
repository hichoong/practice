package main;

import util.InUtil;
import view.memberView;

public class PracMain {

	public static void main(String[] args) {
		
		
		System.out.println("===== MVC 연습하기 =====");
		System.out.println("[1] 회원 페이지");
		System.out.println("[2] 게시판");
		System.out.println("[3] 갤러리");
		System.out.println("[4] 공지사항");
		System.out.println("[5] ???");
		
		int choice = InUtil.scanInt();
	
		switch(choice) {
		
		case 1 :new memberView().showMenu();	break;
		case 2 :	break;
		case 3 :	break;
			
		
		
		}
	}

}
