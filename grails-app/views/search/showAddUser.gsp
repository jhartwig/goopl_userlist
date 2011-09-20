<%--
  Created by IntelliJ IDEA.
  User: jan
  Date: 16.09.11
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Simple GSP page</title></head>

<body>Place your content here</body>
<g:form name="myForm" action="saveUser">
    <g:textField name="name" />
    <g:textField name="googleId" />
    <g:select from="${model}" name="jobDescription" noSelection="['null':'']"></g:select>
    <g:submitButton name="add" value="Hinzufügen"/>
</g:form>
</html>