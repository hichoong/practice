package com.kim.main;

import com.kim.board.Board;
import com.kim.member.Member;
import com.kim.util.MyUtil;

public class Main {

	public static void main(String[] args) {
		
		while(true) {
			
			System.out.println("미니테스트");
			System.out.println("=======================");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 게시글 작성");
			System.out.println("4. 게시글 조회");
			
			
			int n = MyUtil.scInt();
			
			switch(n) {
			case 1 :new Member().join(); break;
			case 2 :new Member().login(); break;
			case 3 :new Board().write(); break;
			case 4 :new Board().showList(); break;
			case 5 : break;
			default : System.out.println("메뉴를 다시 선택하시오");
			}
		}				
	}
}
