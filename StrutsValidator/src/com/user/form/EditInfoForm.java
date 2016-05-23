package com.user.form;


	import javax.servlet.http.HttpServletRequest;

	import org.apache.struts.action.ActionErrors;
	import org.apache.struts.action.ActionMapping;
	import org.apache.struts.action.ActionMessage;
	import org.apache.struts.validator.ValidatorForm;

	public class EditInfoForm extends ValidatorForm {

		private static final long serialVersionUID = 1L;

		String username_changed;
		String email_changed;
		String phno_changed;

		public ActionErrors validate(ActionMapping mapping,
				HttpServletRequest request) {
			ActionErrors errors = new ActionErrors();
			if (username_changed == null || username_changed.length() < 1) {
				errors.add("username_changed", new ActionMessage("err.user.username_changed.required"));

			}
			if (email_changed == null || email_changed.length() < 6) {
				errors.add("newPwd", new ActionMessage("err.user.newPwd.required"));

			}
			
			
			return errors;
		}

		public String getPhno_changed() {
			return phno_changed;
		}

		public void setPhno_changed(String phno_changed) {
			this.phno_changed = phno_changed;
		}

		public String getEmail_changed() {
			return email_changed;
		}

		public void setEmail_changed(String email_changed) {
			this.email_changed = email_changed;
		}

		public String getUsername_changed() {
			return username_changed;
		}

		public void setUsername_changed(String username_changed) {
			this.username_changed = username_changed;
		}
	}


