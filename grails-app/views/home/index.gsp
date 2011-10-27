<%--
  Created by IntelliJ IDEA.
  User: jan
  Date: 17.10.11
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Simple GSP page</title></head>
  <body>
  <g:link controller="searchable" action="index">Search</g:link>
  <g:link controller="user" action="index">Users</g:link>
  <g:link controller="activityTrace" action="index">Activity Trace</g:link>
  <div id="version"><g:meta name="app.version"/></div>
  <div id="host">${java.net.InetAddress.getLocalHost().hostAddress}:${request.getLocalPort()}</div>
</html>