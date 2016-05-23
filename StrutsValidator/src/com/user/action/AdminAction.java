package com.user.action;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.user.form.UserForm;
import com.user.form.EditInfoForm;

public class AdminAction extends DispatchAction {

	public ActionForward create(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		return mapping.findForward("success4");
		

	}

	public ActionForward update(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		
		
		return mapping.findForward("success5");

	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response)

	throws Exception {

		return mapping.findForward("success4");

	}

}
