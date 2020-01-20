<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usuário</title>

<link rel="stylesheet" href="resources/css/cadastro_usuario.css">

</head>
<body>

	<h2>Cadastro de usuário</h2>

<form method="post" action="UsuarioServlet">
<ul class="form-style-1">
    <li><label>Nome: <span class="required">*</span></label>
    <input type="text" name="nome" class="field-divided" placeholder="Nome" /> 
    </li>
    
    <li>
        <label>Login: <span class="required">*</span></label>
        <input type="text" name="login" class="field-divided" placeholder="Login"/>
    </li>
    
    <li>
         <label>Senha: <span class="required">*</span></label>
        <input type="password" name="senha" class="field-divided" placeholder="Senha" />
    </li>
  
    <li>
        <input type="submit" value="Submit" />
    </li>
</ul>
</form>



<div >
	<table border="1" >
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Login</th>
				<th>Excluir</th>
				<th>Editar</th>
			</tr>
			
		</thead>
		<c:forEach items="${usuarios}" var="user">
			
			<tr>
				<td style="width: 2px;!important"><c:out value="${user.id}"></c:out></td>
				<td style="width: 10px;!important"><c:out value="${user.login}"></c:out></td>
				<td style="width: 10px;!important"><c:out value="${user.senha}"></c:out></td>
				<td style="width: 5px;!important"><a href="UsuarioServlet?acao=delete&user=${user.login}">Excluir</a></td>
				<td style="width: 5px;!important"><a href="UsuarioServlet?acao=editar&user=${user.login}">Editar</a></td>
			</tr>
		
		</c:forEach>
	</table>
	</div>

</body>
</html>