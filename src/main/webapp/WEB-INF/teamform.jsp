<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!-- For JSTL Forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert name here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container border border-2 border-primary">
		<a href="/logout">LOGOUT</a>
		<a href="/homepage">HOMEPAGE</a>
		<h1>CREATE NEW TEAM</h1>
		
			<form:form action="/create/team" method="post" modelAttribute="team">
			<p>
				<form:label path="name">Team Name</form:label>
				<form:errors class="text-danger" path="name"/>
				<form:input class="w-100" path="name"/>
			</p>
			<p>
				<form:label path="skill">Skill Level (1-5)</form:label>
				<form:errors class="text-danger" path="skill"/>
				<form:input class="w-100" path="skill"/>
			</p>
			<p>
				<form:label path="gameday">Game Day</form:label>
				<form:errors class="text-danger" path="gameday"/>
				<form:input class="w-100" path="gameday"/>
			</p>
				
			<input type="submit" class="btn btn-primary" value="SUBMIT NEW TEAM"/>
		</form:form>
		
	</div>
</body>
</html>