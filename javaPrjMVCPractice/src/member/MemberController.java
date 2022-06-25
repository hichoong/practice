package member;

import util.InUtil;

public class MemberController {

	public void join() {
		System.out.println("===== 회원가입 =====");
		
		System.out.println("아이디 : ");
		String id = InUtil.sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String pwd = InUtil.sc.nextLine();
		
		System.out.println("닉네임 : ");
		String nick = InUtil.sc.nextLine();
		
		System.out.println("전화번호 : ");
		String phone = InUtil.sc.nextLine();
		
		System.out.println("성별 : ");
		String gender = InUtil.sc.nextLine();
		
		MemberVo vo = new MemberVo(id, pwd, nick, phone, gender);
		int result = new MemberService().join(vo);
		
		if(result == 1) {
			System.out.println("회원가입 성공 !!!");
		} else if(result == -1) {
			System.out.println("비밀번호는 4글자 이상이어야 합니다.");
		} else if(result == -2) {
			System.out.println("아이디를 다시 입력하시기 바랍니다.");
		} else {
			System.out.println("회원가입 실패 !!!");
		}
		
		
	}

	public void login() {
		System.out.println("===== 로그인 =====");
		System.out.println("아이디 : ");
		String id = InUtil.sc.nextLine();
		System.out.println("비밀번호 : ");
		String pwd = InUtil.sc.nextLine();
	
	}

	public void edit() {
		System.out.println("===== 회원정보수정 =====");
	}

	public void quit() {
		System.out.println("===== 탈퇴 =====");
	}

}
