<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Boot Sample | Home</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-title">New Title</a></li>
					<li><a href="all-titles">All Titles</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME_TITLE'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Titles</h1>
				</div>
			</div>
		</c:when>


	<c:when test="${mode=='MODE_TITLES'}">
			<div class="container text-center" id="titlesDiv">
				<h3>My Titles</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>EmpNo</th>
								<th>Title</th>
								<th>From Date</th>
								<th>To Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="title" items="${titles}">
								<tr>
									<td>${title.empNo}</td>
									<td>${title.title}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd"
											value="${title.fromDate}" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd"
											value="${title.toDate}" /></td>
									<td><a href="update-title?id=${title.empNo}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-title?id=${title.empNo}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_TITLE' || mode=='MODE_UPDATE_TITLE'}">
			<div class="container text-center">
				<h3>Manage Titles</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-title">
					<input type="hidden" name="empNo" value="${title.empNo}" />
					
					<div class="form-group">
						<label class="control-label col-sm-3">Title:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="title"
								value="${title.title}" />
						</div>
					</div>
					
						<div class="form-group">
						<label class="control-label col-sm-3">FromDate:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="fromDate" pattern="yyyy-mm-dd"
								value="${title.fromDate}" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-sm-3">ToDate:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="toDate"  pattern="yyyy-mm-dd"
								value="${title.toDate}" />
						</div>
					</div>
					

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>

</c:choose>

<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>

</body>
</html>
								