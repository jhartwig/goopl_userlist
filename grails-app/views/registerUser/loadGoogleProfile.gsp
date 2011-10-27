<%--
  Created by IntelliJ IDEA.
  User: jan
  Date: 30.09.11
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Simple GSP page</title></head>

<body>Place your content here</body>
<g:form name="myForm" action="saveProfileToDb">
    <g:textField name="aboutMe" value="${model.user?.aboutMe}"/>
    <g:textField name="gpId" value="${model.user?.googleId}"/> nicht ändern
    <g:select name="jobs" value="${model.jobs?.id}"
              noSelection="${['null':'Select at least One...']}"
              from='${model.jobs}'
              optionKey="id" optionValue="jobDescription"></g:select>
    <g:submitButton name="update" value="Speichern"/>
</g:form>
<g:form name="myForm2" action="saveProfileToDb" params="[gpId: model.user?.googleId]">
    <g:submitButton name="delete" value="löschen"/>
</g:form>
<g:form name="myForm3" action="saveProfileToDb" params="[gpId: model.user?.googleId]">
    <g:submitButton name="cancel" value="Abbrechen"/>
</g:form>

</html>