<%--
  Created by IntelliJ IDEA.
  User: jan
  Date: 26.09.11
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
  <body>Place your content here</body>
%{--app.version=${metadata.'app.version'}--}%
<g:form name="myForm" action="loadGoogleProfile">
    <g:textField name="gpId" />
    <g:submitButton name="add" value="Hinzufügen"/>
</g:form>
</html>