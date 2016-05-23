<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to DICOM Uploader</title>
</head>
<body bgcolor="#ADD8E6">

<html:errors></html:errors>
<html:form action="/Edit">

	<b><u><font style='font-family: "Times New Roman"; font-weight: bold'>Profile Management</font></u></b>
	<br /><br />
	<TABLE>
		<TBODY>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Username</TD>
				<TD><html:text property="username_changed"></html:text></TD>
			</TR>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Email</TD>
				<TD><html:text property="email_changed"></html:text></TD>
			</TR>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Phone</TD>
				<TD><html:text property="phno_changed"></html:text></TD>
			</TR>
			
			<TR>
				<TD colspan="2" align="center"><html:submit property="Submit" value="Submit"></html:submit>
				
				</TD>
			</TR>
		</TBODY>
	</TABLE>

</html:form>


</body>
</html>
