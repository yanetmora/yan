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
					<li><a href="new-salary">New Salary</a></li>
					<li><a href="all-salaries">All Salaries</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME_SALARY'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Salaries</h1>
				</div>
			</div>
		</c:when>


	<c:when test="${mode=='MODE_SALARIES'}">
			<div class="container text-center" id="salariesDiv">
				<h3>My Salaries</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>EmpName</th>
								<th>Salary</th>
								<th>Postal Code</th>
								<th>From Date</th>
								<th>To Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="salary" items="${salaries}">
								<tr>
									<td>${salary.id}</td>
									<td>${salary.empNa}</td>
									<td>${salary.salary}</td>
									<td>${salary.postalCod}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd"
											value="${salary.fromDate}" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd"
											value="${salary.toDate}" /></td>
									<td><a href="update-salary?id=${salary.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-salary?id=${salary.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_SALARY' || mode=='MODE_UPDATE_SALARY'}">
			<div class="container text-center">
				<h3>Manage Salaries</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-salary">
					<input type="hidden" name="id" value="${salary.id}" />
					
					<div class="form-group">
						<label class="control-label col-sm-3">EmpName:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="empNa"
								value="${salary.empNa}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Salary:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="salary"
								value="${salary.salary}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Postal Code:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="postalCod"
								value="${salary.postalCod}" />
						</div>
					</div>
					
					
						<div class="form-group">
						<label class="control-label col-sm-3">FromDate:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="fromDate" pattern="yyyy-mm-dd"
								value="${salary.fromDate}" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-sm-3">ToDate:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="toDate"  pattern="yyyy-mm-dd"
								value="${salary.toDate}" />
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
									
