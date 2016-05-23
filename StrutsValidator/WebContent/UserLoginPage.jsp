<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html lang="true">
<head>
</head>
<body bgcolor="#ADD8E6">


	


	<html:form action="/Login">


		<b><u><font
				style='font-family: "Times New Roman"; font-weight: bold'>Login Page</font>
		</u>
		</b>
		<br />
		<br />
		<TABLE>
			<TBODY>
				<TR>
					<TD style='font-family: "Times New Roman"; font-weight: bold'>Username</TD>
					<TD><html:text property="username"></html:text>
					</TD>
				</TR>
				<TR>
					<TD style='font-family: "Times New Roman"; font-weight: bold'>Password</TD>
					<TD><html:password property="pwd" size="20"></html:password>
					</TD>
				</TR>
			</TBODY>
		</TABLE>

		<html:submit>
			<bean:message key="label.user.button.submit" />
		</html:submit>
	</html:form>
	Forget Password? Click
	<a href="forgotPassword.jsp"> here </a>to reset your password
	<br> Don't have account? Click
	<a href="index.jsp"> here </a>to Signup.
	<br>

</body>
</html:html>