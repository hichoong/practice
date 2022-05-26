package com.kim.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kim.db.OracleDB;
import com.kim.util.MyUtil;

public class Member {
	
	public static int loginUserNo;	
	
	public boolean login() {
		System.out.println("========로그인==========");
		System.out.print("아이디 : ");
		String id = MyUtil.sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = MyUtil.sc.nextLine();
		
		
		//DB 연결 얻기
		Connection conn =  OracleDB.getOracleConnection();
		//해당 아이디에 맞는 패스워드 조회하기(DB)
		String sql = "SELECT NO, PWD FROM MEMBER WHERE ID = ?"; //패스워드를 조회하는데 id가 ? 인 친구의 pwd를 조회
		//String sql = "SELECT PWD FROM MEMBER WHERE UPPER(ID) = UPPER(?)"; 대소문자 구분없이
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbPwd = rs.getString("PWD"); // 첫번째 칼럼의 행을 조회 
				int no = rs.getInt("NO");
				if(dbPwd.equalsIgnoreCase(pwd)) {
					//로그인 성공
					loginUserNo = no;
					System.out.println("로그인 성공!!!");
					return true;
				}
			}
		
		
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
		}finally {
			OracleDB.close(conn);
			OracleDB.close(pstmt);
			OracleDB.close(rs);
		}
		System.out.println("로그인 실패...");
		return false;
		//DB에서 조회한 패스워드가 일치하는지 확인
	}
	
	
	//회원가입
	
	/*
	 * 아이디, 비번, 닉네임 입력받기
	 * 아이디 중복 검사
	 * 비밀번호 유효성 검사(8글자 이상인지)
	 * 디비에 저장
	 * 
	 */
	public boolean join() {	
		System.out.println("========회원가입==========");
		System.out.print("아이디 : ");
		String id = MyUtil.sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = MyUtil.sc.nextLine();
		System.out.print("닉네임 : ");
		String nick = MyUtil.sc.nextLine();
		//비번 유효성 검사
		if(pwd.length() < 4) {
			//회원가입 실패
			System.out.println("비밀번호는 4글자 이상이어야 합니다.");
			return false;
		}
		
		//아이디 중복 검사
		//1. 디비 접속
		Connection conn = OracleDB.getOracleConnection();
		//2. 디비에서 현재 아이디와 일치하는 아이디 조회
		try {
			String sql = "SELECT * FROM MEMBER WHERE ID = ?";
//			Statement stmtDup = conn.createStatement(); 
//			ResultSet rs = stmtDup.executeQuery(sql);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				//중복된 아이디 회원가입 실패
				System.out.println("아이디 중복!!!");
				return false;
			}
		//디비에 데이터 저장
		//3 회원가입성공? 디비 저장
			String sqlInsert = "INSERT INTO MEMBER(NO,ID,PWD,NICK) "
					+ "VALUES(MEMBER_NO_SEQ.NEXTVAL,?,?,?)";
//			Statement stmtInsert = conn.createStatement();
//			int result = stmtInsert.executeUpdate(sqlInsert);
			PreparedStatement pstmt2 = conn.prepareStatement(sqlInsert);
			pstmt2.setString(1, id);
			pstmt2.setString(2, pwd);
			pstmt2.setString(3, nick);
			int result = pstmt2.executeUpdate();
			if(result == 1) {
				System.out.println("회원가입 성공!!!");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("회원가입 실패!!");
		return false;
	}
}
