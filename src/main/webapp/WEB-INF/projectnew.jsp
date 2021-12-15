<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>

<!--/////////////////////////////////////////////////////
//	DASHBOARD JSP
///////////////////////////////////////////////////////// -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- //// CSS LINKS //////////////////////////////////////// -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Project Manager</title>
</head>
<body>
	<!-- //// HEADER /////////////////////////////////////////// -->
	<header>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<a href="/" class="col-8 navbar-brand"> <strong
					class="text-warning">PROJECT MANAGER</strong>
				</a>
				<div class="col-4 row align-items-center">
					<p class="col text-white m-2">${ user_fname }</p>
					<button class="col btn btn-info btn-sm round m-2"
						onclick="window.location.href='/dashboard';">Home</button>
					<button class="col btn btn-danger btn-sm round"
						onclick="window.location.href='/logout';">Log-Out</button>
				</div>
			</div>
		</div>
	</header>

	<!-- //// MAIN AREA //////////////////////////////////////// -->
	<main role="main">
		<div class="container mt-4">
			<div class="row">
				<h1>Enter a new project</h1>
				<form:form action="/project/new" method="post"
					modelAttribute="newProject">
					<!-- **** Set Leader as User **** -->
					<form:hidden path="leader" value="${user_id}" />
					<p class="form-group">
						<form:label path="title">Project Title:</form:label>
						<strong> <form:errors path="title"
								class="alert text-danger" />
						</strong>
						<form:input class="form-control mb-3" path="title" />
					</p>
					<p class="form-group">
						<form:label path="description">Description</form:label>
						<form:textarea class="form-control mb-3" path="description" />
						<form:errors path="description" class="alert alert-danger mb-3" />
					</p>
					<p>
						<form:label path="dueDate">Due Date:</form:label>
						<strong> <form:errors path="dueDate"
								class="alert text-danger" />
						</strong>
						<form:input class="form-control mb-3" type="date" path="dueDate" />
					</p>
					<input class="btn btn-success mb-3" type="submit"
						value="Submit New Project" />
				</form:form>
			</div>
		</div>
	</main>

	<!-- //// JAVASCRIPT LINKS ///////////////////////////////// -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>