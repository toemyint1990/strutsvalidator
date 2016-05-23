package com.user.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCode {

	public static void main(String[] args) {
		String userdbName, userdbName1;
		String userdbPsw, userdbPsw1;
		String dbUsertype, dbUsertype1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test",
					"root", "admin");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "select * from reg_info where userName=? and passWord=?";

		// String name = request.getParameter("name");
		// String password = request.getParameter("password");
		String name = "";
		String password = "";
		String driverName = "";
		String url = "";
		String user = "";
		String pass = "";
		String sql1;
		if ((!(name.equals(null) || name.equals("")) && !(password.equals(null) || password
				.equals("")))) {
			try {
				Class.forName(driverName);
				con = DriverManager.getConnection(url, user, pass);
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, password);
				rs = ps.executeQuery();

				if (rs.next()) {
					userdbName = rs.getString("USERNAME");
					userdbPsw = rs.getString("PASSWORD");

					if (name.equals(userdbName) && password.equals(userdbPsw)) {
						// session.setAttribute("name",userdbName);
						// response.sendRedirect("welcome.jsp");
					}
				} else
					rs.close();
				ps.close();
			} catch (SQLException sqe) {
				System.out.println(sqe);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
		}
	}

}
