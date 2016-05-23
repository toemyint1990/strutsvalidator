package com.user.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


		import java.util.ArrayList;

		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;

		import org.apache.struts.action.Action;
		
		import org.apache.struts.action.ActionErrors;
		import org.apache.struts.action.ActionForm;
		import org.apache.struts.action.ActionForward;
		import org.apache.struts.action.ActionMapping;

		import com.user.form.UserForm;
		import com.user.commons.PasswordService;
		import com.user.dao.UserDAO;
		import com.user.commons.*;
		

		
		public class ForgotPasswordAction extends Action

		{

			public ActionForward execute(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {

				ActionErrors errors = new ActionErrors();
				ActionForward forward = new ActionForward(); // return value
				UserForm forgotPassForm  = (UserForm) form;
				UserDAO obj = new UserDAO();
				

				try {
					
					String username = forgotPassForm.getUsername();
					String email = forgotPassForm.getEmail();
					String password = obj.getPassword(username);
					

					if (password!="") 
					{
						ArrayList<String> recepients = new ArrayList<String>();
						
						recepients.add(email);
					    String subject = "VCS - your password";
					    String message = "Hi "+ username+"\n"
					    			+ "Your password for "+username +" is "+password+"\n\n\n"
					    			+"Password instructions:\n" +
					    			"1. Please donot share your password with any known/unknown persons.\n" +
					    			"2.DO NOT USE birthdays, names or other passwords which would be easy to guess, " +
					    			"the idea is to choose something which does not reside in any dictionary or in any language. \n" +
					    			"3. Never write your password down on paper or anything else which could be read by another person, " +
					    			"i.e., DO NOT PUT A POST-IT WITH YOUR PASSWORD WRITTEN ON IT AND ATTACH IT TO YOUR MONITOR (or under your mouse pad).\n" +
					    			"\n" +
					    			"------\n" +
					    			"Regards,\n" +
					    			"VCS - Administrator";

					   mailBean mb = new mailBean();
					   mb.setMailSubject(subject);
					   mb.setMsgContent(message);
					   mb.setToRecipients(recepients);
					   
					   emailUtility.sendMail(mb);
					} else 
					{
						System.out.println("Incorrect email cannot be sent");
					}
					// do something here

				} catch (Exception e) {

					e.printStackTrace();// Report the error using the appropriate name and ID.
					

				}

				

				
				
		return mapping.findForward("success4");
	}
}
