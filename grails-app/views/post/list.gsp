<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
		<a href="#list-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<g:if test="${session.user}">
					<li><g:link class="create" action="create">New Post</g:link></li>
				</g:if>
			</ul>
		</div>
		
		<g:if test="${flash.message}">
	        <div class="message">${flash.message}</div>
	    </g:if>
		
		<table>
			<g:each in="${postInstanceList}" status="i" var="post">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					<td>
						
						<h2>${post.title}</h2>						

				        <p><g:formatDate format="MMMM d, yyyy - hh:mm a" date="${post.lastUpdated}"/> by ${post.user.name}</p>
						
						<br/>
						
						<p>${post.content}</p>
						
						<br/>
						
						<p>
							<g:if test="${session.user}">
								<g:form>
									[ <g:link action="delete" id="${post?.id}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">Delete</g:link> ]
								</g:form>
							</g:if>
						</p>
					
					</td>
				</tr>
			</g:each>
		</table>
		
	</body>
</html>
