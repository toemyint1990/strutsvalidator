<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html lang="true">
<head>
</head>
<body bgcolor="#ADD8E6">
 
<h2>Welcome to DICOM Uploader</h2>
 


 
<font color="red">
<html:errors/>
</font>

<html:form action="/Register">
 



	<b><u><font style='font-family: "Times New Roman"; font-weight: bold'>User Registration</font></u></b>
	<br /><br />
	<TABLE>
		<TBODY>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Username*</TD>
				<TD><html:text property="username" size="20"></html:text></TD>
			</TR>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Password*</TD>
				<TD><html:password property="pwd" size="20"></html:password></TD>
			</TR>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Confirm Password*</TD>
				<TD><html:password property="pwd2"></html:password></TD>
			</TR>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Email*</TD>
				<TD><html:text property="email"></html:text></TD>
			</TR>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Alternate Email</TD>
				<TD><html:text property="email"></html:text></TD>
			</TR>
			<TR>
				<TD style='font-family: "Times New Roman"; font-weight: bold'>Phone*</TD>
				<TD><html:text property="phone"></html:text></TD>
			</TR>
			<TR>
				<TD colspan="2" align="center"><html:submit property="Submit" value="Submit"></html:submit>
				
				</TD>
			</TR>
		</TBODY>
	</TABLE>

</html:form>


 
</body>
</html:html>