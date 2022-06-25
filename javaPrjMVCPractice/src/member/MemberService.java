package member;

import java.sql.Connection;

import util.JdbcTemp;


public class MemberService {

private Connection conn = JdbcTemp.getConnection();
	
	public int join(MemberVo vo) {
		
		if(vo.getPwd().length() < 4) {
			return -1;
		}
		int dupResult = new MemberDao().checkDup(conn, vo.getId());
		if(dupResult > 0 ) {
			return -2;
		}
		
		
		if("admin".equals(vo.getId())) {
			return -2;
		}
		int result = new MemberDao().join(conn, vo);
		if(result == 1) { 
		JdbcTemp.commit(conn);
		System.out.println("커밋 완료");	
		return result;
		} else {
		JdbcTemp.rollback(conn);
		System.out.println("롤백 완료");
		}
		return result;
	}
}
