package com.user.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.user.form.EditInfoForm;

public class EditInfoAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost/test", "root", "admin");
    Statement state= null;
    EditInfoForm registerForm = (EditInfoForm) form;
    String username = registerForm.getUsername_changed();
    String email_change = registerForm.getEmail_changed();
    //String pwd2 = registerForm.getPwd2();
    String phone_change = registerForm.getPhno_changed();
  //Date and time format    
    //long time = System.currentTimeMillis();
    //java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
    //System.out.println("Time in milliseconds :" + timestamp);
	
	try {
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
	
		String sql = "UPDATE info_data SET email='" + email_change + "', lastLogin='" + sqlDate + "', number='" + phone_change + "' WHERE userName='" + username + "'";
			state=con.createStatement();
			state.executeUpdate(sql);
			

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Updated info successfully");
	
	return mapping.findForward("success6");
	}
}
