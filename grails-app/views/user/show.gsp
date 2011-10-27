
<%@ page import="de.goopl.gplus.User" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-user" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list user">
			
				<g:if test="${userInstance?.googleId}">
				<li class="fieldcontain">
					<span id="googleId-label" class="property-label"><g:message code="user.googleId.label" default="Google Id" /></span>
					
						<span class="property-value" aria-labelledby="googleId-label"><g:fieldValue bean="${userInstance}" field="googleId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.gender}">
				<li class="fieldcontain">
					<span id="gender-label" class="property-label"><g:message code="user.gender.label" default="Gender" /></span>
					
						<span class="property-value" aria-labelledby="gender-label"><g:fieldValue bean="${userInstance}" field="gender"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.aboutMe}">
				<li class="fieldcontain">
					<span id="aboutMe-label" class="property-label"><g:message code="user.aboutMe.label" default="About Me" /></span>
					
						<span class="property-value" aria-labelledby="aboutMe-label"><g:fieldValue bean="${userInstance}" field="aboutMe"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.tagline}">
				<li class="fieldcontain">
					<span id="tagline-label" class="property-label"><g:message code="user.tagline.label" default="Tagline" /></span>
					
						<span class="property-value" aria-labelledby="tagline-label"><g:fieldValue bean="${userInstance}" field="tagline"/></span>
					
				</li>
				</g:if>

                <g:if test="${userInstance?.cityTags}">
				<li class="fieldcontain">
					<span id="tagline-label" class="property-label"><g:message code="user.citytags.label" default="CityTags" /></span>

						<span class="property-value" aria-labelledby="citytags-label"><g:fieldValue bean="${userInstance}" field="cityTags"/></span>

				</li>
				</g:if>

                <g:if test="${userInstance?.skillTags}">
				<li class="fieldcontain">
					<span id="tagline-label" class="property-label"><g:message code="user.skilltags.label" default="SkillTags" /></span>

						<span class="property-value" aria-labelledby="skilltags-label"><g:fieldValue bean="${userInstance}" field="skillTags"/></span>

				</li>
				</g:if>

                <g:if test="${userInstance?.jobTags}">
				<li class="fieldcontain">
					<span id="tagline-label" class="property-label"><g:message code="user.jobtags.label" default="JobTags" /></span>

						<span class="property-value" aria-labelledby="jobtags-label"><g:fieldValue bean="${userInstance}" field="jobTags"/></span>

				</li>
				</g:if>

				<g:if test="${userInstance?.displayName}">
				<li class="fieldcontain">
					<span id="displayName-label" class="property-label"><g:message code="user.displayName.label" default="Display Name" /></span>
					
						<span class="property-value" aria-labelledby="displayName-label"><g:fieldValue bean="${userInstance}" field="displayName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${userInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="user.url.label" default="Url" /></span>

                        <span class="property-value" aria-labelledby="url-label"><g:link url="${userInstance.url}">${userInstance.url}</g:link></span>
				</li>
				</g:if>
			
				<g:if test="${userInstance?.jobStatus}">
				<li class="fieldcontain">
					<span id="jobStatus-label" class="property-label"><g:message code="user.jobStatus.label" default="Job Status" /></span>
					
						<span class="property-value" aria-labelledby="jobStatus-label"><g:formatBoolean boolean="${userInstance?.jobStatus}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${userInstance?.id}" />
					<g:link class="edit" action="edit" id="${userInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
