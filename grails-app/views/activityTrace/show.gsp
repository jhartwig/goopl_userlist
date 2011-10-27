
<%@ page import="de.goopl.gplus.ActivityTrace" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'activityTrace.label', default: 'ActivityTrace')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-activityTrace" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-activityTrace" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list activityTrace">

				<g:if test="${activityTraceInstance?.createdAt}">
				<li class="fieldcontain">
					<span id="createdAt-label" class="property-label"><g:message code="activityTrace.createdAt.label" default="Created At" /></span>

						<span class="property-value" aria-labelledby="createdAt-label"><g:formatDate date="${activityTraceInstance?.createdAt}" /></span>

				</li>
				</g:if>

				<g:if test="${activityTraceInstance?.data}">
				<li class="fieldcontain">
					<span id="data-label" class="property-label"><g:message code="activityTrace.data.label" default="Data" /></span>

						<span class="property-value" aria-labelledby="data-label"><g:fieldValue bean="${activityTraceInstance}" field="data"/></span>

				</li>
				</g:if>

				<g:if test="${activityTraceInstance?.eventName}">
				<li class="fieldcontain">
					<span id="eventName-label" class="property-label"><g:message code="activityTrace.eventName.label" default="Event Name" /></span>

						<span class="property-value" aria-labelledby="eventName-label"><g:fieldValue bean="${activityTraceInstance}" field="eventName"/></span>

				</li>
				</g:if>

			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${activityTraceInstance?.id}" />
					<g:link class="edit" action="edit" id="${activityTraceInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
