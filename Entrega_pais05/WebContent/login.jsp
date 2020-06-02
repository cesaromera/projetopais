<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<c:import url="Menu.jsp" />

	<div id="main" class="container">
		<h3 class="page-header">Login</h3>
		<form action="controller.do" method="post">
			<div class="row col-md-12">
				<div class="form-group">
					<div class="input-group col-md-4">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
						</div>
						<input type="text" name="login" id="login"
							class="form-control" maxlength="24" placeholder="Login" required />
					</div>
				</div>
				<div class="form-group">
					<div class="input-group col-md-4">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-option-horizontal"
								aria-hidden="true"></span>
						</div>
						<input type="password" name="senha" id="senha"
							class="form-control" placeholder="Senha" required />
					</div>
				</div>
			</div>
			<div class="row col-md-12">
				<button type="submit" class="btn btn-primary" name="command"
					value="FazerLogin">
					<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Ok
				</button>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>