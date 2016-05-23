


	package com.user.action;

	//import java.security.MessageDigest;

	import javax.servlet.http.HttpServletRequest;

	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;
	 

	import org.apache.struts.action.Action;
    import org.apache.struts.action.ActionErrors;
	import org.apache.struts.action.ActionForm;
	import org.apache.struts.action.ActionForward;
	import org.apache.struts.action.ActionMapping;
	 

	import com.user.form.UserForm;
    import com.user.commons.PasswordService;
    import com.user.form.ResetForm;
import com.user.dao.UserDAO;
			 
			public class PasswordReset extends Action {
			    public ActionForward execute(ActionMapping mapping, ActionForm form,
			            HttpServletRequest request, HttpServletResponse response)
			            throws Exception {
			        HttpSession ses = request.getSession(false);
			        
			     
			        ResetForm resetForm = (ResetForm) form;
			       
			        String username = resetForm.getUsername();
			        
			        String pwd      = resetForm.getOldPwd();
			        String newpwd   = resetForm.getNewPwd();
			       
			        //String oldpwd   = registerForm.getOldPwd();
			        //String cpwd     = registerForm.getConfirmPwd();
			        UserDAO obj = new UserDAO();
			        //System.out.println("entered encrypting old passowrd"  +PasswordService.getInstance().encrypt(pwd));
			        //System.out.println("database encrypting old passowrd" +obj.getPassword(username));
			        //System.out.println("encrypting new password"          +PasswordService.getInstance().encrypt(newpwd));
			        
			        try 
					{
						
						
						String oldEncryptedPasswordInDb = obj.getPassword(username);
						String oldEncryptedPasswordFromUser = PasswordService.getInstance().encrypt(pwd);

						if (oldEncryptedPasswordInDb.equals(oldEncryptedPasswordFromUser)) 
						{
							String encryptedNewPassword = PasswordService.getInstance().encrypt(newpwd);
							obj.updatePassword(username, encryptedNewPassword);
						} 
						else 
						{
							System.out.println("Incorrect old password");
						}
						// do something here

					} 
					catch (Exception e) 
					{

						e.printStackTrace();
					}

					
			       return mapping.findForward("success2");
				
			}
	}


