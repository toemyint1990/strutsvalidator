<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

	
	

<html:html>
<body bgcolor="#ADD8E6">
<html:form action="/UserManagement">


<%@include file="../displayCal.jsp"%>

<title>Admin</title>
 
 <h3>Admin Homepage</h3>
    <h2>User Management</h2>
    
    <html:link href="UserManagement.do?parameter=create">Create User</html:link>
     |
    <html:link href="UserManagement.do?parameter=delete">Delete User</html:link>
     |
    <html:link href="UserManagement.do?parameter=update">Update User</html:link>
     | 
    <html:link href="UserManagement.do?parameter=block">Block User</html:link>
     |
     <html:link href="UserManagement.do?parameter=block">Status</html:link>
     |


					
			

	<a href=logout.jsp>Logout</a>
</html:form>
</body>
</html:html>