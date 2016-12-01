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
					<li><a href="new-deptManager">New DeptManager</a></li>
					<li><a href="all-deptManagers">All DeptManagers</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME_DEPTMANAGER'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to DeptManager</h1>
				</div>
			</div>
		</c:when>


	<c:when test="${mode=='MODE_DEPTMANAGERS'}">
			<div class="container text-center" id="DeptManagersDiv">
				<h3>My DeptManagers</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>DeptNo</th>
								<th>EmpNo</th>
								<th>From Date</th>
								<th>To Date</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="deptManager" items="${deptManagers}">
								<tr>
									<td>${deptManager.deptNo}</td>
									<td>${deptManager.empNo}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd"
											value="${deptManager.fromDate}" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd"
											value="${deptManager.toDate}" /></td>
									<td><a href="update-deptManager?id=${deptManager.deptNo}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-deptManager?id=${deptManager.deptNo}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_DEPTMANAGER' || mode=='MODE_UPDATE_DEPTMANAGER'}">
			<div class="container text-center">
				<h3>Manage DeptManager</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-deptManager">
					<input type="hidden" name="deptNo" value="${deptManager.deptNo}" />
					
					<div class="form-group">
						<label class="control-label col-sm-3">EmpNo:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="empNo"
								value="${deptManager.empNo}" />
						</div>
					</div>
					
						<div class="form-group">
						<label class="control-label col-sm-3">FromDate:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="fromDate" pattern="yyyy-mm-dd"
								value="${deptManager.fromDate}" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-sm-3">ToDate:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="toDate"  pattern="yyyy-mm-dd"
								value="${deptManager.toDate}" />
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
									
