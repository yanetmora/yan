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
					<li><a href="new-homolSet">New HomolSet</a></li>
					<li><a href="all-homolSets">All HomolSets</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME_HOMOLSET'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to HomolSet Manager</h1>
				</div>
			</div>
		</c:when>


	<c:when test="${mode=='MODE_HOMOLSETS'}">
			<div class="container text-center" id="homolSetsDiv">
				<h3>My HomolSets</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Symbol</th>
								<th>DbxrefId</th>
								<th>TargetGeneProductId</th>
								<th>TaxonId</th>
								<th>TypeId</th>
								<th>Description</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="homolSet" items="${homolSets}">
								<tr>
									<td>${homolSet.id}</td>
									<td>${homolSet.symbol}</td>
									<td>${homolSet.dbxrefId}</td>
									<td>${homolSet.targetGeneProductId}</td>
									<td>${homolSet.taxonId}</td>
									<td>${homolSet.typeId}</td>
									<td>${homolSet.description}</td>
									
									<td><a href="update-homolSet?id=${homolSet.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-homolSet?id=${homolSet.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		
		<c:when test="${mode=='MODE_NEW_HOMOLSET' || mode=='MODE_UPDATE_HOMOLSET'}">
			<div class="container text-center">
				<h3>Manage HomolSet</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-homolSet">
					<input type="hidden" name="id" value="${homolSet.id}" />
					
					<div class="form-group">
						<label class="control-label col-sm-3">Symbol:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="symbol"
								value="${homolSet.symbol}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">DbxrefId:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="dbxrefId"
								value="${homolSet.dbxrefId}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">TargetGeneProductId:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="targetGeneProductId"
								value="${homolSet.targetGeneProductId}" />
						</div>
					</div>					

					<div class="form-group">
						<label class="control-label col-sm-3">TaxonId:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="taxonId"
								value="${homolSet.taxonId}" />
						</div>
					</div>	
					
					<div class="form-group">
						<label class="control-label col-sm-3">TypeId:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="typeId"
								value="${homolSet.typeId}" />
						</div>
					</div>	

					<div class="form-group">
						<label class="control-label col-sm-3">Description:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="description"
								value="${homolSet.description}" />
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