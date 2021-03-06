package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemp {
		
			public static Connection getConnection() {
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String dbid = "C##KH";
				String dbPwd = "KH";
				Connection conn = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, dbid, dbPwd);
					conn.setAutoCommit(true);
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return conn;
			}
			public static void close (Connection conn) {
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			public static void close (Statement stmt) {
				if(stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			public static void close (ResultSet rs) {
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			public static void commit(Connection conn) {
				if (conn != null)
					try {
						conn.commit();	
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			public static void rollback(Connection conn) {
				if (conn != null)
					try {
						conn.rollback();	
					} catch (SQLException e) {
						e.printStackTrace();
					}
		}
}

