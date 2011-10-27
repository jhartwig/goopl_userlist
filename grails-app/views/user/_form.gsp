<%@ page import="de.goopl.gplus.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'googleId', 'error')} ">
	<label for="googleId">
		<g:message code="user.googleId.label" default="Google Id" />
		
	</label>
	<g:textField name="googleId" value="${userInstance?.googleId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'gender', 'error')} ">
	<label for="gender">
		<g:message code="user.gender.label" default="Gender" />
		
	</label>
	<g:textField name="gender" maxlength="10" value="${userInstance?.gender}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'aboutMe', 'error')} ">
	<label for="aboutMe">
		<g:message code="user.aboutMe.label" default="About Me" />
		
	</label>
	<g:textField name="aboutMe" value="${userInstance?.aboutMe}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'tagline', 'error')} ">
	<label for="tagline">
		<g:message code="user.tagline.label" default="Tagline" />
		
	</label>
	<g:textArea name="tagline" cols="40" rows="5" maxlength="255" value="${userInstance?.tagline}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'cityTags', 'error')} ">
	<label for="cityTags">
		<g:message code="user.tagline.label" default="CityTags" />

	</label>
	<g:textArea name="cityTags" cols="40" rows="5" maxlength="255" value="${userInstance?.cityTags?.join(/, /)}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'skillTags', 'error')} ">
	<label for="skillTags">
		<g:message code="user.tagline.label" default="SkillTags" />

	</label>
	<g:textArea name="skillTags" cols="40" rows="5" maxlength="255" value="${userInstance?.skillTags?.join(/, /)}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'jobTags', 'error')} ">
	<label for="jobTags">
		<g:message code="user.tagline.label" default="JobTags" />

	</label>
	<g:textArea name="jobTags" cols="40" rows="5" maxlength="255" value="${userInstance?.jobTags?.join(/, /)}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'displayName', 'error')} ">
	<label for="displayName">
		<g:message code="user.displayName.label" default="Display Name" />
		
	</label>
	<g:textField name="displayName" maxlength="100" value="${userInstance?.displayName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="user.url.label" default="Url" />
		
	</label>
	<g:field type="url" name="url" value="${userInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'jobStatus', 'error')} ">
	<label for="jobStatus">
		<g:message code="user.jobStatus.label" default="Job Status" />
		
	</label>
	<g:checkBox name="jobStatus" value="${userInstance?.jobStatus}" />
</div>

