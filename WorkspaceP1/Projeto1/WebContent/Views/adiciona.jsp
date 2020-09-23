<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*,br.edu.insper.*" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarefa</title>
</head>

<body>
	<jsp:useBean id="dao" class="br.edu.insper.DAO"/>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: orange">
		<div>
			App de Tarefas :)
		</div>
		<ul>
			<li><a href="<%=request.getContextPath()%>/Views/lista.jsp">Lista de Tarefas</a></li>
		</ul>
		
		
		</nav>
	</header>
	<form action="adiciona" method="post">
		<table>
			<tr>
				<td>Tarefa</td>
				<td><input type="text" name="nome"></td>
			</tr>
			<tr>
				<td>Data</td>
				<td><input type="date" name="entrega"></td>
			</tr>
			<tr>
				<td>Descri��o</td>
				<td><input type="text" name="descricao"></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="OK"></td>
			</tr>
		</table>
	</form>
	<br />
	

	
</body>
</html>