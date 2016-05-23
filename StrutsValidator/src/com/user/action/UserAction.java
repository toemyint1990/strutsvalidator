package com.user.action;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 

import com.user.form.UserForm;
import com.user.commons.PasswordService;
import com.user.dao.UserDAO;
		 
		public class UserAction extends Action {
		    public ActionForward execute(ActionMapping mapping, ActionForm form,
		            HttpServletRequest request, HttpServletResponse response)
		            throws Exception {
		        HttpSession ses = request.getSession(true);
		 
		        UserForm registerForm = (UserForm) form;
		        String username = registerForm.getUsername();
		        String pwd = registerForm.getPwd();
		        //String pwd2 = registerForm.getPwd2();
		        String email = registerForm.getEmail();
		        String phone = registerForm.getPhone();
		        
		        
		       try{
		    		
		    		String hashPassword = PasswordService.getInstance().encrypt(pwd);
		    		
		       
		      
		        
		       
		        UserDAO dao = new UserDAO();
		        dao.insertData(username, hashPassword, email, phone);
		        ses.setAttribute("username", username);
		        ses.setAttribute("pwd", hashPassword);
		        //ses.setAttribute("pwd2", hashPw2);
		        ses.setAttribute("email", email);
		        ses.setAttribute("phone", phone);
		       
		       
		          }
		       
		       catch(Exception e)
		       {
		           e.printStackTrace();
		           
		       }
		 
		       return mapping.findForward("success");
			
		}
}
