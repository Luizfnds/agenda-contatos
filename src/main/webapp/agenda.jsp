<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="style.css">
	<title>Agenda de contatos</title>
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="novoContato.html" class="btn1">Adicionar contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) { %>
				<tr>
					<td><%=lista.get(i).getIdcon()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getTelefone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>