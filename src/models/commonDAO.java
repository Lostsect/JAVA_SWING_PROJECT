package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;

public class commonDAO {
	private static final String url = "jdbc:mysql://222.119.100.89:3382/attendance";
	private static final String user = "attendance";
	private static final String password = "codehows213";
	@Getter
	private PreparedStatement pstmt;
	@Getter
	private Connection conn;
	@Getter
	private ResultSet rs;

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (conn != null)
				conn.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
