<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html lang="true">
<head>
</head>
<body>
 

<b>First Time Login</b>
<br/><br/>


<html:form action="/Login2">
<br/>
<bean:message key="label.user.username" /> : 
<html:text property="username" size="20"/>
<br/>
<bean:message key="label.user.pwd" /> : 
<html:password property="pwd" size="20"/>
<br/></br>
<html:submit>
<bean:message key="label.user.button.submit" />
</html:submit>
</html:form>


 
</body>
</html:html>