<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usuario</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet" />


</head>
<body>

	<div class="container" style="padding-top: 20px;">
		<form method="post" action="UsuarioServlet">

			<div class="form-group">
				<div class=" col-md-6 offset-md-3">
					<label>Login</label> 
					<input type="text" class="form-control" name="login" placeholder="Login">
					</div>
				</div>
			
				<div class="form-group">
					<div class=" col-md-6 offset-md-3">
						<label>Password</label> 
						<input type="password" class="form-control" name="senha" placeholder="Senha">
					</div>
				</div>
				
				<div class="form-group">
					<div class=" col-md-6 offset-md-3">
						<label>Nome</label> 
						<input type="text" class="form-control" name="nome" placeholder="Nome">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-md-8 offset-md-5">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
						<button type="reset" class="btn btn-danger">Limpar</button>
					</div>
				</div>
		</form>
	</div>

<div class="container" style="padding-top: 20px;">

	<table class="table table-bordered">
  		<thead class="thead-dark">
   		 <tr>
     	 	<th scope="col"><strong>Id</strong></th>
      		<th scope="col"><strong>Login</strong></th>
      		<th scope="col"><strong>Nome</strong></th>
      		<th scope="col"><strong>Editar</strong></th>
      		<th scope="col"><strong>Excluir</strong></th>
    	</tr>
  		</thead>
  			<tbody>
  				<c:forEach items="${ usuarios }" var="user">
    				<tr>
      					<td scope="row"><c:out value="${ user.id }"></c:out></td>
      					<td scope="row"><c:out value="${ user.login }"></c:out></td>
      					<td scope="row"><c:out value="${ user.nome }"></c:out></td>
      					<td scope="row"><a href="UsuarioServlet?acao=editar&user=${user.login }"><img alt="Editar" src="resources/img/edit.png" width="20px"></a></td>
      					<td scope="row"><a href="UsuarioServlet?acao=delete&user=${user.id }"><img alt="Excluir" src="resources/img/delete.png" width="20px"></a></td>
    				</tr>
   				</c:forEach>
  			</tbody>
	</table>
</div>

	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/bootstrap/js/jquery-3.4.1.min.js"></script>

</body>
</html>