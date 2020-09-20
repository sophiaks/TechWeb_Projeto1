<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pessoas</title>
</head>
<body>
	<%@ page import="java.util.*, br.insper.edu.*" %>
	<table border="1">
	<% DAO dao = new DAO();
		List<Pessoa> pessoas = dao.getLista();
		for (Pessoa pessoa : pessoas) { %>
		<tr>
			<td><%=pessoa.getNome() %></td>
			<td><%=pessoa.getNascimento().getTime() %></td>
			<td><%=pessoa.getAltura() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>