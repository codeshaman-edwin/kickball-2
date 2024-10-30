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
		
		<h1>HOMEPAGE</h1>
		<h2>Welcome Back: <c:out value="${user.username}"/></h2>
		
		<table class = "table table-dark table-striped">
			<thead>
				<tr>
					<th>Team Name</th>
					<th>Skill Level</th>
					<th>Game Day</th>
					<th>Team Creator</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" items="${teams}">
					<tr>
						<td><a href="/view/team/${team.id}"><c:out value="${team.name}"/></a></td>
						<td><c:out value="${team.skill}"/></td>
						<td><c:out value="${team.gameday}"/></td>
						<td><c:out value="${team.user.username}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="/team/form" class="btn btn-primary">CREATE NEW TEAM</a>
		
	</div>
</body>
</html>