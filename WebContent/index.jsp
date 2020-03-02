<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet" />

</head>
<body>

	<div class="container">
		<form method="post" action="LoginServlet">

		<div class="form-group" style="margin-top: 50px;">
			<div class="col-md-5 offset-md-4">
				<h2>Bem vindo ao sistema em JSP</h2>
			</div>
		</div>
		
			<div class="form-group">
				<div class=" col-md-4 offset-md-4">
					<label>Login</label> 
					<input type="text" class="form-control" name="login" placeholder="Login">
					</div>
				</div>
			
				<div class="form-group">
					<div class=" col-md-4 offset-md-4">
						<label>Password</label> 
						<input type="password" class="form-control" name="senha" placeholder="Senha">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-md-4 offset-md-4">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</div>
		</form>
	</div>


	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/bootstrap/js/jquery-3.4.1.min.js"></script>

</body>
</html>