
<%@ page import="de.goopl.gplus.ActivityTrace" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'activityTrace.label', default: 'ActivityTrace')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-activityTrace" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-activityTrace" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>

						<g:sortableColumn property="createdAt" title="${message(code: 'activityTrace.createdAt.label', default: 'Created At')}" />

						<g:sortableColumn property="data" title="${message(code: 'activityTrace.data.label', default: 'Data')}" />

						<g:sortableColumn property="eventName" title="${message(code: 'activityTrace.eventName.label', default: 'Event Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${activityTraceInstanceList}" status="i" var="activityTraceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${activityTraceInstance.id}">${fieldValue(bean: activityTraceInstance, field: "createdAt")}</g:link></td>
					
						<td>${fieldValue(bean: activityTraceInstance, field: "data")}</td>
					
						<td>${fieldValue(bean: activityTraceInstance, field: "eventName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${activityTraceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
