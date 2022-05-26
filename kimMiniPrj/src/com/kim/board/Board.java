package com.kim.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.kim.db.OracleDB;
import com.kim.member.Member;
import com.kim.util.MyUtil;


public class Board {

	public void write() {
		//작성자 == 로그인한 유저
		if(Member.loginUserNo == 0) {
			System.out.println("로그인 한 유저만 글을 쓸 수 있습니다.");
			return;
		} 
		//안내 문구 출력
		System.out.println("====게시글 작성====");
		System.out.print("제목 : ");
		String title = MyUtil.sc.nextLine();
		//입력 받기(제목, 내용)
		System.out.print("내용 : ");
		String content = MyUtil.sc.nextLine();
		
		//디비에 저장 
		//연결 얻기
		Connection conn = OracleDB.getOracleConnection();
		//INSERT 쿼리 날리기
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER_NO, REGISTER_DATE, DELETE_YN)"
				+ "VALUES(BOARD_NO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 'N')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Member.loginUserNo);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("게시글 등록 성공!");	
			}else {
				System.out.println("게시글 등록 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDB.close(conn);
			OracleDB.close(pstmt);
		}	
	}

	
	public void showList() {
		System.out.println("====게시글 목록조회====");
		
		//모든 게시글 조회해서 보여주기
		
		//1. 커넥션
		Connection conn = OracleDB.getOracleConnection();
		//2.쿼리 작성
		String sql = "SELECT * FROM BOARD WHERE DELETE_YN = 'N' ORDER BY REGISTER_DATE ASC";
		//3. pstmt 생성
		//4.psmtm 물음표 채우기
		//5. pstmt 실행 (executeQuery)
		//6. 결과 얻기 (결과집합)
		
		System.out.print("글번호");
		System.out.print(" | ");
		System.out.print("게시글 제목");
		System.out.print(" | ");
		System.out.print("작성자 번호");
		System.out.print(" | ");
		System.out.print("게시글 작성일");
		System.out.println("\n-----------------------");
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int no = rs.getInt("NO");
				String title = rs.getString("TITLE");
				int writeNo = rs.getInt("WRITER_NO");
				Timestamp regDate = rs.getTimestamp("REGISTER_DATE");
				
				System.out.print(no);
				System.out.print(" | ");
				System.out.print(title);
				System.out.print(" | ");
				System.out.print(writeNo);
				System.out.print(" | ");
				System.out.print(regDate);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		showBoardDetail(); 
	}
		//6. 결과 얻기 (결과집합)
		//7. 결과에ㅐ 따른 로직 작성
	
	
	public void showBoardDetail() {
		//게시글 번호 (no) 필요함
		//출력문 추가
		
		System.out.print("조회할 게시글 번호 입력 : ");
		int no = MyUtil.scInt();
		//커넥션
		Connection conn = OracleDB.getOracleConnection();
		//쿼리
		String sql = "SELECT * FROM BOARD WHERE NO = ? AND DELETE_YN = 'N'";
		

		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
		
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				
				System.out.println("제목 : "+title );
				System.out.println("내용 : "+content );
			
			}
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//자원반납
		}
		
		
	
	
	
	
	
	
	
	
	}
	
}
