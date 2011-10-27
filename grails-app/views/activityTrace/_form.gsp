<%@ page import="de.goopl.gplus.ActivityTrace" %>



<div class="fieldcontain ${hasErrors(bean: activityTraceInstance, field: 'createdAt', 'error')} required">
	<label for="createdAt">
		<g:message code="activityTrace.createdAt.label" default="Created At" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="createdAt" precision="day"  value="${activityTraceInstance?.createdAt}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: activityTraceInstance, field: 'data', 'error')} ">
	<label for="data">
		<g:message code="activityTrace.data.label" default="Data" />
		
	</label>
	<g:textField name="data" value="${activityTraceInstance?.data}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityTraceInstance, field: 'eventName', 'error')} ">
	<label for="eventName">
		<g:message code="activityTrace.eventName.label" default="Event Name" />
		
	</label>
	<g:textField name="eventName" value="${activityTraceInstance?.eventName}"/>
</div>

