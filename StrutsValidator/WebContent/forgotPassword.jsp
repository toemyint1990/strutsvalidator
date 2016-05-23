<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html lang="true">
<head>
</head>
<body bgcolor="#ADD8E6">
 

 


 
<font color="red">
<html:errors/>
</font>

<html:form action="/ForgotPassword">

<b><u><font style='font-family: "Times New Roman"; font-weight: bold'>Enter your details</font></u></b>
	<br /><br />
	<TABLE>
		<TBODY>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Username</TD>
				<TD><html:text property="username" size="20"></html:text></TD>
			</TR>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Email</TD>
				<TD><html:text property="email" size="20"></html:text></TD>
			</TR>
			</TBODY>
			</TABLE>
			
			
 


<html:submit>
<bean:message key="label.user.button.submit" />
</html:submit>

 </html:form>
 
</body>
</html:html>