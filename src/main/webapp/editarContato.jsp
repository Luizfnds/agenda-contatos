<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="style.css">
	<title>Agenda de contatos</title>
</head>
<body>
	<h1>Editar contato</h1>
	<form name="form-novo-contato" class="form-novo-contato" action="update">
		<input class="input-idcon" type="text" name="idcon" value="<% out.print(request.getAttribute("idcon")); %>">
		<input class="input-nome" type="text" name="nome" value="<% out.print(request.getAttribute("nome")); %>">
		<input class="input-telefone" type="tel" name="telefone" value="<% out.print(request.getAttribute("telefone")); %>"> 
		<input type="email" name="email" value="<% out.print(request.getAttribute("email")); %>">

		<button class="btn1" onclick="validar()">Salvar</button>
	</form>

	<script src="scripts/validador.js"></script>
</body>
</html>