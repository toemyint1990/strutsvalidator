<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html lang="true">
<head>
</head>
<body bgcolor="#ADD8E6">
 

<b>Reset Password</b>
<br/><br/>
<div style="color:red">
    <html:errors />
    </div>


<html:form action="/resetPwd">
<br/>


<bean:message key="label.user.username" /> : 
<html:text property="username" size="20"/>
<br/></br>
<bean:message key="label.user.oldpwd" /> : 
<html:password property="oldPwd" size="20"/>
<br/></br>
<bean:message key="label.user.newpwd" /> : 
<html:password property="newPwd" size="20"/>
<br/></br>
<bean:message key="label.user.cpwd" /> : 
<html:password property="confirmPwd" size="20"/>
<br/></br>
<html:submit>
<bean:message key="label.user.button.submit" />
</html:submit>
</html:form>

 
</body>
</html:html>