
<%@ page import="de.goopl.gplus.User" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-user" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="googleId" title="${message(code: 'user.googleId.label', default: 'Google Id')}" />

                        <g:sortableColumn property="displayName" title="${message(code: 'user.googleId.label', default: 'Display Name')}" />

						<g:sortableColumn property="gender" title="${message(code: 'user.gender.label', default: 'Gender')}" />

                        <g:sortableColumn property="cityTags" title="${message(code: 'user.gender.label', default: 'City Tags')}" />

                        <g:sortableColumn property="skillTags" title="${message(code: 'user.gender.label', default: 'Skill Tags')}" />

                        <g:sortableColumn property="jobTags" title="${message(code: 'user.gender.label', default: 'Job Tags')}" />

						<g:sortableColumn property="aboutMe" title="${message(code: 'user.aboutMe.label', default: 'About Me')}" />
					
						<g:sortableColumn property="tagline" title="${message(code: 'user.tagline.label', default: 'Tagline')}" />
					
						<g:sortableColumn property="createdAt" title="${message(code: 'user.createdAt.label', default: 'Created At')}" />
					
						<g:sortableColumn property="updatedAt" title="${message(code: 'user.updatedAt.label', default: 'Updated At')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "googleId")}</g:link></td>
					
						<td>${fieldValue(bean: userInstance, field: "displayName")}</td>

                        <td>${fieldValue(bean: userInstance, field: "gender")}</td>

                        <td>${fieldValue(bean: userInstance, field: "cityTags")}</td>

                        <td>${fieldValue(bean: userInstance, field: "skillTags")}</td>

                        <td>${fieldValue(bean: userInstance, field: "jobTags")}</td>

						<td>${fieldValue(bean: userInstance, field: "aboutMe")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "tagline")}</td>
					
						<td><g:formatDate date="${userInstance.createdAt}" /></td>
					
						<td><g:formatDate date="${userInstance.updatedAt}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
