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
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container border border-2 border-primary">
		<a href="/logout">LOGOUT</a>
		<a href="/homepage">HOMEPAGE</a>
		<h1>Team Name: <c:out value="${team.name}"/></h1>
		<h2>Skill Level: <c:out value="${team.skill}"/></h2>
		<h2>Game Day: <c:out value="${team.gameday}"/></h2>
		<h2>Team Creator: <c:out value="${team.user.username}"/></h2>
		
		<c:if test="${userId == team.user.id}">
			<a class="btn btn-warning" href="/edit/team/${team.id}">EDIT</a>
			<form action="/delete/team/${team.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input class="btn btn-danger" type="submit" value="DELETE">
			</form>
		</c:if>
		
	</div>
</body>
</html>