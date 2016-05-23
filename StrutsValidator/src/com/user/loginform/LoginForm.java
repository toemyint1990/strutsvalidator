package com.user.loginform;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mysql.jdbc.PreparedStatement;
import com.user.commons.PasswordService;
import com.user.form.UserForm;

public class LoginForm extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);
		String admin_user = "admin";
		String admin_pw = "SluCFODC2mO5H8UN4m32rA==";
		UserForm registerForm = (UserForm) form;
		String username = registerForm.getUsername();
		String pwd = registerForm.getPwd();
		
		
		// String hashPwuser=null;

		String encPassword = PasswordService.getInstance().encrypt(pwd);
		 
		if(username.equals(admin_user) && encPassword.equals(admin_pw)){
			   return mapping.findForward("success5");
		   }
		else{
		// System.out.println(encPassword);

		// Date and time format
		long time = System.currentTimeMillis();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
		System.out.println("Time in milliseconds :" + timestamp);

		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM info_data WHERE userName = ? and passWord = ?";
		// String dtsql= "UPDATE info_data SET lastLogin= ? WHERE userName= ?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/test", "root", "admin");

			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, encPassword);

			// int rows = ps.executeUpdate();
			// System.out.println("Rows impacted" + rows);

			// sql =
			// "UPDATE info_data SET lastLogin= ? WHERE userName= 'toemyintthu' ?";
			// psdt =(PreparedStatement) con.prepareStatement(sql);
			// psdt.setString(1, currentTime);
			rs = ps.executeQuery();

			if (rs.next()) {
				String userdbname = rs.getString("userName");
				String userdbpw = rs.getString("passWord");
				Timestamp ctime = rs.getTimestamp(7);

			 
			   if (username.equals(userdbname)
						&& encPassword.equals(userdbpw) && ctime != null) {
					session.setAttribute("userName", userdbname);

					try {
						ps2 = (PreparedStatement) con
								.prepareStatement("UPDATE info_data SET lastLogin=? WHERE userName=? ");
						ps2.setTimestamp(1, timestamp);
						ps2.setString(2, userdbname);
						ps2.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// System.out.println(hashPwuser);

					return mapping.findForward("success1");
				} else {
					return mapping.findForward("success3");
				}

			}
			rs.close();
			ps.close();

			// psdt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return mapping.findForward("error");
	}
}
