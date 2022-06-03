package member;

import java.sql.Connection;

import util.JdbcTemplate;

public class MemberService {
	//커넥션
	private Connection conn = JdbcTemplate.getConnection();
	
	//회원가입 서비스 로직
	public int join(MemberVo vo) {
		
		//비밀번호 유효성 검사(비밀번호 길이가 4 이상s인지 검사)
		if(vo.getPwd().length() < 4) {
			//회원가입실패
			return -1;
		}
		//아이디 중복 검사
		int dupResult = new MemberDao().checkDup(conn, vo.getId());
		if(dupResult > 0 ) {
			return -2;
		}
		
		
		//아이디 유효성 검사(관리자 계정일 시)
		if("admin".equals(vo.getId())) {
		//회원가입 실패
			return -2;
		}
		//여기까지 무사히 온다면 통과(DB에 INSERT)
		int result = new MemberDao().join(conn, vo);
		//결과에 따라 로직 처리
		if(result == 1) { 
		JdbcTemplate.commit(conn);
		System.out.println("커밋 완료");	
		return result;
		} else {
			//롤백
		JdbcTemplate.rollback(conn);
		System.out.println("롤백 완료");
		}
		return result;
	}

}
