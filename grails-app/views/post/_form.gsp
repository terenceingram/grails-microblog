<%@ page import="com.terenceingram.Post" %>

<g:hiddenField id="user" name="user.id" value="${session.user.id}" />

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="post.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${postInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="post.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="content" required="" value="${postInstance?.content}"/>
</div>

<!--
   <label for="img">Picture</label>
    <input type="file" name="img" id="img" />
    <div style="font-size:0.8em; margin: 1.0em;">
      For best results, your picture should not be bigger than 5mb.
    </div>
-->
