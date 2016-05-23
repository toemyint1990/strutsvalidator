package com.user.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class ResetForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;

	String newPwd;
	String oldPwd;
	String confirmPwd;
	String username;

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (oldPwd == null || oldPwd.length() < 1) {
			errors.add("oldPwd", new ActionMessage("err.user.oldPwd.required"));

		}
		if (newPwd == null || newPwd.length() < 1) {
			errors.add("newPwd", new ActionMessage("err.user.newPwd.required"));

		}
		
		if (!confirmPwd.equals(newPwd)){
			errors.add("confirmPwd",new ActionMessage( "err.user.confirmPwd.notmatch"));
		}
		
		return errors;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
}
