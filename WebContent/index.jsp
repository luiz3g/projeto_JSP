<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" href="resources/css/estilo.css">

</head>
<body>


	<div class="login-page">
		<div class="form">

			<form class="login-form" action="UsuarioServlet" method="post">
				<input type="text" placeholder="username" name="login" />
				 <input type="password"	placeholder="password" name="senha"/>
				<button type="submit">login</button>
			</form>
		</div>
	</div>



</body>
</html>